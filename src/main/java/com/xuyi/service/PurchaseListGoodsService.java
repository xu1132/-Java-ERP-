package com.xuyi.service;

import com.xuyi.domain.ServiceVO;
import com.xuyi.entity.PurchaseList;

import java.util.Map;

/**
 * @author xuyi
 * @date 2022/10/25 16:34
 * @description
 */
public interface PurchaseListGoodsService {

    ServiceVO save(PurchaseList purchaseList, String purchaseListGoodsStr);

    Map<String, Object> list(String purchaseNumber,
                            Integer supplierId,
                            Integer state,
                            String sTime,
                            String eTime);

    Map<String, Object> goodsList(Integer purchaseListId);

    ServiceVO delete(Integer purchaseListId);

    ServiceVO updateState(Integer purchaseListId);

    String count(String sTime, String eTime ,Integer goodsTypeId, String codeOrName);
}
