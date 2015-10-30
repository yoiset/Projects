<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
	
	function loader(enable) {

		if (enable) {
			$('#loading').show();
			//     		$("#content").children().prop('disabled',true);
		} else {
			$('#loading').hide();
		}

	}

	function ajaxCall() {

		var zipcode = $('#zipcode').val();

		$('#result').empty();

		// Check if empty of not
		if (zipcode === '') {
			alert('Zip Code field is empty.');
			return false;
		}

		loader(true);

		$.ajax({
			url : '${pageContext.request.contextPath}/forecast/' + zipcode,
			type : 'POST',
			success : function(response) {
				var data = JSON.parse(response);
				settingData(data);
				loader(false);
			}
		});

	}

	function settingData(data) {

		alert('Response Value: ' + data[0]);
		
		for (var i = 0; i < data.length; i++) {
			if (data[i].message != undefined)
				$('#result').append(
						'<div> <p> Zip Code: ' + data[i].zipcode + ' </p>'
								+ data[i].message + '</div>' + '<br>');
			else {
				var htmlHeader = '<div>' + '<p>State:</p>' + data[i].state
						+ '<p>City:</p>' + data[i].city + '<table>' + '<thead>'
						+ '<tr>' + '<td>Date </td>' + '<td>Time</td>'
						+ '<td>Description</td>' + '<td>morningLow</td>'
						+ '<td>daytimeHigh</td>' + '<tr>' + ' </thead>'
						+ '<tr>';

				var htmlContent = '';

				if (data[i].contents != undefined) {

					for (var j = 0; j < data[i].contents.length; j++) {
						htmlContent = '<td>' + data[i].contents[j].date
								+ '</td>' + '<td>' + data[i].contents[j].time
								+ '</td>' + '<td>'
								+ data[i].contents[j].description + '</td>'
								+ '<td>' + data[i].contents[j].morningLow
								+ '</td>' + '<td>'
								+ data[i].contents[j].daytimeHigh + '</td>';
					}
				}

				var htmlEnd = '<tr>' + '</table>' + '</div>';

				$('#result').append(htmlHeader + htmlContent + htmlEnd);
			}

		}

	}
</script>
</head>
<body>
	<div style="padding-left: 500px">
		<p>ForeCast</p>
	</div>
	<br>


	<div id="content" style="padding-left: 500px">
		<!-- 		<form action="login" method="get"> -->
		<table>
			<tr>
				<td><label for="zipcode">Zip Code</label></td>
				<td><input id="zipcode" required type="text" name="zipcode"></td>
			</tr>

			<tr>
				<td></td>
				<td><input id="submit" type="submit" value="ForeCast"
					onclick="ajaxCall()" /></td>
				<td></td>
			</tr>

		</table>
		<br>
		<!-- 		</form> -->
	</div>

	<div style="padding-left: 500px">
		<div id="loading" style="display: none">
			<img src="resources/gif/ajax-loader.gif" />
		</div>

		<div id="result"></div>
		<div id="result2"></div>
		<!-- 		<div> -->
		<!-- 			<p>State:</p> -->
		<!-- 			<p>City:</p> -->
		<!-- 			<p>Message:</p> -->
		<!-- 			<table> -->
		<!-- 			  <thead> -->
		<!-- 			   <tr> -->
		<!-- 					<td>Date </td> -->
		<!-- 					<td>Time</td> -->
		<!-- 					<td>Description</td> -->
		<!-- 					<td>morningLow</td> -->
		<!-- 					<td>daytimeHigh</td> -->
		<!-- 				<tr> -->
		<!-- 			  </thead> -->
		<!-- 				<tr> -->
		<!-- 					<td>Date1 </td> -->
		<!-- 					<td>Time1</td> -->
		<!-- 					<td>Description1</td> -->
		<!-- 					<td>morningLow1</td> -->
		<!-- 					<td>daytimeHigh1</td> -->
		<!-- 				<tr> -->
		<!-- 			</table> -->
		<!-- 		</div> -->

	</div>
	<%-- 	server is ${serverTime}. --%>
</body>
</html>
