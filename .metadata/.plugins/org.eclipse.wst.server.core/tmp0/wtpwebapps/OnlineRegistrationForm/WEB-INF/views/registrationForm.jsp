<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
<div align="center">
	<table>
		<tr>
			<td><form:label path="Name">Name</form:label></td>
			<td><input type="text" name="name" /></td>
		</tr>
		<tr>&nbsp;</tr>
		<tr>
			<td><form:label path="Age">Age</form:label></td>
			<td><input type="text" name="age" /></td>
		</tr>
		<tr>
			<td><form:label path="HighestDegree">HighestDegree</form:label></td>
			<select name="degree">
				<c:forEach  var="degree"  items="${DegreeList}">
						<option value="${degree}" >${degree}</option>
					</c:forEach>
					</select>
		</tr>
	
	</table>
	</div>
</body>
</html>