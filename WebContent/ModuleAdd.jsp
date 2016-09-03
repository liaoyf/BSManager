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

<title>My JSP 'ModuleAdd.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="styles/mycss.css" rel="stylesheet" type="text/css" />

<SCRIPT LANGUAGE="JavaScript">
	function mycheck() {
		if (document.moduletable.module_id.value == "") {
			alert("请输入ID!");
			document.moduletable.module_id.focus();
			return false;
		}
	}
	
	if (<%=request.getParameter("isaddsuccess")%> == true)
		alert("添加成功！");
	if (<%=request.getParameter("isaddsuccess")%> == false)
		alert("添加失败！");
		
</script>


</head>

<body>
	<%
		Module m = new Module();
		Module up_m = (Module)session.getAttribute("ActiveModule");
		
	%>

	<div class="contentbox" style="width:80%;margin: auto">
		<div class="headings">
			<h2>模块添加</h2>
		</div>
		<form action="servlet/moduleadd" method="post"
			onsubmit="return mycheck()" name="moduletable">
			<table class="tab2">
				<tbody>
					<tr>
						<td>模块ID：</td>
						<td><input type="text" name="module_id" class="inputbox"
							value="<%=Module_geter.CountTheNextId(up_m.getModule_id())%>" readonly /> <br>
							<input type="hidden" name="up_module_id" value="<%=up_m.getModule_id()%>" />
							</td>
						<td>模块名称：</td>
						<td><input type="text" name="module_name" class="inputbox"
							value=""> <br></td>
					</tr>
					<tr>
						<td>模块链接：</td>
						<td><input type="text" name="module_url" class="inputbox"
							value=""> <br></td>
						<td>模块顺序：</td>
						<td><input type="text" name="module_order" class="inputbox"
							value=""> <br></td>
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
</body>
</html>
