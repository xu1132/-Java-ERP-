package com.xuyi.service;

import com.xuyi.domain.ServiceVO;
import com.xuyi.entity.Role;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author xuyi
 * @date 2022/10/25 16:34
 * @description
 */
public interface RoleService {

    ServiceVO saveRole(Role role, HttpSession session);

    Map<String,Object> listAll();

    Map<String, Object> list(Integer page, Integer rows, String roleName);

    ServiceVO save(Role role);

    ServiceVO delete(Integer roleId);

    ServiceVO setMenu(Integer roleId,String menus);
}
