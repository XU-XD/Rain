package com.xxd.servlet;
/**
 * projectName:RainManage
 * author:xuxindong
 * time:2021/6/25 15:44
 * description:
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
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/insertservlet")
public class InsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//请求乱码
        response.setContentType("text/html;charset=UTF-8");//响应乱码
        //1获取前端数据
        String districtName = request.getParameter("districtName");
        String monitorTime = request.getParameter("monitorTime");
        String rain = request.getParameter("rain");
        String monitoringStation = request.getParameter("monitoringStation");
        String monitoringAddress = request.getParameter("monitoringAddress");
        System.out.println(districtName+"\t"+monitorTime+"\t"+rain+"\t"+monitoringStation+"\t"+monitoringAddress);
        try {
            //2调用逻辑
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            RainQuality rainQuality=new RainQuality(0,districtName,sdf.parse(monitorTime),Integer.parseInt(rain),monitoringStation,monitoringAddress);
            RainQualityService rainQualityService=new RainQualityServiceImpl();
            rainQualityService.add(rainQuality);
            //3分发转向
            //转发
            //request.getRequestDispatcher("/showservlet").forward(request,response);
            response.getWriter().print("<script>alert('成功');window.location='showservlet'</script>");
        } catch (ParseException e) {
            e.printStackTrace();
            //request.getContextPath()
            //重定向
//            response.sendRedirect(request.getContextPath()+"/insertrain.jsp");
            response.getWriter().print("<script>alert('添加失败');window.location='showservlet'</script>");
        }


    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}