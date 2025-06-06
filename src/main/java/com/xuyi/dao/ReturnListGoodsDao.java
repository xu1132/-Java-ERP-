package com.xuyi.dao;

import com.xuyi.entity.ReturnList;
import com.xuyi.entity.ReturnListGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xuyi
 * @date 2022/10/25 16:34
 * @description
 */
public interface ReturnListGoodsDao {


    Integer saveReturnList(ReturnList returnList);

    Integer saveReturnListGoods(ReturnListGoods returnListGoods);

    List<ReturnList> getReturnlist(@Param("returnNumber") String returnNumber,
                                   @Param("supplierId") Integer supplierId,
                                   @Param("state") Integer state,
                                   @Param("sTime") String sTime,
                                   @Param("eTime") String eTime);

    List<ReturnListGoods> getReturnListGoodsByReturnListId(Integer returnListId);

    ReturnList getReturnList(Integer returnListId);

    Integer deleteReturnListById(Integer returnListId);

    Integer deleteReturnListGoodsByReturnListId(Integer returnListId);

    Integer updateState(Integer returnListId);

    List<ReturnListGoods> getReturnListGoods(@Param("returnListId") Integer returnListId,
                                             @Param("goodsTypeId") Integer goodsTypeId,
                                             @Param("codeOrName") String codeOrName);
}
