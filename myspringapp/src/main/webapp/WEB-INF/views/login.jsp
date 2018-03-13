<html>
<head>
<title>Yahoo!!</title>
</head>
<body>
	<p>
		<font color="red">${errorMessage}</font>
	</p>
		<h1>Welcome</h1>
		
	<form action="/spring-mvc/login" method="POST">
		Name : <input name="name" type="text" placeholder="Username" /> <br/>
		Password : <input name="password" type="password" placeholder="Password" /> <br/>
		<input type="submit" />
	
	</form>	
</body>
</html>