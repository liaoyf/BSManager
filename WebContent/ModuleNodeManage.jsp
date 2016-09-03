<%@page import="com.ObjectGeter.Module_geter"%>
<%@page import="com.bsObject.Module"%>
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

<title>My JSP 'ModuleNodeManage.jsp' starting page</title>

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

<%
	Module m = Module_geter.GetObjById(request.getParameter("mid"));
	session.setAttribute("ActiveModule", m);
	if (request.getParameter("action") != null
			&& request.getParameter("action").equals("delete")) {
		response.sendRedirect("../BSManager/welcome.jsp?ismoduledeletesuccess="
				+ Module_geter.DoModuleDelete(m.getModule_id()));
	}
%>


<body>
	<br>
	<br>
	<div class="contentcontainer">
		<div class="headings altheading">
			<h2>
				当前模块：<%=m.getModule_name()%></h2>
		</div>
		<div class="contentbox">
			<table>

				<tbody>
					<tr class="alt">
						<td><a href="ModuleAdd.jsp">添加模块</a></td>
						<td><a href="ModuleNodeManage.jsp?action=delete&mid=<%=m.getModule_id()%>">删除模块</a></td>
					</tr>
					<tr>
						<td><a href="ModuleEdit.jsp">编辑模块</a></td>
						<td><a href="FunctionAdd.jsp">添加功能</a></td>
					</tr>
					<tr class="alt">
						<td><a href="#">模块用户授权</a></td>
						<td><a href="#">模块管理员授权</a></td>
					</tr>
					<tr>
						<td><a href="#">模块角色授权</a></td>
						<td></td>
					</tr>
					<tr class="alt">
						<td><a href="#">上移一位</a></td>
						<td><a href="#">下移一位</a></td>
					</tr>
				</tbody>
			</table>


		</div>
	</div>

</body>
<script>
	if (
<%=request.getParameter("issuccess")%>
	== false)
		alert("修改失败！");
	if (
<%=request.getParameter("issuccess")%>
	== true)
		alert("修改成功！");
</script>

</html>
