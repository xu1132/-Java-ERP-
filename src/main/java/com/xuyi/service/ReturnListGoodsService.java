package com.xuyi.service;

import com.xuyi.domain.ServiceVO;
import com.xuyi.entity.ReturnList;

import java.util.Map;

/**
 * @author xuyi
 * @date 2022/10/25 16:34
 * @description
 */
public interface ReturnListGoodsService {

    ServiceVO save(ReturnList returnList, String returnListGoodsStr);

    Map<String,Object> list(String returnNumber,
                            Integer supplierId,
                            Integer state,
                            String sTime,
                            String eTime);

    Map<String,Object> goodsList(Integer returnListId);

    ServiceVO delete(Integer returnListId);

    ServiceVO updateState(Integer returnListId);

    String count(String sTime, String eTime ,Integer goodsTypeId, String codeOrName);
}
