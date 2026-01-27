<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Cars</title>
</head>
<body>
	<table border=1>
	<thead>
		<tr>
			<th>Car Id</th>
			<th>Manufacturer</th>
			<th>Model</th>
			<th colspan=2>Action</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${cars}" var="car" >
			<tr>
				<td><c:out value="${car.carId}"/></td>
				<td><c:out value="${car.manufacturer}"/></td>
				<td><c:out value="${car.model}"/></td>
				<td><a href="CarController?action=edit&carId=<c:out value="${car.carId}"/>">Update</a></td>
				<td><a href="CarController?action=delete&carId=<c:out value="${car.carId}"/>">Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<p><a href="CarController?action=insert"> Add a new Car and Model</a>
</body>
</html>