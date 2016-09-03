<%@page import="com.bsObject.User"%>
<%@page import="com.ObjectGeter.User_geter"%>

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

<title>My JSP 'Usermanage.jsp' starting page</title>

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

	<%
		User u = User_geter.GetObj(request.getParameter("uid"));
		session.setAttribute("ActiveUser", u);
		if (request.getParameter("action") != null
				&& request.getParameter("action").equals("delete")) {
			response.sendRedirect("../BSManager/welcome.jsp?isuserdeletesuccess="
					+ User_geter.DoUserDelete(u.getUser_id()));
		}
	%>
	<br>
	<br>
	<div class="contentcontainer">
		<div class="headings altheading">
			<h2>
				当前用户姓名：<%=u.getUser_name()%></h2>
		</div>
		<div class="contentbox">
			<table>

				<tbody>
					<tr class="alt">
						<td><a href="UserInfEdit.jsp">编辑员工</a></td>
						<td><a href="Usermanage.jsp?action=delete&uid=<%=u.getUser_id()%>">删除员工</a></td>
					</tr>
					<tr>
						<td><a href="#">员工角色</a></td>
						<td><a href="#">密码查询</a></td>
					</tr>
					<tr class="alt">
						<td><a href="#">员工模块授权</a></td>
						<td><a href="UserPowerChange.jsp">员工功能授权</a></td>
					</tr>
					<tr>
						<td><a
							href="Usermanage.jsp?uid=<%=Integer.parseInt(u.getUser_id()) - 1 >= 1 ? Integer
					.parseInt(u.getUser_id()) - 1 : u.getUser_id()%>">上移一位</a></td>
						<td><a
							href="Usermanage.jsp?uid=<%=Integer.parseInt(u.getUser_id()) + 1 <= User_geter
					.MaxNum() ? Integer.parseInt(u.getUser_id()) + 1 : u
					.getUser_id()%>">下移一位</a></td>
					</tr>
				</tbody>
			</table>


		</div>
	</div>

	<script>
		if (
	<%=request.getParameter("issuccess")%>
		== false)
			alert("修改失败！");
		if (
	<%=request.getParameter("issuccess")%>
		== true)
			alert("修改成功！");
			
			if (
	<%=request.getParameter("ispowerchangesuccess")%>
		== true)
			alert("功能权限修改成功！");
			if (
	<%=request.getParameter("ispowerchangesuccess")%>
		== false)
			alert("功能权限修改失败！");
	</script>

</body>
</html>
