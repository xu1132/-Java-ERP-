package com.xuyi.service;

import com.xuyi.domain.ServiceVO;
import com.xuyi.entity.Supplier;

import java.util.List;
import java.util.Map;

/**
 * @author xuyi
 * @date 2022/10/25 16:34
 * @description
 */
public interface SupplierService {

    List<Supplier> getComboboxList(String q);

    Map<String,Object> list(Integer page, Integer rows, String supplierName);

    ServiceVO save(Supplier supplier);

    ServiceVO delete(String ids);
}
