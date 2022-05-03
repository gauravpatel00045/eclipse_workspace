<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Customer Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.js"></script>

<title>Customer Management App</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="/" class="navbar-brand"> Customer Management
					Application </a>
			</div>
		</nav>
	</header>
	<br>

	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Customers</h3>
			<hr>

			<div class="form-raw">

				<a href="customerform" class="btn btn-success">Add New Customer</a>
				<a href="/deleteall" class="btn btn-danger"
					onclick="if (!(confirm('Are you sure you want to delete all record?'))) return false">Delete
					All</a>
			</div>


			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Actions</th>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Mobile</th>
						<th>Birth date</th>
						<th>Address</th>
						<th>Age</th>
						<th>Gender</th>
					</tr>
				</thead>
				<tbody>
					 <!-- customerlist -->
					<c:forEach var="customer" items="${customerList}">

						<tr>
							<td><a href="/edit?id=<c:out value='${customer.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="/delete?id=<c:out value='${customer.id}' />"
								onclick="if (!(confirm('Are you sure you want to delete ?'))) return false">Delete</a></td>
							<td><c:out value="${customer.id}" /></td>
							<td><c:out value="${customer.firstName}" /> <c:out
									value="${customer.lastName}" /></td>
							<td><c:out value="${customer.email}" /></td>
							<td><c:out value="${customer.mobile}" /></td>
							<td><c:out value="${customer.birthDate}" /></td>
							<td><c:out value="${customer.address_1}" /></td>
							<td><c:out value="${customer.age}" /></td>
							<td><c:out value="${customer.gender}" /></td>

						</tr>
					</c:forEach>

				</tbody>

			</table>
		</div>
	</div>
</body>
</html>