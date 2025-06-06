package com.xuyi.service;

import com.xuyi.domain.ServiceVO;
import com.xuyi.entity.Customer;

import java.util.List;
import java.util.Map;

/**
 * @author xuyi
 * @date 2022/10/25 16:34
 * @description
 */
public interface CustomerService {

    Map<String,Object> list(Integer page, Integer rows, String customerName);

    ServiceVO save(Customer customer);

    ServiceVO delete(String ids);

    List<Customer> getComboboxList(String q);
}
