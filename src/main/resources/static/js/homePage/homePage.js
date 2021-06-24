function valiateFields(){
	var userName = $("#userName").val();
	var password = $("#password").val();
	if(!userName){
		alert("Enter valid User Name.");
		return false;
	}
		
	if(!password){
		alert("Enter valid password.");
		return false;
	}
}