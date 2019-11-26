<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<title>Insert title here</title>
</head>
<body>

	<form action="addItem">
		<input type="text" name="itemNumber"><br>
		<input type="text" name="itemName"><br>
		<input type="text" name="itemAmount"><br>
		<input type="text" name="itemInventoryCode"><br>
		<input type="submit"><br>
	</form>
	
	<form action="getItem">
		<input type="text" name="itemNumber"><br>
		<input type="submit"><br>
	</form>

</body>
</html>