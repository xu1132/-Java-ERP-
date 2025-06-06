package com.xuyi.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xuyi.dao.GoodsDao;
import com.xuyi.dao.OverflowListGoodsDao;
import com.xuyi.dao.UserDao;
import com.xuyi.domain.ServiceVO;
import com.xuyi.domain.SuccessCode;

import com.xuyi.entity.*;
import com.xuyi.service.LogService;
import com.xuyi.service.OverflowListGoodsService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xuyi
 * @date 2022/11/03 7:49
 * @description
 */
@Service
public class OverflowListGoodsServiceImpl implements OverflowListGoodsService {

    @Autowired
    private LogService logService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private OverflowListGoodsDao overflowListGoodsDao;

    @Override
    public ServiceVO save(OverflowList overflowList, String overflowListGoodsStr) {

        // 使用谷歌Gson将JSON字符串数组转换成具体的集合
        Gson gson = new Gson();

        List<OverflowListGoods> overflowListGoodsList = gson.fromJson(overflowListGoodsStr,new TypeToken<List<OverflowListGoods>>(){}.getType());

        // 设置当前操作用户
        User currentUser = userDao.findUserByName((String) SecurityUtils.getSubject().getPrincipal());

        overflowList.setUserId(currentUser.getUserId());

        // 保存商品报溢单信息
        overflowListGoodsDao.saveOverflowList(overflowList);

        // 保存商品报溢单商品信息
        for(OverflowListGoods overflowListGoods : overflowListGoodsList){

            overflowListGoods.setOverflowListId(overflowList.getOverflowListId());

            overflowListGoodsDao.saveOverflowListGoods(overflowListGoods);

            // 修改商品库存，状态
            Goods goods = goodsDao.findByGoodsId(overflowListGoods.getGoodsId());

            goods.setInventoryQuantity(goods.getInventoryQuantity()+overflowListGoods.getGoodsNum());

            goods.setState(2);

            goodsDao.updateGoods(goods);

        }

        // 保存日志
        logService.save(new Log(Log.INSERT_ACTION, "新增商品报溢单："+overflowList.getOverflowNumber()));

        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }

    @Override
    public Map<String, Object> list(String sTime, String eTime) {
        Map<String,Object> result = new HashMap<>();

        try {

            List<OverflowList> overflowListList = overflowListGoodsDao.getOverflowlist(sTime, eTime);

            logService.save(new Log(Log.SELECT_ACTION, "商品报溢单据查询"));

            result.put("rows", overflowListList);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return result;
    }

    @Override
    public Map<String, Object> goodsList(Integer overflowListId) {
        Map<String,Object> map = new HashMap<>();

        try {

            List<OverflowListGoods> overflowListGoodsList = overflowListGoodsDao.getOverflowListGoodsByOverflowListId(overflowListId);

            logService.save(new Log(Log.SELECT_ACTION, "商品报溢单商品信息查询"));

            map.put("rows", overflowListGoodsList);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return map;
    }
}
