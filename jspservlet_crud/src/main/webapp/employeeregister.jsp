<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<div align="center">
		<h1>Employee Register Form</h1>
		<form action="<%=request.getContextPath()%>/register" method="post">
			<table style="with: 80%">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName" required
						maxlength="50" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName" required maxlength="50" /></td>
				</tr>
				<tr>
					<td>UserName</td>
					<td><input type="text" name="username" required maxlength="50" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" required
						maxlength="50" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address" required maxlength="50" /></td>
				</tr>
				<tr>
					<td>Contact No</td>
					<td><input type="tel" name="contact" pattern="^[0-9]*$" required
						maxlength="10" /></td>
				</tr>
			</table>
			<input type="submit" value="Submit" />
		</form>
	</div>
</body>
</html>