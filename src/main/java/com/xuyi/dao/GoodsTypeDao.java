package com.xuyi.dao;

import com.xuyi.entity.Goods;
import com.xuyi.entity.GoodsType;

import java.util.List;

/**
 * @author xuyi
 * @date 2022/10/25 16:34
 * @description
 */
public interface GoodsTypeDao {

    List<GoodsType> getAllGoodsTypeByParentId(Integer pId);

    Integer saveGoodsType(GoodsType goodsType);

    GoodsType getGoodsTypeById(Integer goodsTypeId);

    Integer updateGoodsTypeState(GoodsType parentGoodsType);

    List<Goods> getGoodsByTypeId(Integer goodsTypeId);

    Integer delete(Integer goodsTypeId);
}
