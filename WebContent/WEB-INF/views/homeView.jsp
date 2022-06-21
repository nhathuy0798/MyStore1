<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
     <title>Home Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	 <style><%@include file="/WEB-INF/static/css/styles.css"%></style> 
  </head>
  <body>

     <jsp:include page="_header.jsp"></jsp:include>

	<div class="container">
		<h3>BEST SALER (${productCount})</h3>
		<div id="products" class="row list-group">
			<c:forEach items="${productListBestSaler}" var="item">
				<div class="item  col-xs-3 col-lg-3">
					<div class="thumbnail" id="thumbnail-img">
						<img id="bestImage" src="data:image/jpg;base64,${item.base64Image} "/>
						<div class="caption">
							<p class="group inner list-group-item-text">
							Name: ${item.name}
							</p>
							<div class="row">
								<div class="col-xs-12 col-md-8">
									<p class="lead">${item.price} VND</p>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 col-md-3">
									<a class="btn btn-success" href="detailProduct?id=${item.id}">Detail</a>									
								</div>
								<c:if test="${!loginedUser.role_admin}">
									<div class="col-xs-12 col-md-3">
										<c:url value="/addtoCart?id=${item.id}&page=home" var="addtoCart" />
										<a class="btn btn-warning" href="${addtoCart}">Buy</a>
									</div>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>	
		</div>
	</div>
	<jsp:include page="_footer.jsp"></jsp:include>

  </body>
</html>