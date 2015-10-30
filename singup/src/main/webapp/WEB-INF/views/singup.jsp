<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Register</title>
</head>
<body>

	<div style="padding-left: 500px">
		<p>User SingUp</p>
	</div>
	<br>


	<div style="padding-left: 500px">
		<form action="register" method="get">
			<table>
				<tr>
					<td><label for="userName">UserName</label></td>
					<td><input id="userName" type="text" name="userName"></td>
				</tr>

				<tr>
					<td><label for="dob">Date of Birth</label></td>
					<td><input id="dob" type="date" name="dob"></td>
				</tr>

				<tr>
					<td> </td>
					<td><input type="submit" value="Register" /></td>
					<td></td>
				</tr>
				
				<tr>
					<td> </td>
					<td>${message}</td>
				</tr>

			</table>
			<br>
		</form>
	</div>

</body>
</html>