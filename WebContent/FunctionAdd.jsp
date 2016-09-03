<%@page import="com.ObjectGeter.Function_geter"%>
<%@page import="com.bsObject.Module"%>
<%@ page import="com.bsObject.Function"%>
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

<title>My JSP 'UserInfEdit.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="styles/mycss.css" rel="stylesheet" type="text/css" />





<SCRIPT LANGUAGE="JavaScript">
	function mycheck() {
		if (document.functiontable.function_id.value == "") {
			alert("请输入ID!");
			document.functiontable.function_id.focus();
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
		Function func = new Function();
		Module m = (Module)session.getAttribute("ActiveModule");
		func.setModule_id(m.getModule_id()); 

	%>

	<br>
	<br>

	<div class="contentbox" style="width:80%;margin: auto" >
		<div class="headings">
			<h2>
				功能权限添加</h2>
		</div>
		<form action="servlet/functionadd" method="post"
			onsubmit="return mycheck()" name="functiontable">
			<table class="tab2">
				<tbody>
					<tr>
						<td>功能ID：</td>
						<td><input type="text" name="function_id" class="inputbox"
							value="<%=Function_geter.CountTheNextId(m.getModule_id())%>" readonly /> <br>
							<input type="hidden" name="module_id" value="<%=m.getModule_id()%>"/>
							</td>
						<td>功能名称：</td>
						<td><input type="text" name="function_name" class="inputbox"
							value=""> <br></td>
					</tr>
					<tr>
						<td>功能描述：</td>
						<td><input type="text" name="function_des" class="inputbox"
							value=""> <br></td>
						<td>功能顺序：</td>
						<td><input type="text" name="function_order" class="inputbox"
							value=""> <br></td>
					</tr>
					<tr>
						<td>功能指向URL：</td>
						<td><input type="text" name="function_url" class="inputbox" value="">
							<br></td>
						<td>功能目标：</td>
						<td style="text-align: left;"><select name="Openstyle">
									<option value="centerpag">右侧</option>
									<option value="_blank">新窗口</option>
							</select></td>
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
