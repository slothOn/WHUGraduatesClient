<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String msg = (String)request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>毕业生记录管理</title>
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="assets/css/form-elements.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
    </head>
    <body>
		<%if(msg != null && !"".equals(msg)) {%>
			<script>alert("提示:" + "<%=msg%>");</script>
		<%} %>
        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>毕业生</strong> 记录管理</h1>
                            <div class="description">
                            	<p>
	                            	在这里记录你的大学生涯和人生经历
                            	</p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>输入学号和密码登录</h3>
                            		<p>首次登录请先注册</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-lock"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="user.html" method="post" class="login-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">Username</label>
			                        	<input type="text" name="username" placeholder="用户名（学号）" class="form-username form-control" id="form-username">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">Password</label>
			                        	<input type="password" name="password" placeholder="密码" class="form-password form-control" id="form-password">
			                        </div>
			                         <div class="form-group">
                                        <input type="text" name="captcha" class="form-control" style="width: 50%; display: inline-block" placeholder="登录验证">
                                        <span style="display: inline-block; width: 30%; text-align: right;"><img src="captcha.html"></span>
                                    </div>
			                        <button type="submit" class="btn">Sign in!</button>
                                    <button type="button" class="btn signupbtn" data-toggle="modal" data-target="#signupmodal">Sign up?</button>
			                    </form>
		                    </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="signupmodal" class="modal fade" style="width:auto">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">注册账号</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" action="logup.html" method="post" id="signform">
                            <div class="form-group">
                                <label class="control-label col-sm-2">账号:</label>
                                <div class="col-sm-10">
                                    <input type="text" name="sid" class="form-control" placeholder="请输入学号">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2">姓名:</label>
                                <div class="col-sm-10">
                                    <input type="text" name="sname" class="form-control" placeholder="请输入姓名">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2">密码:</label>
                                <div class="col-sm-10">
                                    <input type="password" name="password" class="form-control" placeholder="请输入密码">
                                </div>
                            </div>
                             <div class="form-group">
                                <label class="control-label col-sm-2">重复密码:</label>
                                <div class="col-sm-10">
                                    <input type="password" name="password2" class="form-control" placeholder="再输入一遍">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2">验证码:</label>
                                <div  class="col-sm-5">
                                    <input type="text" name="captcha" class="form-control" placeholder="注册验证">
                                </div>
                                <span style="display: inline-block; width: 30%; text-align: right;"><img src="captcha.html"></span>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2"></div>
                                <div class="col-sm-5">
                                    <input type="button" class="btn btn-lg btn-info" value="注册" id="submitbtn" onclick="checkform()">
                                </div>
                            </div>
                        </form>
                    </div>
                    </div>
                </div>
            </div>
       
        <!-- Javascript -->
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/scripts.js"></script>
       	 <script type="text/javascript">
            function checkform(){
                if($("#signform :password").get(0).value != $("#signform :password").get(1).value){
                    alert("两次密码不一致重新注册");
                }else $("#signform").submit();
            }
        </script>
    </body>

</html>