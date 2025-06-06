package com.xuyi.dao;

import com.xuyi.entity.UserRole;

/**
 * @author xuyi
 * @date 2022/10/25 16:34
 * @description
 */
public interface UserRoleDao {

    // 根据用户id删除用户角色
    Integer deleteUserRoleByUserId(Integer userId);

    // 为用户添加角色
    Integer addUserRole(UserRole userRole);
}
