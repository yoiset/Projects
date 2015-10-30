<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body> 

	<div style="padding-left: 500px">
		<p>Security question</p>
	</div>
	<br>


	<div style="padding-left: 500px">
		<form action="registerQuetions" method="get">
			<table>
				<tr>
					<td><label for="quetion1">Quetion #1</label> <br></td>
					<td>
					   <select name="quetion1">
					   <option value="empty"> </option>
					      <c:forEach items="${quetionList1}" var="q">
							  <option value="${q}"> ${q}" </option>
							</c:forEach>
						</select>
					</td>
					<td><input id="response1" type="text" name="response1"></td>
				</tr>

				<tr>
					<td><label for="quetion2">Quetion #2</label> <br></td>
					<td>
					
					<select name="quetion2">
					<option value="empty"> </option>
					      <c:forEach items="${quetionList2}" var="q">
							  <option value="${q}"> ${q}" </option>
							</c:forEach>
					</select>
						
					</td>
					<td><input id="response2" type="text" name="response2"></td>
				</tr>

				<tr>
					<td><label for="quetion3">Quetion #3</label> <br></td>
					<td>
					<select name="quetion3">
					<option value="empty"> </option>
					      <c:forEach items="${quetionList3}" var="q">
							  <option value="${q}"> ${q}" </option>
							</c:forEach>
					</select>
					</td>
					<td><input id="response3" type="text" name="response3"></td>
				</tr>
				
				<tr>
					<td> </td>
					<td><input type="submit" value="Enter Quetions" /></td>
					<td></td>
				</tr>

				<tr>
					<td><input type="hidden" value="${userName}"  name="userName"/></td>
					<td>${message}</td>
				</tr>

			</table>
			<br>
		</form>
	</div>
</body>
</html>