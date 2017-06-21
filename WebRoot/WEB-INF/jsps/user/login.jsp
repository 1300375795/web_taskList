<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>网页版任务列表登录页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">

<link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>">
<script type="text/javascript" src="<c:url value='/jquery-1.5.1.js'/>"></script>
<script type="text/javascript">
	/* 下面的这个是处理cookie的 */
	$(function() {
		var loginname = window.encodeURI("${cookie.loginname.value}");
		if ("${requestScope.formUser.loginname}") {
			loginname = "${requestScope.formUser.loginname}";
		}
		$("#loginname").val(loginname);
	});
	
	/* 下面的这个则是注册按钮的鼠标点击事件 点击跳转到相应的注册页面*/
	$(function() {
		$("#regist").click(function(){
			 location = "<c:url value='/regist.action'></c:url>"
		});
		
		/* $(":checkbox[name=remember_me][checked=true]").each(function() {
			 alert("保存");
		     $("#cookie").val("保存");
		}); */
	});
	
	
</script>
</head>
<body>
	 <section class="container">
    <div class="login">
      <h1>用户登录</h1>
      <form method="post" action='<c:url value="/login.action"></c:url>'>
        <!-- <input type="hidden"  name="cookie" id="cookie" value=""> -->
        <p><input type="text"  name="username" value="${user.username }" required="required" placeholder="请输入账号名"></p>
        <p>${username }</p>
        <p><input type="password" name="userpassword" value="${user.userpassword }" required="required" placeholder="请输入密码"></p>
         <p>${userpassword }</p>
        <p class="remember_me">
          <label>
            <input type="checkbox" name="remember_me" id="remember_me"  >
            保存用户名密码
          </label>
        </p>
        <p class="regist"><input id="regist" type="button" name="regist" value="注册"></p>
        <p class="submit"><input type="submit" name="commit" value="登录"></p>
      </form>
    </div>

    <div class="login-help">
      <p>忘记密码? <a href="index.html">点击修改</a></p>
    </div>
  </section>
</body>
</html>
