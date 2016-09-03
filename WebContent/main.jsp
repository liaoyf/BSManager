<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'main.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="StyleSheet" type="text/css" href="styles/mycss.css" />



</head>


<body style="background:#666">
	<div class="topheadings">
		<div align="left">
			<img src="img/cp_logo.png" />
		</div>
		<div align="right">登出</div>
	</div>
	
	<iframe src="Dtree.jsp" name="dtree" align="left" width=20%
		frameborder="0" height=100%></iframe>
	<iframe src="welcome.jsp" name="centerpag" align="right" width=80%
		frameborder="0" height=100%></iframe>


</body>

</html>
