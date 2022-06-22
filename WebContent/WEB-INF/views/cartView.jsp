<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:extends name="baseView2.jsp">
    <layout:put block="title">Cart</layout:put>
    <layout:put block="body">

		<h2>Cart Information:</h2>
		<table class="table table-striped">
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
	</layout:put>
</layout:extends>