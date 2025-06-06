package com.xuyi.service.impl;

import com.xuyi.dao.SupplierDao;
import com.xuyi.domain.ServiceVO;
import com.xuyi.domain.SuccessCode;
import com.xuyi.entity.Log;
import com.xuyi.entity.Supplier;
import com.xuyi.service.LogService;
import com.xuyi.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xuyi
 * @date 2022/11/04 8:48
 * @description
 */
@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private LogService logService;
    @Autowired
    private SupplierDao supplierDao;

    @Override
    public List<Supplier> getComboboxList(String q) {
        return supplierDao.getSupplierListByNameLike(q);
    }

    @Override
    public Map<String, Object> list(Integer page, Integer rows, String supplierName) {
        Map<String,Object> map = new HashMap<>();

        page = page == 0 ? 1 : page;
        int offSet = (page - 1) * rows;

        List<Supplier> suppliers = supplierDao.getSupplierList(offSet, rows, supplierName);

        logService.save(new Log(Log.SELECT_ACTION,"分页查询供应商"));

        map.put("total", supplierDao.getSupplierCount(supplierName));

        map.put("rows", suppliers);

        return map;
    }

    @Override
    public ServiceVO save(Supplier supplier) {

        if(supplier.getSupplierId() == null){

            supplierDao.saveSupplier(supplier);
            logService.save(new Log(Log.INSERT_ACTION,"添加供应商:"+supplier.getSupplierName()));

        }else{

            supplierDao.updateSupplier(supplier);
            logService.save(new Log(Log.UPDATE_ACTION,"修改供应商:"+supplier.getSupplierName()));

        }

        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);

    }

    @Override
    public ServiceVO delete(String ids) {

        String[] idArray = ids.split(",");

        for (String id : idArray) {

            logService.save(new Log(Log.DELETE_ACTION,
                    "删除供应商:" + supplierDao.getSupplierById(Integer.parseInt(id)).getSupplierName()));

            supplierDao.deleteSupplier(Integer.parseInt(id));

        }
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }
}
