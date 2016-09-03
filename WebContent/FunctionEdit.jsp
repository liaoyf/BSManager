<%@page import="com.bsObject.Module"%>
<%@page import="com.bsObject.Function"%>
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

<title>My JSP 'FunctionEdit.jsp' starting page</title>

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
	Function f = (Function) session.getAttribute("ActiveFunction");
%>


<body>
	<div class="contentbox" style="width:70%; margin:auto">
		<div class="headings">
			<h2>
				当前功能：<%=f.getFunction_name()%></h2>
		</div>
		<div class="contentbox">
			<form action="servlet/changefunction" method="post"
				onsubmit="return mycheck()" name="functiontable">
				<table class="tab2">

					<tbody>
						<tr>
							<td>功能ID</td>

							<td><input type="text" name="function_id" class="inputbox"
								value="<%=f.getFunction_id()%>" readonly /></td>
						</tr>
						<tr>
							<td>功能名</td>

							<td><input type="text" name="function_name" class="inputbox"
								value="<%=f.getFunction_name()%>" /> <input type="hidden"
								name="module_id" value="<%=f.getModule_id()%>" /></td>
						</tr>
						<tr>
							<td>URL</td>
							<td><input type="text" name="function_url" class="inputbox"
								value="<%=f.getFunction_url()%>" /></td>
						</tr>
						<tr>
							<td>Order</td>
							<td><input type="text" name="function_order" class="inputbox"
								value="<%=f.getFunction_order()%>" /></td>
						</tr>
						<tr>
							<td>打开方式</td>
							<td style="text-align: left;"><select name="Openstyle">
									<option value="centerpag">右侧</option>
									<option value="_blank">新窗口</option>
							</select></td>

						</tr>
						<tr>
							<td>功能简述</td>
							<td><textarea name="function_des"
									style="margin:auto; width:100%; height:100px"><%=f.getFunction_des()%></textarea></td>
						</tr>
					</tbody>
				</table>
				<br> <br>
				<table style="margin:auto; width:50%">
					<tr>
						<td><input type="submit" value="确定" class="btn"></td>
						<td><input type="button" value="取消 " class="btnalt"
							onclick="javascript:history.back()"></td>
						<td><input type="button" value="删除 " class="btnalt"
							onclick="javascript:history.back()"></td>
					</tr>
				</table>

			</form>


		</div>
	</div>



</body>
</html>
