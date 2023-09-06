<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="product/add">dcdkjb</a>
	<table>
		<thead>
			<tr>
				<th>Product Name</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.name}</td>
					<td>${product.price}</td>
					<td><a href="view?id=${product.getCode()}">edit</a></td>
					<td><a href="view?id=${product.getCode()}">delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>