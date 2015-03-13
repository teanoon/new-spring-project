<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  Hi, everyone!
</h1>
	<P>The time on the server is ${serverTime}. </P>
	<p>The locale is ${locale}</p>
	<p>I'm ${person.name}</p>
</body>
</html>
