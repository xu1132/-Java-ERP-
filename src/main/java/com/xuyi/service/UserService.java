package com.xuyi.service;

import com.xuyi.domain.ServiceVO;
import com.xuyi.entity.User;
import com.xuyi.entity.UserLogin;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author xuyi
 * @date 2022/10/25 16:34
 * @description
 */
public interface UserService {

    ServiceVO login(UserLogin userLogin, HttpSession session);

    Map<String,Object> loadUserInfo(HttpSession session);

    Map<String, Object> list(Integer page,Integer rows,String userName);

    ServiceVO save(User user);

    ServiceVO delete(Integer userId);

    ServiceVO setRole(Integer userId, String roles);

    ServiceVO updatePassword(String newPassword, HttpSession session);
}
