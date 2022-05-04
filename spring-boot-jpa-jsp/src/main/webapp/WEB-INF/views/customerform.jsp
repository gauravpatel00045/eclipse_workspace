<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/error.css" />
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>

<script type="text/javascript">

$('#submit').click(function(){
	   $('#register_form').attr('action', <c:if test="${customer != null}">'/update'</c:if> <c:if test="${customer == null}">'/register'</c:if>);
	})

</script>

<title>Customer Registration</title>
</head>

<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div class="navbar-brand">Customer Registration</div>

			<ul class="navbar-nav">
				<li><a href="/customerlist" class="nav-link">Customer List</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

				<form method="post" action="/register" id="register_form"
					name="register_form">

					<h2>
						<c:if test="${customer != null}">
            			Edit User
            		</c:if>
						<c:if test="${customer == null}">
							<input type="hidden" name="id" id="id"
								value="<c:out value='0' />" />
							
            			Add Customer
            		</c:if>
					</h2>

					<c:if test="${customer != null}">
						<input type="hidden" name="id" id="id"
							value="<c:out value='${customer.id}' />" />
					</c:if>

					<fieldset class="form-group">
						<label>First Name</label> <input type="text"
							value="<c:out value='${customer.firstName}' />"
							class="form-control" name="firstName">
					</fieldset>
					<fieldset class="form-group">
						<label>Last Name</label> <input type="text"
							value="<c:out value='${customer.lastName}' />"
							class="form-control" name="lastName">
					</fieldset>
					<fieldset class="form-group">
						<label>Address 1</label> <input type="text"
							value="<c:out value='${customer.address_1}' />"
							class="form-control" name="address_1" required="required">
					</fieldset>
					<fieldset class="form-group">
						<label>Address 2</label> <input type="text"
							value="<c:out value='${customer.address_2}' />"
							class="form-control" name="address_2">
					</fieldset>
					<div class="form-row">
						<fieldset class="form-group col-md-6">
							<label>Age</label> <input type="text"
								value="<c:out value='${customer.age}' />" class="form-control"
								name="age" maxlength="3">
						</fieldset>
						<fieldset class="form-group col-md-6">
							<label>Birth date</label> <input type="date" id="birthDate"
								name="birthDate" value="<c:out value='${customer.birthDate}' />"
								class="form-control" required="required" />
						</fieldset>

					</div>

					<fieldset class="form-group">
						<label>Gender</label>
						<div class="form-control">
							<input type="radio" name="gender" value="male"
								${customer.gender=='male'?'checked':''}> Male <input
								type="radio" name="gender" value="female"
								${customer.gender=='female'?'checked':''}> Female
						</div>
					</fieldset>
					<fieldset class="form-group">
						<label>Email</label> <input type="text"
							value="<c:out value='${customer.email}' />" class="form-control"
							name="email" id="email">

					</fieldset>

					<fieldset class="form-group">
						<label>Mobile</label> <input type="text"
							value="<c:out value='${customer.mobile}' />" class="form-control"
							name="mobile" id="mobile" maxlength="10">
					</fieldset>

					<c:if test="${customer != null}">
						<button type="submit" name="btnsubmit" id="btnsubmit"
							class="btn btn-success">Update</button>
					</c:if>
					<c:if test="${customer == null}">
						<button type="submit" name="btnsubmit" id="btnsubmit"
							class="btn btn-success">Save</button>
					</c:if>

					<br />
					<div >
						<p id="errormsg">Status: ${message}</p>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>