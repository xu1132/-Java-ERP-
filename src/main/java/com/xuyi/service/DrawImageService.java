package com.xuyi.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xuyi
 * @date 2022/10/25 16:34
 * @description
 */
public interface DrawImageService {

    void drawImage(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
