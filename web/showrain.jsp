
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <!--1.引入三个meta标签-->
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--viewport视口：设备宽度及缩放比例-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--上述三个meta标签必须放在最前面，任何其他内容都必须跟随其后-->
    <title> 雨水监测</title>
    <!--2.导入bootstrap的css文件-->
    <link rel="stylesheet" type="text/css" href="bootstrap-3.4.1/css/bootstrap.css"/>
    <link rel="shortcut icon" href="#" />
    <style type="text/css">
        .odd{
            background-color: #2aabd2;
        }
    </style>
</head>
<body>
<div class="container"><h1 style="text-align: center">雨量监测信息</h1></div>
    <div class="container">
        <a href="${pageContext.request.contextPath}/insertrain.jsp" class="btn btn-primary">新增雨量监测信息</a>
    </div>
    <div class="container" style="">

        <table class="table table-hover"  id="tb">
           <tr style="background-color: #999999;text-align: center" id="tt">
               <th style="text-align: center">序号</th>
               <th style="text-align: center">区域名称</th>
               <th style="text-align: center">监测时间</th>
               <th style="text-align: center">雨量值</th>
               <th style="text-align: center">监测站</th>
               <th style="text-align: center">站点地址</th>
               <th>操作</th>
           </tr>
            <c:forEach items="${rainList}" var="rain" varStatus="i">
                <tr style="text-align: center" id="tr${i}">
                    <td>${i.count}</td>
                    <td>${rain.districtName}</td>
                    <td><fmt:formatDate value="${rain.monitorTime}" pattern="yyyy.MM.dd"></fmt:formatDate></td>
                    <td>${rain.rain}</td>
                    <td>${rain.monitoringStation}</td>
                    <td>${rain.monitoringAddress}</td>
                    <td>
                        <a id="delRain" href="javascript:deleteRain('${rain.id}')">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>


    </div>
<!--3.导入jQuery类库-->
<script src="js/jquery-1.12.4.min.js"></script>
<!--validate校验库-->
<script type="text/javascript" src="validate/jquery.validate.min.js"></script>
<!--国际化库，中文提示-->
<script type="text/javascript" src="validate/messages_zh.min.js"></script>
<!--4.导入bootstrap的js文件-->
<script src="bootstrap-3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){

        $("tr").attr("bgColor", "#FFF");//为单数行表格设置背景颜色
        $("tr:even").css("background-color", "#A1CBFF");//为双数行表格设置背颜色素

    });


</script>
<script type="text/javascript">
    function deleteRain(rid) {
        if(confirm("确定要删除吗?")){
            $.get("http://localhost:8080${pageContext.request.contextPath}/delete?id="+rid,null,function (data) {
                alert(data);
                if(data==1){
                    alert("删除成功");
                    window.location.href="${pageContext.request.contextPath}/showservlet";
                }
            });
        }
    }
</script>
</body>
</html>
