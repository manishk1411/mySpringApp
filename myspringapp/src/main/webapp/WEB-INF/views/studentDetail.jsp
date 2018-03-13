<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Student Detail Retrieved:!!!!!</h2>
	<p>
		<font color="red">${errorMessage}</font>
	</p>
	<table>
		<tr>
			<th>Student ID:</th>
			<th>First Name:</th>
			<th>Last Name:</th>
			<th>Address:</th>
			<th>Email:</th>
		</tr>

		<tr>
			<td>${student.studentId}</td>
			<td>${student.studentDetail.firstName}</td>
			<td>${student.studentDetail.lastName}</td>
			<td>${student.studentDetail.address}</td>
			<td>${student.studentDetail.emailId}</td>
		</tr>
	</table>

</body>
</html>