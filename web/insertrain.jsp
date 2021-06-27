
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
    <title> 降雨管理系统</title>
    <!--2.导入bootstrap的css文件-->
    <link rel="stylesheet" type="text/css" href="bootstrap-3.4.1/css/bootstrap.css"/>
    <link rel="shortcut icon" href="#" />
    <style type="text/css">
        .odd{
            background-color: #2aabd2;
        }
    </style>
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">
        $(function () {
           $("#btn").click(function () {
               window.location.href="${pageContext.request.contextPath}/showservlet";
           });

        });
    </script>
</head>
<body>
<div class="container"><h1 style="text-align: center">新增雨量监测信息</h1></div>
<div class="container" style="margin-top: 100px">
    <form class="form-horizontal"  onsubmit="return tijiao()" action="insertservlet" enctype="application/x-www-form-urlencoded">
        <div class="form-group">
            <label for="districtName" class="col-sm-2 control-label">区域名称</label>
            <div class="col-sm-10">
                <input type="text" onblur="yz()" class="form-control"  name="districtName" id="districtName" placeholder="请输入区域名称">
                <span id="tishi" style="background-color: red"></span>
            </div>
        </div>
        <div class="form-group">
            <label for="birthday" class="col-sm-2 control-label">监测时间</label>
            <div class="col-sm-10">
                <input type="date" class="form-control" name="monitorTime" id="birthday" placeholder="监测时间">
            </div>
        </div>
        <div class="form-group">
            <label for="rain" class="col-sm-2 control-label">雨量值</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="rain" id="rain" placeholder="雨量值">
            </div>
        </div>
        <div class="form-group">
            <label for="monitoringStation" class="col-sm-2 control-label">监测站</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="monitoringStation" id="monitoringStation" placeholder="监测站">
            </div>
        </div>
        <div class="form-group">
            <label for="monitoringAddress" class="col-sm-2 control-label">站点地址</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="monitoringAddress" id="monitoringAddress" placeholder="站点地址">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary btn-lg active" role="button">保存</button>
                <button type="reset" class="btn btn-primary btn-lg active" role="button">重置</button>
                <button type="button" class="btn btn-primary btn-lg active" role="button" id="btn">返回</button>
            </div>
        </div>
    </form>
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
    function tijiao() {
        var name = $("#districtName").val();
        if (name==""){
            alert("区域名称不能为空");
            return false;
        }
        if ($("#monitoringAddress").val()==""){
            alert("不能为空");
            return false;
        }
        var rain = $("#rain").val();

        if (isNaN(rain)){
            alert("雨量值只能为数字");
            return false;
        }
        return true;
    };


</script>
</body>
</html>
