<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Yahoo!!</title>
</head>
<body>
	Welcome ${name}
	<br /> Displaying all students...
	<% System.out.println( "Current date now" ); 
java.util.Date date = new java.util.Date(); 
System.out.println("Printing all students");

%> 
	<table>
    <tr>
        <th>Student ID:</th>
        <th>First Name:</th>
        <th>Last Name:</th>
        <th>Address:</th>
        <th>Email:</th>
    </tr>
    
	<c:forEach var="student" items="${studentList}">
   <tr>
		<td>${student.studentId}</td>
		<td>${student.studentDetail.firstName}</td>
    	<td>${student.studentDetail.lastName}</td>
		<td>${student.studentDetail.address}</td>
		<td>${student.studentDetail.emailId}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>