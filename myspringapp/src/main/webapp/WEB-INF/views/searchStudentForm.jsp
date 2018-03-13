<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/spring-mvc/searchStudent" method="POST">
<p>Select From List to search:</p>
  <select name="item">
    <option value="1">Search by First Name(Not working as of now)</option>
    <option value="2">Search by Last Name(Not working as of now)</option>
    <option value="3">Search by Email ID(Not working as of now)</option>
    <option value="4">Search by Student ID</option>
  </select><br/>
  Enter Detail:  <input name="search" type="text">
  <input type="submit" value="Submit">
</form>
	
	
</body>
</html>