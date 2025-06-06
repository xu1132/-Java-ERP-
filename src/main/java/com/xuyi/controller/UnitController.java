package com.xuyi.controller;

import com.xuyi.domain.ServiceVO;
import com.xuyi.entity.Unit;
import com.xuyi.service.UnitService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author xuyi
 * @date 2022/11/02 17:23
 * @description 商品单位Controller层
 */
@RestController
@RequestMapping("/unit")
public class UnitController {

    @Autowired
    private UnitService unitService;

    /**
     * 添加或修改商品单位
     * @param unit 商品单位实体
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    @RequiresPermissions(value = "商品管理")
    public ServiceVO save(Unit unit) {
        return unitService.save(unit);
    }

    /**
     * 删除商品单位
     * @param unitId 商品单位ID
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    @RequiresPermissions(value = "商品管理")
    public ServiceVO delete(Integer unitId) {
        return unitService.delete(unitId);
    }

    /**
     * 查询所有商品单位
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    @RequiresPermissions(value = "商品管理")
    public Map<String,Object> list() {
        return unitService.list();
    }
}
