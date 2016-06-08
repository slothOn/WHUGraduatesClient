<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理我的记录</title>
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/form-elements.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <script src="./assets/js/jquery-1.11.1.min.js"></script>
    <script src="./assets/bootstrap/js/bootstrap.min.js"></script>

    <meta name="viewport" content="width=device-wdith,initia-scale=1.0">

    <style>
        .container{
            max-width: 1000px;
            margin: 10px auto;
        }
        .row{
            margin-top: 10px;
        }
        table {
            border-collapse: collapse;
            border: 1px solid #FFFFFF;
        }

        table td {
            text-align: center;
            height: 30px;
            font-size: 12px;
            line-height: 30px;
            border: 1px solid #efecec;
        }
    </style>

</head>
<body>
<div class="container">
    <div class="row">
        <div class="span6">
            <ul class="nav nav-tabs col-sm-9">
                <li><a href="mainpage.html">基本信息</a> </li>
                <li><a href="studentsch.html">大学生活记录</a></li>
                <li class="active"><a href="#">学生职业生涯</a></li>
            </ul>
            <ul class="navbar-nav nav navbar-right">
                <li><a href="#">用户</a></li>
                <li>
                    <a id="loginbtn"><span class="glyphicon glyphicon-log-in"></span>&nbsp;退出</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="row">

    </div>
</div>

<div class="container heading">

    <button id="build" type="button" class="btn  btn-success" data-toggle="modal" data-target="" onclick="append()">
        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加
    </button>

    <button id="btnEdit" type="button" class="btn   btn-warning">
        <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>修改
    </button>

    <button id="btnDel" type="button" class="btn  btn-danger" data-toggle="modal" data-target="#DeleteForm" onclick="">
        <span class="glyphicon glyphicon-minus" aria-hidden="true"></span>删除
    </button>


</div>


<div class="container widget-content padded clearfix">
    <table id="AddFamily" class="table table-bordered table-striped" width="1000px" border="0" cellspacing="0" cellpadding="0" style="margin: 0 auto">

        <thead>
        <th class="check-header indexcol">
            <input id="checkAll" name="checkAll" type="checkbox">

        <th width="15%">时间</th>
        <th width="20%">状态</th>
        <th width="20%">单位</th>
        <th width="20%">岗位</th>
        <th width="25%">备注</th>
        </thead>
        <tbody id="mainbody">
        <c:forEach items="${joblist}" var="record">
        <tr>
            <td class="indexcol">
                <input name="checkbox" type="checkbox" id="1">
            </td>

            <td data-field="time" width="15%">${record.time}</td>
            <td data-field="type" width="20%">${record.type}</td>
            <td data-field="cname" width="20%">${record.cname}</td>
            <td data-field="job" width="20%">${record.job}</td>
            <td data-field="comment" width="25%">${record.comment}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="row">
        <div class="col-sm-10 col-sm-offset-1">
            <input type="submit" class="btn btn-primary btn-lg" value="记得提交修改0.0" onclick="editjob()">
        </div>
    </div>
</div>

<script type="text/javascript" src="./assets/js/bootstraptable.js"></script>
<script>
function append() {
    var strAppend = '<tr style="background: rgb(255, 255, 255) none repeat scroll 0% 0%;"><td ><input type="checkbox" value="" editable="false" name="checkbox"></td>'
    + '<td data-field="time"></td><td data-field="type"></td>'
    + '<td data-field="cname"></td><td data-field="job"></td><td data-field="comment"></td><tr>';
    $("#AddFamily tbody ").append(strAppend).editableTableWidget();
}
</script>
<script type="text/javascript" src="./assets/js/edit.js"></script>
</body>
</html>
