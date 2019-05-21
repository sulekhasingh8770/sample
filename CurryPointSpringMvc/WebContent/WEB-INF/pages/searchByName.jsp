<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="n" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:form action="searchby" method="get" modelAttribute="vend">
Enter Name: <c:input path="name" required="true"/>
<input type="submit" value="search"/>
<table border=1>
<tr>
<th> Vendor Name </th>
<th> Vendor Phone Number </th>
<th> Item Name </th>
<th> Item Price </th>
</tr>
<s:forEach var="t" items="${sName}">
<tr>
<td> ${t.name } </td>
<td> ${t.phoneNumber }</td>
</tr>

<n:forEach var="i" items="${t.items }">
<tr>
<td> ${i.name }</td>
<td> ${i.price }</td>
</tr>
</n:forEach>
</s:forEach>
</table>
</c:form>
</body>
</html>