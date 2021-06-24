<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/dashboard.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://resources/demos/style.css"/>
<link href="css/common/jquery-ui.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/common/jquery.min.js"></script>
<script type="text/javascript" src="js/common/jquery-ui.min.js"></script>
<script type="text/javascript" src="js/dashboard/dashboard.js"></script>
<meta charset="ISO-8859-1">
<title>Attendance Management</title>
</head>
<body>
	<div class="tab float-container">
	  <div class="tablinks float-child" onmouseover="showSection(event, 'LeaveManagement')">Leave Management</div>
	  <div class="tablinks float-child" onmouseover="showSection(event, 'reports')">Reports</div>
	  <div class="tablinks float-child" onmouseover="showSection(event, 'addEmployee')">Add Employee</div>
	  <div class="tablinks float-child" onmouseover="showSection(event, 'updateEmployee')">Update/Delete Employee</div>
	</div>
	
	<div id="LeaveManagement" class="tabcontent"></div>
	<div id="reports" class="tabcontent"></div>
</body>
</html>