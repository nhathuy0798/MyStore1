<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:extends name="baseView2.jsp">
    <layout:put block="title">Edit Product</layout:put>
    
    <layout:put block="body">
     <script type="text/javascript" src="js/validateInput.js"></script>
     <h3>Edit Product</h3>

      <p style="color: red;">${errorString}</p>

      <c:if test="${not empty product}">
      <div class="row">
	       <div class="col-sm-4">
	         <form id="edit-product-form" method="POST" action="${pageContext.request.contextPath}/editProduct" enctype='multipart/form-data'>
	            <table border="0">
	            <tr>
	               <td>Id</td>
	               <td><input type="text" class="form-control form-control" name="id" id="id" value="${product.id}" readonly /></td>
	            </tr>
	            <tr>
	               <td>Name</td>
	               <td><input type="text" class="form-control form-control" name="name" id="name" value="${product.name}" /></td>
	            </tr>
				<tr>
					<td>Type</td>
					<td><select class="form-control" id="sel1" name="type">
						<option value="1" ${product.type == '1' ? 'selected' : ''}>1</option>
						<option value="2" ${product.type == '2' ? 'selected' : ''}>2</option>
					</select></td>
				</tr>
				<tr>
	               <td>Price</td>
	               <td><input type="text" class="form-control form-control" name="price" id="price" value="${product.price}" /></td>
	            </tr>
	            <tr>
	               <td>Image</td>
	               <td><input type="file" class="form-control-file" name="imageData" id="imageData" value="${product.imageData}" /></td>
	            </tr>
	            <tr>
	               <td>File Name</td>
	               <td><input type="text" class="form-control form-control" name="imageFileName" id="imageFileName" value="${product.imageFileName}" /></td>
	            </tr>	            
	          </table>
	          <br>
	         <label for="bestSaler" class="text-info"><span>Best Saler</span> <span><input name="bestSaler" id="bestSaler" type="checkbox" <c:if test="${product.bestSaler}">checked=checked</c:if> value= "Y"></span></label><br>
	         <br>
	         <div class="form-group">		                      
	             <input type="submit" name="submit" class="btn btn-info btn-md" onclick="return validateEditProduct()" value="Update">
	             <a href="productList" class="btn btn-danger" role="button">Cancel</a>	
	         </div>	
	         </form>
	       </div>
	       <div class="col-sm-8">
	       		<img src="data:image/jpg;base64,${product.base64Image}" class="img-thumbnail"  id="image-edit"/>
	       </div>
       </div>
      </c:if>
    </layout:put>
</layout:extends>	