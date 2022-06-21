<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<h2>Cart Information:</h2>
	<table border="1">
		<tr>
			<td>Id Product</td>
			<td>Name</td>
			<td>Image</td>
			<td>Quantity</td>
			<td>Price</td>
			<td>Total Amount</td>
			<td>Action</td>
		</tr>
		<c:forEach items="${listItems}" var="item">
			<tr>
				<td>${item.product.id}</td>
				<td>${item.product.name}</td>
				<td><img src="data:image/jpg;base64,${item.product.base64Image} " class="img-thumbnail" id="image-list"
										width="200" height="150"/></td>
				<td>${item.quantity }</td>
				<td>${item.price }</td>
				<td>${item.quantity * item.price}</td>
				<td><a href="${pageContext.request.contextPath}/deleteOder?id=${item.product.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/payment">Pay</a>
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>