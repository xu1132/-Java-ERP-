package com.xuyi.service;

import com.xuyi.domain.ServiceVO;
import com.xuyi.entity.Unit;

import java.util.Map;

/**
 * @author xuyi
 * @date 2022/10/25 16:34
 * @description
 */
public interface UnitService {

    ServiceVO save(Unit unit);

    ServiceVO delete(Integer unitId);

    Map<String,Object> list();
}
