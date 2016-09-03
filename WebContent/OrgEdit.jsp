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

<title>My JSP 'OrgEdit.jsp' starting page</title>

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
		Org o = (Org) session.getAttribute("ActiveOrg");
	%>

	<div class="contentbox">
		<div class="headings">
			<h2>
				部门修改:<%=o.getOrg_name()%></h2>
		</div>
		<form action="servlet/changeorg" method="post"
			onsubmit="return mycheck()" name="orgtable">
			<table class="tab2">
				<tbody>
					<tr>
						<td>部门ID：</td>
						<td><input type="text" name="Org_id" class="inputbox"
							value="<%=o.getOrg_id()%>" readonly> <br> <input
							type="hidden" name="up_org_id" value="<%=o.getUp_org_id()%>" /></td>
						<td>部门名称：</td>
						<td><input type="text" name="Org_name" class="inputbox"
							value="<%=o.getOrg_name()%>"> <br></td>
					</tr>
				</tbody>
			</table>
			<br>
			<table style="margin:auto; width:50%">
				<tr>
					<td><input type="submit" value="提交" class="btn"></td>
					<td><input type="button" value="返回 " class="btnalt"
						onclick="javascript:history.back()"></td>
				</tr>
			</table>
		</form>
	</div>





	<br>


</body>
</html>
