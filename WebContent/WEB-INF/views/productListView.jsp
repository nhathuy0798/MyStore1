<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item List</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(document).ready(function() {
	
    $('img').click(function() {
        console.log($(this).attr("id-row"));
        var url = "detailProduct?id=" + $(this).attr("id-row");
        window.location.assign(url);
    });
});

</script>

</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>
	<p style="color: red;">${errorString}</p>

	<div class="container-fluid">
	 <div id="list-row" class="row justify-content-center align-items-center">
		 <div id="list-column" class="col-sm-9">
		 	<h3>Product List (${productCount}) </h3>
				<c:if test="${userLogined.role_admin}">
				<a href="createProduct">
					<img src="img/add-icon.png" width="30" height="30" id="add-icon"/>
				</a><a href="createProduct" id="create-link">Create Product</a>
				</c:if>
				<div class="table-wrapper-scroll-y my-custom-scrollbar">
					<table class="table table-striped">
						<thead>
							<tr id="table-product-list-tr-title" >
								<th>Id</th>
								<th>Image</th>
								<th>Best Saler</th>
								<th>Type</th>
								<th>Name</th>
								<th>Price</th>
								<c:if test="${userLogined.role_admin}">
									<th>Edit</th>
									<th>Delete</th>
								</c:if>
								<c:if test="${!userLogined.role_admin}">
									<th>Buy</th>
								</c:if>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${productList}" var="item">
								<tr id="table-product-list-tr" >
									<td id="id-product">${item.id}</td>
									<td><img src="data:image/jpg;base64,${item.base64Image} " class="img-thumbnail" id="image-list"
										width="200" height="150" id-row="${item.id}"/></td>
									<td><input name="bestSalerProduct" id="bestSalerProduct" type="checkbox" value= "Y" disabled="true" <c:if test="${item.bestSaler}">checked=checked</c:if>></td>	
									<td>${item.type}</td>	
									<td>${item.name}</td>
									<td>${item.price}-VND</td>
									<c:if test="${userLogined.role_admin}">
										<td><a href="editProduct?id=${item.id}"
											class="btn btn-info" role="button"><span class="glyphicon glyphicon-edit"></span></a></td>
										<td><a href="deleteProduct?id=${item.id}"
											class="btn btn-danger" role="button" onclick="return confirm('Are you sure you want to delete this item?');" ><span class="glyphicon glyphicon-remove"></span></a></td>
									</c:if>
									<c:if test="${!userLogined.role_admin}">
										<td>
											<c:url value="/addtoCart?id=${item.id}&page=productList" var="addtoCart" />
											<a class="btn btn-warning" href="${addtoCart}">Buy</a>
										</td>
									</c:if>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div id="filter-column" class="col-sm-3">
				<h3>Filter Product</h3>
				<form class="form-group" method="post" action="${pageContext.request.contextPath}/productList">
					<label for="name">Name:</label> <input type="text" class="form-control" id="name" name="name" value="${condition.name}">
					<label for="sel1">Type:</label> 
					<select class="form-control" id="sel1" name="type">
						<option value="0" ${param.type == '0' ? 'selected' : ''}>All Type</option>
						<option value="1" ${param.type == '1' ? 'selected' : ''}>1</option>
						<option value="2" ${param.type == '2' ? 'selected' : ''}>2</option>
					</select>
					<label for="priceMin">Min:</label> 
					<select class="form-control" id="priceMin" name="priceMin">
					    <option value="0" ${param.type == '0' ? 'selected' : ''} >0</option>
						<option value="1000000" ${param.priceMin == '1000000' ? 'selected' : ''}>1.000.000</option>
						<option value="2000000" ${param.priceMin == '2000000' ? 'selected' : ''}>2.000.000</option>
						<option value="3000000" ${param.priceMin == '3000000' ? 'selected' : ''}>3.000.000</option>
						<option value="4000000" ${param.priceMin == '4000000' ? 'selected' : ''}>4.000.000</option>
						<option value="5000000" ${param.priceMin == '5000000' ? 'selected' : ''}>5.000.000</option>
						<option value="6000000" ${param.priceMin == '6000000' ? 'selected' : ''}>6.000.000</option>
						<option value="7000000" ${param.priceMin == '7000000' ? 'selected' : ''}>7.000.000</option>
						<option value="8000000" ${param.priceMin == '8000000' ? 'selected' : ''}>8.000.000</option>
						<option value="9000000" ${param.priceMin == '9000000' ? 'selected' : ''}>9.000.000</option>
						<option value="10000000" ${param.priceMin == '10000000' ? 'selected' : ''}>10.000.000</option>
					</select>
					<label for="priceMax">Max:</label> 
					<select class="form-control" id="priceMax" name="priceMax">
					    <option value="0" ${param.type == '0' ? 'selected' : ''} >0</option>
						<option value="1000000" ${param.priceMax == '1000000' ? 'selected' : ''}>1.000.000</option>
						<option value="2000000" ${param.priceMax == '2000000' ? 'selected' : ''}>2.000.000</option>
						<option value="3000000" ${param.priceMax == '3000000' ? 'selected' : ''}>3.000.000</option>
						<option value="4000000" ${param.priceMax == '4000000' ? 'selected' : ''}>4.000.000</option>
						<option value="5000000" ${param.priceMax == '5000000' ? 'selected' : ''}>5.000.000</option>
						<option value="6000000" ${param.priceMax == '6000000' ? 'selected' : ''}>6.000.000</option>
						<option value="7000000" ${param.priceMax == '7000000' ? 'selected' : ''}>7.000.000</option>
						<option value="8000000" ${param.priceMax == '8000000' ? 'selected' : ''}>8.000.000</option>
						<option value="9000000" ${param.priceMax == '9000000' ? 'selected' : ''}>9.000.000</option>
						<option value="10000000"${param.priceMax == '10000000' ? 'selected' : ''}>10.000.000</option>
					</select>
					<br>
					<label for="bestSaler" class="text-info"><span>Best Saler</span> <span><input name="bestSaler" id="bestSaler" type="checkbox" value= "Y"  <c:if test="${condition.bestSaler}">checked=checked</c:if>></span></label><br>
					<br>
					<input id="btn-search" type="submit" name="submit" class="btn btn-primary btn-lg" value="Search">
				</form>			
			</div>
		</div>
	</div>	
	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>