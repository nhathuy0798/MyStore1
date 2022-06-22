$(document).ready(function(){

   //Login	
	validateLogin = function(){
		var username = $("#userName").val();
		var password = $("#password").val();
		if( username == "" ){
			alert("Please enter username");
			$("#userName").focus();
		} else if( password == "" ){
			alert("Please enter password");
			$("#password").focus();
		}
	}	
	
	//register
	validateRegister = function(){
		var username = $("#user_name").val();
		var password = $("#password").val();
		var gender = $("#gender").val();
		var repassword = $("#repassword").val();
		var isvalidate = true ;
		if( username == "" ){
			alert("Please enter username");
			$("#user_name").focus();
			isvalidate = false;
		} else if( gender == "" ){
			alert("Please enter gender");
			$("#gender").focus();
			isvalidate = false;
		} else if( gender != "M" && gender != "F" ){
			alert("Please enter M(male) or F(female)");
			$("#gender").focus();
			isvalidate = false;
		} else if( password == "" ){
			alert("Please enter password");
			$("#password").focus();
			isvalidate = false;
		} else if( repassword == "" ){
			alert("Please enter confirm password");
			$("#repassword").focus();
			isvalidate = false;
		}else if( repassword != password ){
			alert("confirm password is different");
			$("#repassword").focus();
			isvalidate = false;
		}
		return isvalidate;
	}	
	
	validateEditProduct = function(){
		var name = $("#name").val();
		var price = $("#price").val();
		var imageFileName = $("#imageFileName").val();
		var isvalidate = true ;
		if( name == "" ){
			alert("Name is empty! ");
			$("#name").focus();
			isvalidate = false;
		} else if( price < 0 ){
			alert("Price is less more than zero");
			$("#price").focus();
			isvalidate = false;
		} 
		return isvalidate;
	}	
})

