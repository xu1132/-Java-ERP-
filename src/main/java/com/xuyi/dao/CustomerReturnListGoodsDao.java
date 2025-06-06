package com.xuyi.dao;

import com.xuyi.entity.CustomerReturnList;
import com.xuyi.entity.CustomerReturnListGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xuyi
 * @date 2022/11/02 9:05
 * @description
 */
public interface CustomerReturnListGoodsDao {

    Integer getCustomerReturnTotalByGoodsId(Integer goodsId);

    Integer saveCustomerReturnList(CustomerReturnList customerReturnList);

    Integer saveCustomerReturnListGoods(CustomerReturnListGoods customerReturnListGoods);

    List<CustomerReturnList> getCustomerReturnlist(@Param("returnNumber") String returnNumber,
                                                   @Param("customerId") Integer customerId,
                                                   @Param("state") Integer state,
                                                   @Param("sTime") String sTime,
                                                   @Param("eTime") String eTime);

    List<CustomerReturnListGoods> getCustomerReturnListGoodsByCustomerReturnListId(Integer customerReturnListId);

    CustomerReturnList getCustomerReturnList(Integer customerReturnListId);

    Integer deleteCustomerReturnListById(Integer customerReturnListId);

    Integer deleteCustomerReturnListGoodsByCustomerReturnListId(Integer customerReturnListId);

    Integer updateState(Integer customerReturnListId);

    List<CustomerReturnListGoods> getCustomerReturnListGoods(@Param("customerReturnListId") Integer customerReturnListId,
                                                             @Param("goodsTypeId") Integer goodsTypeId,
                                                             @Param("codeOrName") String codeOrName);
}
