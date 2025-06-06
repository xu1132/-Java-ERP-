package com.xuyi.service;

import com.xuyi.domain.ServiceVO;
import com.xuyi.entity.CustomerReturnList;

import java.util.Map;

/**
 * @author xuyi
 * @date 2022/10/25 16:34
 * @description
 */
public interface CustomerReturnListGoodsService {

    Integer getCustomerReturnTotalByGoodsId(Integer goodsId);

    ServiceVO save(CustomerReturnList customerReturnList, String customerReturnListGoodsStr);

    Map<String,Object> list(String returnNumber, Integer customerId, Integer state, String sTime,
                            String eTime);

    Map<String,Object> goodsList(Integer customerReturnListId);

    ServiceVO delete(Integer customerReturnListId);

    ServiceVO updateState(Integer customerReturnListId);

    String count(String sTime, String eTime, Integer goodsTypeId, String codeOrName);
}
