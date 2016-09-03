<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.dtree.NodeDb"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Tree</title>
<link rel="StyleSheet" type="text/css" href="styles/dtree.css" />
<link rel="StyleSheet" type="text/css" href="styles/mycss.css" />
<script type="text/javascript" src="js/dtree.js"></script>
</head>
<body style="background:#F7F7F7">
	<div class="contentcontainer">

		<br>
		<script type="text/javascript">  
			eval('<%=new NodeDb().getJSTreeString()%>');
		</script>
	</div>
</body>
</html>
