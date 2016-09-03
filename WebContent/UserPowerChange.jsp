<%@page import="com.bsObject.Function"%>
<%@page import="com.ObjectGeter.User_geter"%>
<%@page import="com.ObjectGeter.Function_geter"%>
<%@page import="com.ObjectGeter.DoubleList"%>
<%@page import="com.bsObject.User"%>
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

<title>My JSP 'UserPowerChange.jsp' starting page</title>

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

<BODY>
	<br>
	<br>
	<%
		User u = (User) session.getAttribute("ActiveUser");
		DoubleList<Function> dl = Function_geter.getDoubleList(User_geter
		.GetRelation(u.getUser_id()));
		List<Function> selectedfunction = dl.getList1();
		List<Function> unselectedfunction = dl.getList2();
	%>
	<div class="contentcontainer">
		<div class="headings">
			<h2>
				功能授权修改：<%=u.getUser_name()%></h2>
		</div>
		<div class="contentbox">
			<FORM name="form1" method="post" action="servlet/changepower"
				onsubmit="return selectAll()">
				<input type="hidden" value="<%=u.getUser_id()%>" name="user_id" />
				<table>
					<tr>
						<td>已有权限<br> <select name="left" size="20" id="selected"
							multiple style="width:200px;">
								<%
									for (Function f1 : selectedfunction) {
								%>
								<option value="<%=f1.getFunction_id()%>"><%=f1.getFunction_name()%></option>
								<%
									}
								%>
						</select></td>
						<td style="width: 5%; ">
							<table style="height: 250px; ">
								<tr>
									<td><input class="btnch" type="button"
										value="&gt;&gt;&gt;"
										onClick="moveSelected(document.all.left,document.all.right)"></td>
								</tr>
								<tr>
									<td><input class="btnch" type="button"
										value="&lt;&lt;&lt;"
										onClick="moveSelected(document.all.right,document.all.left)"></td>
								</tr>
							</table>
						</td>
						<td>未拥有权限<br> <select name="right" size="20"
							id="unselected" multiple style="width:200px; ">
								<%
									for (Function f2 : unselectedfunction) {
								%>
								<option value="<%=f2.getFunction_id()%>"><%=f2.getFunction_name()%></option>
								<%
									}
								%>
						</select></td>
					</tr>
				</table>
				<br> <br>

				<table style="margin:auto; width:50%">
					<tr>

						<td><input type="submit" value="确定" class="btn" /></td>
						<td><input type="button" value="返回 " class="btnalt"
							onclick="javascript:history.back()" /></td>
					</tr>
				</table>
				<br>
			</FORM>

		</div>
	</div>
	<script type="text/javascript" src="js/selectListTools.js"></script>
	<script type="text/javascript">
		function selectAll() {
			listLength = form1.selected.options.length;
			for (var i = 0; i < listLength; i++) {
				form1.selected.options[i].selected = true;
			}
			listLength = form1.unselected.options.length;
			for (var i = 0; i < listLength; i++) {
				form1.unselected.options[i].selected = true;
			}
			return 1;
		}
	</script>
</BODY>
</html>
