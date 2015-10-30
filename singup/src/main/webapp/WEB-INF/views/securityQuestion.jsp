<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Security Question</title>
</head>
<body>


<div style="padding-left: 500px">
		<p>Security Question</p>
	</div>
	<br>
	
	<div style="padding-left: 500px">
		<form action="validateQuestion" method="post">
			<table>
				<tr>
					<td><label for="response">${question}</label></td>
					<td><input id="response" type="text" name="response"></td>
				</tr>
				
				<tr>
					<td> </td>
					<td><input type="submit" value="Answer" /></td>
					<td><input type="hidden" name="userName" value="${userName}"></td>
					<td><input type="hidden" name="question" value="${question}"></td>
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