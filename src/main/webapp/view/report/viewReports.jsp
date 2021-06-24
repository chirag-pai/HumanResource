<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<script type="text/javascript" src="js/reports/reports.js"></script>
<form:form id="viewReports" modelAttribute="report" autocomplete="off">
	<div>
		<table>
			<tr>
				<td>Report From Date</td>
				<td>:</td>
				<td><form:input id="fromDateReport" path="fromDate"></form:input></td>
				<td></td><td></td>
				<td>Report To Date</td>
				<td>:</td>
				<td><form:input id="toDateReport" path="toDate"></form:input></td>
				<td><button class="button" id="fetchLeaveReport" onclick=" return fetchReport(event);">Generate Report</button></td>
			</tr>
		</table>
	</div>
	<div class="report-table" id="reportData"></div>
</form:form>