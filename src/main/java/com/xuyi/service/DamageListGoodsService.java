package com.xuyi.service;

import com.xuyi.domain.ServiceVO;
import com.xuyi.entity.DamageList;

import java.util.Map;

/**
 * @author xuyi
 * @date 2022/10/25 16:34
 * @description
 */
public interface DamageListGoodsService {

    ServiceVO save(DamageList damageList, String damageListGoodsStr);

    Map<String,Object> list(String sTime, String eTime);

    Map<String,Object> goodsList(Integer damageListId);
}
