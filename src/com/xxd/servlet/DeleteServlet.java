package com.xxd.servlet;
/**
 * projectName:RainManage
 * author:xuxindong
 * time:2021/6/25 14:08
 * description:
 */

import com.xxd.service.RainQualityService;
import com.xxd.service.impl.RainQualityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//请求乱码
        response.setContentType("text/html;charset=UTF-8");//响应乱码
        try {
            //获取前端数据
            String id = request.getParameter("id");//6
            //调用业务逻辑
            RainQualityService rainQualityService=new RainQualityServiceImpl();
            rainQualityService.remove(id);
            //分发转向（响应数据）
            response.getWriter().write("1");//成功
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("0");//失败
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}