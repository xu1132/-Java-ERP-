package com.xuyi.dao;

import com.xuyi.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xuyi
 * @date 2022/10/25 16:34
 * @description
 */
public interface CustomerDao {

    List<Customer> getCustomerList(@Param("offSet") Integer offSet, @Param("pageRow") Integer pageRow, @Param("customerName") String customerName);

    Integer getCustomerCount(@Param("customerName") String customerName);

    Integer saveCustomer(Customer customer);

    Integer updateCustomer(Customer customer);

    Customer getCustomerById(Integer customerId);

    Integer deleteCustomer(Integer customerId);

    List<Customer> getCustomerListByNameLike(@Param("q") String q);
}
