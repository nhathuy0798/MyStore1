<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:extends name="baseView2.jsp">
    <layout:put block="title">Home</layout:put>
    <layout:put block="body">
		<div class="container">
			<h3>BEST SALER (${productCount})</h3>
			<div id="products" class="row list-group">
				<c:forEach items="${productListBestSaler}" var="item">
					<div class="item  col-xs-3 col-lg-3">
						<div class="thumbnail" id="thumbnail-img">
							<img id="bestImage"
								src="data:image/jpg;base64,${item.base64Image} " />
							<div class="caption">
								<p class="group inner list-group-item-text">Name:
									${item.name}</p>
								<div class="row">
									<div class="col-xs-12 col-md-8">
										<p class="lead">${item.price}VND</p>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12 col-md-3">
										<a class="btn btn-success" href="detailProduct?id=${item.id}">Detail</a>
									</div>
									<c:if test="${!loginedUser.role_admin}">
										<div class="col-xs-12 col-md-3">
											<c:url value="/addtoCart?id=${item.id}&page=home"
												var="addtoCart" />
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
	</layout:put>
</layout:extends>