function fetchReport(e) {
	var fromDate = $("#fromDateReport").val();
	if(!fromDate) {
		alert("Please enter valid Report From Date.");
		return false;
	}
	var toDate = $("#toDateReport").val();
	if(!toDate) {
		alert("Please enter valid Report To Date.");
		return false;
	}
	e.preventDefault();
	$("#fetchLeaveReport").attr("disabled",true);
	$.ajax({
	    data:$("#viewReports").serialize(),
	    url : "fetchReport",
	    type : "get",
	    success : function(response) {
	    	$("#reportData").html(response);
	    	resetFormFields();
	    },
	    error: function(errorResponse) {
	    	$("#reportData").html(errorResponse.responseText);
	    	resetFormFields();
	    }
	});
}

$( function() {
	$("#fromDateReport, #toDateReport").datepicker({
		dateFormat: "yy-mm-dd",
		changeMonth: true,
		changeYear: true
	});
});

function resetFormFields() {
	$("#viewReports").trigger("reset");
	$("#fetchLeaveReport").attr("disabled",false);
}