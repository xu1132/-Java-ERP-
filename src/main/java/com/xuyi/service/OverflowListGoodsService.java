package com.xuyi.service;

import com.xuyi.domain.ServiceVO;
import com.xuyi.entity.OverflowList;

import java.util.Map;

/**
 * @author xuyi
 * @date 2024/10/25 16:34
 * @description
 */
public interface OverflowListGoodsService {

    ServiceVO save(OverflowList overflowList, String overflowListGoodsStr);

    Map<String,Object> list(String sTime, String eTime);

    Map<String,Object> goodsList(Integer overflowListId);
}
