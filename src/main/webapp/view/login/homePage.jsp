<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/homePage.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/common/jquery.min.js"></script>
<script type="text/javascript" src="js/homePage/homePage.js"></script>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<form:form action="verifyUser" method="post" modelAttribute="User" autocomplete="off">
	<div class="align-center login-bg box-effect h183">
	
		<div class="center-align"><h3>Padhye co.ltd</h3> </div>
		
		<table class="ml191">
			<tr>
				<td><form:input id="userName" class="box-effect" path="userName" title="Enter User Name"/></td>
			</tr>
			<tr>
				<td><form:password id="password" class="box-effect" path="password" title="Enter Password"/></td>
			</tr>
		</table>
		
		<div class = "center-align mt10">
			<button class="button" onclick="return valiateFields();">Login</button>
		</div>
		<div class = "center-align mt10 red">
			<c:if test="${not empty error}">${error}</c:if>
		</div>
	</div>
</form:form>
</body>
</html>