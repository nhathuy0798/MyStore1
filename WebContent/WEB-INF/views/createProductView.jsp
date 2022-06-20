<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Create Product</title>
   </head>
   <body>
   
      <jsp:include page="_header.jsp"></jsp:include>
      
      <h3>Create Product</h3>
      
      <p style="color: red;">${errorString}</p>
      
      <form id="create-product-form" method="POST" action="${pageContext.request.contextPath}/createProduct" enctype='multipart/form-data'>
         <table border="0">
            <tr>
               <td>Id</td>
               <td><input type="text" class="form-control form-control" name="id" value="${product.id}" /></td>
            </tr>
            <tr>
               <td>Name</td>
               <td><input type="text" class="form-control form-control" name="name" value="${product.name}" /></td>
            </tr>
            <tr>
               <td>Type</td>
               <td>
               <select class="form-control" id="sel1" name="type" value="${product.type}">
						<option selected>1</option>
						<option>2</option>
			   </select>
			   </td>
            </tr>
            <tr>
               <td>Price</td>
               <td><input type="number" class="form-control form-control" name="price" pattern="([0-9]{1,3}).([0-9]{1,3})" value="${product.price}" /></td>
            </tr>
            <tr>
               <td>Image</td>
               <td><input type="file" class="form-control-file" name="imageData" value="${product.imageData}" /></td>
            </tr>
            <tr>
               <td>File Name</td>
               <td><input type="text" class="form-control form-control" name="imageFileName" value="${product.imageFileName}" /></td>
            </tr>     
         </table>
         <br>
         <label for="bestSaler" class="text-info"><span>Best Saler</span> <span><input name="bestSaler" type="checkbox" value= "Y"></span></label><br>
         <br>
         <div class="form-group">		                      
             <input type="submit" name="submit" class="btn btn-info btn-md" value="Create">
             <a href="productList" class="btn btn-danger" role="button">Cancel</a>	
         </div>	
      </form>
      
      <jsp:include page="_footer.jsp"></jsp:include>
      
   </body>
</html>