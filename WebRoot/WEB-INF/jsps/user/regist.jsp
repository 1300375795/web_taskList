<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/css.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/jsps/css/user/regist.css'/>">
<script type="text/javascript"
	src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/jsps/js/user/regist.js'/>"></script>
</head>

<body>
	<form  action='<c:url value="/userLogin.action"></c:url>' method="POST">
	用户名:<input id="username" type="text" name="username" value=""></input>${usernameError}<br/>
	密    码:<input type="text" name="userpassword" value=""></input>${userpasswordError}<br/>
	email:<input type="text" name="useremail" value=""></input>${useremailError}<br/>
	<input type="submit" value="登录"></input>
	</form>
</body>
</html>
