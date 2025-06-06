package com.xuyi.service;

import com.xuyi.domain.ServiceVO;

/**
 * @author xuyi
 * @date 2022/10/25 16:34
 * @description
 */
public interface GoodsTypeService {

    ServiceVO delete(Integer goodsTypeId);

    ServiceVO save(String goodsTypeName,Integer pId);

    String loadGoodsType();
}
