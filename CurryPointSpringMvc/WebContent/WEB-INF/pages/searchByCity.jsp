<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="r" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search City</title>
</head>
<body>
<r:form action="search" method="get" modelAttribute="vend">
Enter City: <r:input path="city" required="true"/>
<input type="submit" value="search"/>
<table border=1>
<tr>
<th> Vendor Name </th>
<th> Landmark </th>
<th>  Area </th>
<th> City </th>
<th> State </th>
</tr>
<d:forEach var="v" items="${sCity }">
<tr>
<td> ${v.name } </td>
<td> ${v.phoneNumber }</td>
<a:forEach var="c" items="${v.address }">

<td> ${v.landmark }</td>
<td> ${v.area }</td>
<td> ${v.city }</td>
<td> ${v.state }</td>
</a:forEach>
</tr>
</d:forEach>
</table>
</r:form>
</body>
</html>