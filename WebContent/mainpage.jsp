<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理我的记录</title>
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/form-elements.css">
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="span6">
            <ul class="nav nav-tabs col-sm-9">
                <li class="active"><a href="#">基本信息</a> </li>
                <li><a href="studentsch.html">大学生活记录</a></li>
                <li><a href="studentjob.html">学生职业生涯</a></li>
            </ul>
            <ul class="navbar-nav nav navbar-right">
                <li><a href="#"><%=session.getAttribute("sid") %></a></li>
                <li>
                    <a id="loginbtn"><span class="glyphicon glyphicon-log-in"></span>&nbsp;退出</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-12 col-sm-9">
            <form class="form-horizontal" action="editinfo.html" method="post">
                <!--form-group acts as a row-->
                <div class="form-group">
                    <!--col-xs时自动新起一行?-->
                    <label class="col-sm-2 control-label" for="sid">学号</label>
                    <div class="col-sm-10">
                        <input type="text" id="sid" name="sid" class="form-control" placeholder="学号(修改请联系老师)"
                        value="${student.sid}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="sname">姓名</label>
                    <div class="col-sm-10">
                        <input type="text" id="sname" name="sname" class="form-control" placeholder="姓名" value="${student.sname}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-2">
                    	<c:choose>
                    	<c:when test="${student.gender == '男'}">
                    		<input type="radio" name="gender" id="male" value="男" checked>
                    	</c:when>
                    	<c:otherwise>
                    		<input type="radio" name="gender" id="male" value="男">
                    	</c:otherwise>
                    	</c:choose>
                        <label for="male">&nbsp;男</label></div>
                    <div class="col-sm-2">
                    	<c:choose>
                    		<c:when test="${student.gender == '女'}">
                    			<input type="radio" name="gender" id="female" value="女" checked>		
                    		</c:when>
                    		<c:otherwise>
                    			<input type="radio" name="gender" id="female" value="女">
                    		</c:otherwise>
                    	</c:choose>
                        <label for="female">&nbsp;女</label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="political">政治面貌</label>
                    <div class="col-sm-3">
                        <select id="political" name="political" class="form-control">
                            <option value='${student.political}' selected>${student.political}</option>
                            <option value="无">无</option>
                            <option value="共青团员">共青团员</option>
                            <option value="共产党员">共产党员</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="selProvince">生源地</label>
                    <div class="col-sm-4">
                        <select id="selProvince" name="sprov" class="form-control">
                            <option value='${student.sprov}' selected>${student.sprov}</option>
                        </select>
                    </div>
                    <div class="col-sm-4">
                        <select id="selCity" name="scity" onclick="provinceChange();" class="form-control">
                            <option value='${student.scity}' selected>${student.scity}</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="major">专业</label>
                    <div class="col-sm-10">
                        <input type="text" id="major" name="major" class="form-control" placeholder="专业" value="${student.major}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="tel">电话</label>
                    <div class="col-sm-10">
                        <input type="text" id="tel" name="tel" class="form-control" placeholder="电话" value="${student.tel}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="sqq">QQ</label>
                    <div class="col-sm-10">
                        <input type="text" id="sqq" name="sqq" class="form-control" placeholder="QQ" value="${student.sqq}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-10 col-sm-offset-2">
                        <input type="button" class="btn btn-primary" value="记得提交修改0.0" onclick="editinfo()">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<style>
    .container{
        max-width: 1000px;
        margin: 10px auto;
    }
    .row{
        margin-top: 10px;
    }
</style>
<script type="text/javascript" src="./assets/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="./assets/js/provinceandcity.js"></script>
<script type="text/javascript" src="./assets/js/edit.js"></script>
</body>
</html>