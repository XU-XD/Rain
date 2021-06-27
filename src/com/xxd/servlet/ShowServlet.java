package com.xxd.servlet;
/**
 * projectName:RainManage
 * author:xuxindong
 * time:2021/6/25 9:41
 * description:展示页面
 */

import com.xxd.domain.RainQuality;
import com.xxd.service.RainQualityService;
import com.xxd.service.impl.RainQualityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showservlet")
public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");//请求乱码
    response.setContentType("text/html;charset=UTF-8");//响应乱码

        try {
            //1获取前端数据（查询所有不需要获取前端数据）
            //2调用逻辑业务service
            RainQualityService rainQualityService=new RainQualityServiceImpl();
            List<RainQuality> rainList=rainQualityService.findAll();
            for (RainQuality rainQuality : rainList) {
                System.out.println(rainQuality);
            }
            //3分发转向showrain.jsp
            if(rainList != null){
                request.setAttribute("rainList",rainList);
                request.getRequestDispatcher("/showrain.jsp").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            //3分发转向
            response.getWriter().write("查询失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}