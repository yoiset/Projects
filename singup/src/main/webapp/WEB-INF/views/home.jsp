<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<head>
<title>Home</title>
</head>
<body>
	<div style="padding-left: 500px">
		<h1>Challenge #1 !</h1>
	</div>

	<br>
	<div style="padding-left: 500px">
		<a href="loginAction"> <input type="submit" value="Login" /></a> <br>
		<a href="singup"> <input type="submit" value="Singup" /></a>
		
		<br>

		${message}
	</div>




</body>
</html>
