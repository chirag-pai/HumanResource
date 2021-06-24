function validateFormFieldsAndSubmitForm(e) {
	var employeeId = $("#employeeId").val();
	if(employeeId == -1) {
		alert("Select Valid Employee Name from the drop-down.");
		return false;
	}
	var fromDate = $("#fromDate").val();
	if(!fromDate) {
		alert("Please select From Date.");
		return false;
	}
	var toDate = $("#toDate").val();
	if(!toDate) {
		alert("Please select To Date.");
		return false;
	}
	$("#fromDateReport").val("1901-01-01");
	$("#toDateReport").val("1901-01-01");
	submitLeaveManagementForm(e);
}

function submitLeaveManagementForm(e){
	e.preventDefault();
	$("#submitLeaves").attr("disabled",true);
	$.ajax({
	    data:$("#LMForm").serialize(),
	    url : "submitLeave",
	    type : "post",
	    success : function(response) {
	    	alert("Leave has been submitted successfully.");
	    	resetFormFields();
	    },
	    error: function(errorResponse) {
	    	alert("Some error Occurred. Please contact Administration.");
	    	resetFormFields();
	    }
	});
};

function resetFormFields() {
	$("#LMForm").trigger("reset");
	$("#submitLeaves").attr("disabled",false);
}

$( function() {
	$("#fromDate, #toDate").datepicker({
		dateFormat: "yy-mm-dd",
		changeMonth: true,
		changeYear: true
	});
});

function findDateDiff() {
	var fromDate = $("#fromDate").val();
	var toDate = $("#toDate").val();
	if(!fromDate || !toDate) {
		$("#numberOfDays").val("--NA--");
	}
	else{
		fromDate = new Date(fromDate);
		toDate = new Date(toDate);
		if(toDate < fromDate) {
			$("#numberOfDays").val("--NA--");
		}else{
			$("#numberOfDays").val(toDate.getDate() - fromDate.getDate() + 1);
		}
	}
};