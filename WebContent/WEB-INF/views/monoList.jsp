<div class="container">
	<c:if test="${userLogined.role_admin}">
		<a href="createProduct">Create Product</a>
	</c:if>
	<div class="table-wrapper-scroll-y my-custom-scrollbar">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Image</th>
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
					<tr>
						<td>${item.id}</td>
						<td><img src="data:image/jpg;base64,${item.base64Image}"
							width="200" height="150" /></td>
						<td>${item.name}</td>
						<td>${item.price}VND</td>
						<c:if test="${userLogined.role_admin}">
							<td><a href="editProduct?id=${item.id}"
								class="btn btn-info" role="button"><span class="glyphicon glyphicon-edit"></span></a></td>
							<td><a href="deleteProduct?id=${item.id}"
								class="btn btn-danger" role="button"><span class="glyphicon glyphicon-remove"></span></a></td>
						</c:if>
						<c:if test="${!userLogined.role_admin}">
							<td><a href="buyProduct?id=${item.id}"
								class="btn btn-warning" role="button">Buy</a></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>