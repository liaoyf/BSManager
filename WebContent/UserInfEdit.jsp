<%@page import="com.bsObject.Org"%>
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

<title>My JSP 'UserInfEdit.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="styles/mycss.css" rel="stylesheet" type="text/css" />


</head>

<body>
	<%
		User u = (User) session.getAttribute("ActiveUser");
		
	%>

	<br>
	<br>
	<div class="contentcontainer">
		<div class="headings">
			<h2>
				当前用户姓名：<%=u.getUser_name()%></h2>
		</div>
		<div class="contentbox">
			<form action="servlet/changeuser" method="post">
				<table class="tab2">
					<tbody>
						<tr>
							<td>用户ID：</td>
							<td><input type="text" name="User_id" class="inputbox"
								value="<%=u.getUser_id()%>" readonly /> <br /> <input
								type="hidden" name="org_id" value="<%=u.getOrg_id() %>" /></td>
							<td>用户姓名：</td>
							<td><input type="text" name="User_name" class="inputbox"
								value="<%=u.getUser_name()%>" /> <br /></td>
						</tr>
						<tr>
							<td>性 别：</td>
							<td><input type="text" name="Gender" class="inputbox"
								value="<%=u.getGender()%>" /> <br /></td>
							<td>家庭住址：</td>
							<td><input type="text" name="Address" class="inputbox"
								value="<%=u.getAddress()%>" /> <br /></td>
						</tr>
						<tr>
							<td>邮编：</td>
							<td><input type="text" name="Mail" class="inputbox"
								value="<%=u.getMail()%>" /> <br /></td>
							<td>E-Mail：</td>
							<td><input type="text" name="E_mail" class="inputbox"
								value="<%=u.getE_mail()%>" /> <br /></td>
						</tr>
						<tr>
							<td>年 龄：</td>
							<td><input type="text" name="Age" class="inputbox"
								value="<%=u.getAge()%>" /> <br /></td>
							<td>联系电话：</td>
							<td><input type="text" name="User_tel" class="inputbox"
								value="<%=u.getUser_tel()%>" /> <br /></td>
						</tr>
						<tr>
							<td>毕业学校：</td>
							<td><input type="text" name="Byschool" class="inputbox"
								value="<%=u.getByschool()%>" /> <br /></td>
							<td>毕业时间：</td>
							<td><input type="text" name="Bydate" class="inputbox"
								value="<%=u.getBydate()%>" /> <br /></td>
						</tr>
						<tr>
							<td>SUBJECT：</td>
							<td><input type="text" name="Subject" class="inputbox"
								value="<%=u.getSubject()%>" /> <br /></td>
							<td>教育程度：</td>
							<td><input type="text" name="Edu" class="inputbox"
								value="<%=u.getEdu()%>" /> <br /></td>
						</tr>
						<tr>
							<td>婚姻状况：</td>
							<td><input type="text" name="Marry" class="inputbox"
								value="<%=u.getMarry()%>" /> <br /></td>
							<td>省 份：</td>
							<td><input type="text" name="Province" class="inputbox"
								value="<%=u.getProvince()%>" /> <br /></td>
						</tr>
						<tr>
							<td>国 家：</td>
							<td><input type="text" name="Nation" class="inputbox"
								value="<%=u.getNation()%>" /> <br /></td>
							<td>出生日期：</td>
							<td><input type="text" name="User_birth" class="inputbox"
								value="<%=u.getUser_birth()%>" /> <br /></td>
						</tr>
					</tbody>
				</table>
				<br />
				<table style="margin:auto; width:50%">
					<tr>
						<td><input type="submit" value="提交" class="btn" /></td>
						<td><input type="button" value="返回 " class="btnalt"
							onclick="javascript:history.back()" /></td>
					</tr>
				</table>
			</form>
		</div>

	</div>





</body>
</html>
