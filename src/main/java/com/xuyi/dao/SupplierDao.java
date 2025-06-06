package com.xuyi.dao;

import com.xuyi.entity.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xuyi
 * @date 2022/10/25 16:34
 * @description
 */
public interface SupplierDao {

    List<Supplier> getSupplierList(@Param("offSet") Integer offSet, @Param("pageRow") Integer pageRow, @Param("supplierName") String supplierName);

    Integer getSupplierCount(@Param("supplierName") String supplierName);

    Integer saveSupplier(Supplier supplier);

    Integer updateSupplier(Supplier supplier);

    Supplier getSupplierById(Integer supplierId);

    Integer deleteSupplier(Integer supplierId);

    List<Supplier> getSupplierListByNameLike(@Param("q") String q);

}
