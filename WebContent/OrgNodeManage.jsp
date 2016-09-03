<%@page import="com.ObjectGeter.Org_geter"%>
<%@page import="com.bsObject.Org"%>
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

<title>My JSP 'OrgNodeManage.jsp' starting page</title>

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
	Org o = Org_geter.GetObjById(request.getParameter("oid"));
	session.setAttribute("ActiveOrg", o);
	if (request.getParameter("action") != null
			&& request.getParameter("action").equals("delete")) {
		response.sendRedirect("../BSManager/welcome.jsp?isorgdeletesuccess="
				+ Org_geter.DoOrgDelete(o.getOrg_id()));
	}
%>


<body>
	<br>
	<br>
	<div class="contentcontainer">
		<div class="headings altheading">
			<h2>
				当前部门：<%=o.getOrg_name()%></h2>
		</div>
		<div class="contentbox">
			<table>

				<tbody>
					<tr class="alt">
						<td><a href="OrgAdd.jsp">添加部门</a></td>
						<td><a href="OrgNodeManage.jsp?action=delete&oid=<%=o.getOrg_id()%>">删除部门</a></td>
					</tr>
					<tr>
						<td><a href="OrgEdit.jsp">编辑部门</a></td>
						<td><a href="#">添加角色</a></td>
					</tr>
					<tr class="alt">
						<td><a href="#">添加管理员</a></td>
						<td><a href="UserAdd.jsp">添加员工</a></td>
					</tr>
					<tr>
						<td><a href="#">查询员工</a></td>
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
