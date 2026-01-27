<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><h2> Add new car</h2>
<link type="text/css"
href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
</head>
<body>
<form method= "POST" action="CarController" name="frmAddCar">
    Car Id: <input type="text" readonly="readonly" name="carId" value="<c:out value="${car.carId}"/>"></input>
    <br>
    Manufacturer:<input type="text" name="manufacturer" value="<c:out value="${car.manufacturer}"/>"></input>
    <br>
    Model:<input type="text" name="model" value="<c:out value="${car.model}"/>"></input>
    <br>
    <input type="submit" value="Add"/>
</form>
</body>
</html>