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

<title>My JSP 'welcome.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="styles/mycss.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<script>
		if (
	<%=request.getParameter("isuserdeletesuccess")%>
		== false)
			alert("用户删除失败！");
		if (
	<%=request.getParameter("isuserdeletesuccess")%>
		== true)
			alert("用户删除成功！");
			
			if (
	<%=request.getParameter("isorgdeletesuccess")%>
		== false)
			alert("部门删除失败！");
		if (
	<%=request.getParameter("isorgdeletesuccess")%>
		== true)
			alert("部门删除成功！");
			
			if (
	<%=request.getParameter("ismoduledeletesuccess")%>
		== false)
			alert("模块删除失败！");
		if (
	<%=request.getParameter("ismoduledeletesuccess")%>
		== true)
			alert("模块删除成功！");
			
			if (
	<%=request.getParameter("isfunctiondeletesuccess")%>
		== false)
			alert("功能删除失败！");
		if (
	<%=request.getParameter("isfunctiondeletesuccess")%>
		== true)
			alert("功能删除成功！");
	</script>
</body>
</html>
