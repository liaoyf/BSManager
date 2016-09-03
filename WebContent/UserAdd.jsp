<%@page import="com.ObjectGeter.User_geter"%>
<%@page import="com.bsObject.Org"%>
<%@ page import="com.bsObject.User"%>
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
		if (document.usertable.User_id.value == "") {
			alert("请输入ID!");
			document.usertable.User_id.focus();
			return false;
		}
		if (document.usertable.User_name.value == "") {
			alert("请输入ID!");
			document.usertable.User_name.focus();
			return false;
		}
		if (document.usertable.Gender.value == "") {
			alert("请输入ID!");
			document.usertable.Gender.focus();
			return false;
		}
		if (document.usertable.Address.value == "") {
			alert("请输入ID!");
			document.usertable.Address.focus();
			return false;
		}
		if (document.usertable.Mail.value == "") {
			alert("请输入ID!");
			document.usertable.Mail.focus();
			return false;
		}
		if (document.usertable.E_mail.value == "") {
			alert("请输入ID!");
			document.usertable.E_mail.focus();
			return false;
		}
		if (document.usertable.Age.value == "") {
			alert("请输入ID!");
			document.usertable.Age.focus();
			return false;
		}
		if (document.usertable.User_tel.value == "") {
			alert("请输入ID!");
			document.usertable.User_tel.focus();
			return false;
		}
		if (document.usertable.Byschool.value == "") {
			alert("请输入ID!");
			document.usertable.Byschool.focus();
			return false;
		}
		if (document.usertable.Bydate.value == "") {
			alert("请输入ID!");
			document.usertable.Bydate.focus();
			return false;
		}
		if (document.usertable.Subject.value == "") {
			alert("请输入ID!");
			document.usertable.Subject.focus();
			return false;
		}
		if (document.usertable.Edu.value == "") {
			alert("请输入ID!");
			document.usertable.Edu.focus();
			return false;
		}
		if (document.usertable.Marry.value == "") {
			alert("请输入ID!");
			document.usertable.Marry.focus();
			return false;
		}
		if (document.usertable.Province.value == "") {
			alert("请输入ID!");
			document.usertable.Province.focus();
			return false;
		}
		if (document.usertable.Nation.value == "") {
			alert("请输入ID!");
			document.usertable.Nation.focus();
			return false;
		}
		if (document.usertable.User_birth.value == "") {
			alert("请输入ID!");
			document.usertable.User_birth.focus();
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
		User u = new User();
		Org o = (Org) session.getAttribute("ActiveOrg");
		
	%>

	<div class="contentbox">
		<div class="headings">
			<h2>用户添加</h2>
		</div>
		<form action="servlet/useradd" method="post"
			onsubmit="return mycheck()" name="usertable">
			<table class="tab2">
				<tbody>
					<tr>
						<td>用户ID：</td>
						<td><input type="text" name="User_id" class="inputbox"
							value="<%=User_geter.CountTheNextId(o.getOrg_id())%>" readonly /> <br> 
							<input type="hidden" name="org_id" value="<%=o.getOrg_id() %>" />
							</td>
						<td>用户姓名：</td>
						<td><input type="text" name="User_name" class="inputbox"
							value=""> <br></td>
					</tr>
					<tr>
						<td>性 别：</td>
						<td><input type="text" name="Gender" class="inputbox"
							value=""> <br></td>
						<td>家庭住址：</td>
						<td><input type="text" name="Address" class="inputbox"
							value=""> <br></td>
					</tr>
					<tr>
						<td>邮编：</td>
						<td><input type="text" name="Mail" class="inputbox" value="">
							<br></td>
						<td>E-Mail：</td>
						<td><input type="text" name="E_mail" class="inputbox"
							value=""> <br></td>
					</tr>
					<tr>
						<td>年 龄：</td>
						<td><input type="text" name="Age" class="inputbox" value="">
							<br></td>
						<td>联系电话：</td>
						<td><input type="text" name="User_tel" class="inputbox"
							value=""> <br></td>
					</tr>
					<tr>
						<td>毕业学校：</td>
						<td><input type="text" name="Byschool" class="inputbox"
							value=""> <br></td>
						<td>毕业时间：</td>
						<td><input type="text" name="Bydate" class="inputbox"
							value=""> <br></td>
					</tr>
					<tr>
						<td>SUBJECT：</td>
						<td><input type="text" name="Subject" class="inputbox"
							value=""> <br></td>
						<td>教育程度：</td>
						<td><input type="text" name="Edu" class="inputbox" value="">
							<br></td>
					</tr>
					<tr>
						<td>婚姻状况：</td>
						<td><input type="text" name="Marry" class="inputbox" value="">
							<br></td>
						<td>省 份：</td>
						<td><input type="text" name="Province" class="inputbox"
							value=""> <br></td>
					</tr>
					<tr>
						<td>国 家：</td>
						<td><input type="text" name="Nation" class="inputbox"
							value=""> <br></td>
						<td>出生日期：</td>
						<td><input type="text" name="User_birth" class="inputbox"
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
