<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<script type="text/javascript" src="js/leaves/leaveManagement.js"></script>
<form:form modelAttribute="employee" autocomplete="off" id="LMForm">
<div>
 	<table>
		<tr>
			<td> Select Employee: </td>
			<td>
				<form:select path="employeeId" id="employeeId">
					<form:option value="-1">--Please Select--</form:option>
					<form:options items="${employeeList}"/>
				</form:select>
			</td>
		</tr>
		<tr>
			<td>Leave From Date:</td>
			<td><form:input id="fromDate" path="fromDate" onchange="findDateDiff()"></form:input></td>
		</tr>
		<tr>
			<td>Leave To Date:</td>
			<td><form:input id="toDate" path="toDate" onchange="findDateDiff()"></form:input></td>
		</tr>
		<tr>
			<td>Number of Days:</td>
			<td><form:input path="numberOfDays" id="numberOfDays" readonly="true"/> </td>
		</tr>
		<tr>
			<td>Reason:</td>
			<td><form:textarea path="reason" rows="10" cols="20"></form:textarea></td>
		</tr>
		<tr>
			<td colspan="2"><button class="button" id="submitLeaves" onclick=" return validateFormFieldsAndSubmitForm(event);">Submit</button></td>
		</tr>
	</table>
</div>
</form:form>