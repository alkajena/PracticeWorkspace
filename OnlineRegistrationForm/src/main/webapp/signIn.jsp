<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Sign In For Registration</title>
</head>
<body>
<div align="center"></div>
	<form action="LogIn">
		<table>
			<tr>
				<td><form:label path ="UserName">UserName</form:label></td>
				<td><input type="text" name="UserName"/></td>
			</tr>
			<tr>
				<td><form:label path ="Password">Password</form:label></td>
				<td><input type="text" name="Password"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Submit"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>