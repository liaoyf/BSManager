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

<title>My JSP 'ModuleEdit.jsp' starting page</title>

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
		Module m = (Module) session.getAttribute("ActiveModule");
	%>

	<div class="contentbox">
		<div class="headings">
			<h2>模块修改:<%=m.getModule_name()%></h2>
		</div>
		<form action="servlet/changemodule" method="post"
			onsubmit="return mycheck()" name="moduletable">
			<table class="tab2">
				<tbody>
					<tr>
						<td>模块ID：</td>
						<td><input type="text" name="Org_id" class="inputbox"
							value="<%=m.getModule_id()%>" readonly> <br>
							<input type="hidden" name="up_module_id" value="<%=m.getUp_module_id()%>" />
							</td>
						<td>模块名称：</td>
						<td><input type="text" name="Org_name" class="inputbox"
							value="<%=m.getModule_name()%>"> <br></td>
					</tr>
					<tr>
						<td>模块链接：</td>
						<td><input type="text" name="Org_id" class="inputbox"
							value="<%=m.getModule_url()%>" readonly> <br></td>
						<td>模块顺序：</td>
						<td><input type="text" name="Org_name" class="inputbox"
							value="<%=m.getModule_order()%>"> <br></td>
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
