$(document).ready(function() {
	// To Restrict future date selection in date input
	stopFutureDateSelection();

	callRegisterFormValidate();


});// JavaScript Document

// To Restrict future date selection in date input
function stopFutureDateSelection() {
	var dtToday = new Date();

	var month = dtToday.getMonth() + 1;
	var day = dtToday.getDate();
	var year = dtToday.getFullYear();

	if (month < 10)
		month = '0' + month.toString();
	if (day < 10)
		day = '0' + day.toString();

	var maxDate = year + '-' + month + '-' + day;

	$('#birthDate').attr('max', maxDate);
}

// To initialise the validate function while user interact with the form
function callRegisterFormValidate() {
	$("form[name='register_form']").validate({
		// Specify validation rules
		rules: {
			firstName: "required",
			lastName: "required",
			birthDate: "required",
			address1: "required",
			birthDate: {
			},
			age: {
				required: true,
				digits: true,
				maxlength: 3,
			},
			gender: {
				required: true,
			},
			email: {
				required: true,
				email: true,
				regex: /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/,
			},
			mobile: {
				required: true,
				digits: true,
				minlength: 10,
				maxlength: 10,
			}
		},

		messages: {
			firstName: {
				required: "Please enter first name",
			},
			lastName: {
				required: "Please enter last name",
			},
			birthDate: {
				required: "Select date of birth",
			},
			mobile: {
				required: "Please enter phone number",
				digits: "Please enter valid phone number",
				minlength: "Accept only 10 digits",
				maxlength: "Accept only 10 digits",
			},
			age: {
				required: "Please enter age",
				digits: "Please enter digits only",
			},
			gender: {
				required: "Select gender",
			},
			email: {
				required: "Please enter email address",
				email: "Please enter a valid email address.",
			},
		},

		submitHandler: function(form) {
			isEmailExist(form)
		}
	});

}

// ajax call to check email 
function isEmailExist(form) {

	var customerId = $("#id").val();
	var enteredEmail = $("#email").val();
	var enteredMobile = $("#mobile").val();

	console.log("isEmailExist started")

	$.ajax({
		type: 'post',
		url: 'checkemail',
		data: {
			email: enteredEmail,
			id: customerId,
			mobile: enteredMobile,
		}, success: function(response) {
			if (response == "unique") {
				$("#errormsg").text("Email is unique");
				isMobileExist(form)
			} else {
				$('#email').focus();
				$("#email").html("Email already registered");
				$("#errormsg").text("Email already registered");
			}
		},
		failure: function(response) {
			alert(response);
		}
	});
}

// ajax call to check  mobile 
function isMobileExist(form) {

	var customerId = $("#id").val();
	var enteredEmail = $("#email").val();
	var enteredMobile = $("#mobile").val();

	console.log("isMobileExist started")

	$.ajax({
		type: 'post',
		url: 'checkmobile',
		data: {
			email: enteredEmail,
			id: customerId,
			mobile: enteredMobile,
		},
		success: function(response) {
			if (response == "unique") {
				$("#errormsg").text("Mobile is unique");
				form.submit();
			} else {
				$('#mobile').focus();
				$("#mobile").html("Mobile already registered");
				$("#errormsg").text("Mobile already registered");
			}
		},
		error: function(response) {
			console.log(response);
			alert(response);
		}
	});
}

// ajax call to check email and phone 
function isEmailOrMobileExist(form) {

	var customerId = $("#id").val();
	var enteredEmail = $("#email").val();
	var enteredMobile = $("#mobile").val();

	console.log("checkemailandmobile started")

	$.ajax({
		type: 'post',
		url: 'checkemailandmobile',
		data: {
			email: enteredEmail,
			id: customerId,
			mobile: enteredMobile,
		},
		success: function(response) {
			if (response == "unique") {
				$("#errormsg").text("Email is unique");
				form.submit();
			} else {
				$('#email').focus();
				$("#email").html("Email or Mobile already registered");
				$("#errormsg").text("Email or Mobile already registered");
			}
		},
		error: function(response) {
			console.log(response);
			alert(response);
		}
	});
}

// To add rule for custom email validation in validate function
$.validator.addMethod(
	"regex",
	function(value, element, regexp) {
		var re = new RegExp(regexp);
		return this.optional(element) || re.test(value);
	},
	"Valid email address required."
);









