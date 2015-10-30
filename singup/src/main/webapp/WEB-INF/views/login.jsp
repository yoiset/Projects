<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

<script type="text/javascript">
    function login() {
        $.ajax({
            url : 'login',
            success : function(data) {
                $('#result').html(data);
            }
        });
    }
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

	<div style="padding-left: 500px">
		<p>User Login</p>
	</div>
	<br>
	
	<div style="padding-left: 500px">
		<form action="login" method="get">
			<table>
				<tr>
					<td><label for="userName">UserName</label></td>
					<td><input  id="userName" required type="text" name="userName"></td>
				</tr>
				
				<tr>
					<td> </td>
					<td><input type="submit" value="login" onclick="validate()"/></td>
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