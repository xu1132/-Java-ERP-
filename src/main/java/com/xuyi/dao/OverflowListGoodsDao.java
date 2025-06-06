package com.xuyi.dao;

import com.xuyi.entity.OverflowList;
import com.xuyi.entity.OverflowListGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xuyi
 * @date 2022/10/25 16:34
 * @description
 */
public interface OverflowListGoodsDao {

    Integer saveOverflowList(OverflowList overflowList);

    Integer saveOverflowListGoods(OverflowListGoods overflowListGoods);

    List<OverflowList> getOverflowlist(@Param("sTime") String sTime, @Param("eTime") String eTime);

    List<OverflowListGoods> getOverflowListGoodsByOverflowListId(Integer overflowListId);
}
