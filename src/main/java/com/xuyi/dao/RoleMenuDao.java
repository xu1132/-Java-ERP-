package com.xuyi.dao;

import com.xuyi.entity.RoleMenu;

/**
 * @author xuyi
 * @date 2022/10/25 16:34
 * @description
 */
public interface RoleMenuDao {

    // 根据角色id删除该角色的所有菜单权限
    Integer deleteRoleMenuByRoleId(Integer roleId);

    // 为角色新增一条菜单权限
    Integer save(RoleMenu roleMenu);
}
