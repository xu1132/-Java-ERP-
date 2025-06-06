package com.xuyi.dao;

import com.xuyi.entity.Unit;

import java.util.List;

/**
 * @author xuyi
 * @date 2022/10/25 16:34
 * @description
 */
public interface UnitDao {

    Integer saveUnit(Unit unit);

    Integer delete(Integer unitId);

    List<Unit> listAll();

    Unit getUnitByUnitId(Integer unitId);
}
