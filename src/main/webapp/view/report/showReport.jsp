<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="1">
<tr>
	<td>Employee Name</td>
	<td>From Date</td>
	<td>To Date</td>
	<td>Reason</td>
</tr>
<c:forEach var="emp" items="${reportList}">
<tr>
<td><div>${emp.employeeName}</div></td>
<td><div>${emp.fromDate}</div></td>
<td><div>${emp.toDate}</div></td>
<td><div>${emp.reason}</div></td>
<tr>
</c:forEach>

</table>