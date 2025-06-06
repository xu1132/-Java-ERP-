package com.xuyi.service;

import javax.servlet.http.HttpSession;

/**
 * @author xuyi
 * @date 2022/10/25 16:34
 * @description
 */
public interface MenuService {

    String loadMenu(HttpSession session);

    String loadCheckMenu(Integer roleId);

}
