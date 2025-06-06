package com.xuyi.service;

import com.xuyi.domain.ServiceVO;
import com.xuyi.entity.Goods;

import java.util.Map;

/**
 * @author xuyi
 * @date 2022/10/25 16:34
 * @description
 */
public interface GoodsService {

    Map<String,Object> list(Integer page, Integer rows, String goodsName, Integer goodsTypeId);

    Map<String,Object> listInventory(Integer page, Integer rows, String codeOrName, Integer goodsTypeId);

    ServiceVO getCode();

    ServiceVO save(Goods goods);

    ServiceVO delete(Integer goodsId);

    Map<String,Object> getNoInventoryQuantity(Integer page,Integer rows,String nameOrCode);

    ServiceVO deleteStock(Integer goodsId);

    Map<String,Object> getHasInventoryQuantity(Integer page,Integer rows,String nameOrCode);

    ServiceVO saveStock(Integer goodsId,Integer inventoryQuantity,double purchasingPrice);

    Map<String,Object> listAlarm();
}
