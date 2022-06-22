<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:extends name="baseView2.jsp">
    <layout:put block="title">Admin</layout:put>

    <layout:put block="body">
		<script>
			$(document).ready(function() {
			
			    $('#user-manager .panel').click(function() {
			        var url = "${pageContext.request.contextPath}/usermanager";
			        window.location.assign(url);
			    });
			    
			    $('#product-manager .panel').click(function() {
		        var url = "${pageContext.request.contextPath}/productList";
			        window.location.assign(url);
			    });
			    
			    $('#order-manager .panel').click(function() {
			        var url = "${pageContext.request.contextPath}/ordermanager";
			        window.location.assign(url);
			    });
			});
		
		</script>
		</br>
		</br>
		</br>
		<div class="container" id="managerment-id">    
		  <div class="row" id="managerment-row-id">
		    <div class="col-sm-4" id="user-manager">
		      <div class="panel panel-primary">
		        <div class="panel-heading" id="panel-user-manager">USER MANAGERMENT</div>
		        <div class="panel-body"><img src="img/user-icon1.png" class="img-responsive" alt="Image"></div>
		        <div class="panel-footer">Add, edit, delete User...</div>
		      </div>
		    </div>
		    <div class="col-sm-4" id="product-manager">
		      <div class="panel panel-danger" id="panel-product-manager">
		        <div class="panel-heading">PRODUCT MANAGERMENT</div>
		        <div class="panel-body"><img src="img/product-icon1.png" class="img-responsive" alt="Image"></div>
		        <div class="panel-footer">Add, edit, delete Product...</div>
		      </div>
		    </div>
		    <div class="col-sm-4" id="order-manager">
		      <div class="panel panel-success" id="panel-order-manager">
		        <div class="panel-heading">ORDER MANAGERMENT</div>
		        <div class="panel-body"><img src="img/order-icon1.png" class="img-responsive" alt="Image"></div>
		        <div class="panel-footer">Add, edit, delete Order...</div>
		      </div>
		    </div>
		  </div>
		</div><br><br><br>
		
		
		<div class="container">    
		  <div class="row">
		    <div class="col-sm-4">
		      <div class="panel panel-primary">
		        <div class="panel-heading">FUTURE PROCESS</div>
		        <div class="panel-body"></div>
		        <div class="panel-footer">...</div>
		      </div>
		    </div>
		    <div class="col-sm-4"> 
		      <div class="panel panel-primary">
		        <div class="panel-heading">FUTURE PROCESS</div>
		        <div class="panel-body"></div>
		        <div class="panel-footer">...</div>
		      </div>
		    </div>
		    <div class="col-sm-4"> 
		      <div class="panel panel-primary">
		        <div class="panel-heading">FUTURE PROCESS</div>
		        <div class="panel-body"></div>
		        <div class="panel-footer">...</div>
		      </div>
		    </div>
		  </div>
		</div>
	</layout:put>

</layout:extends>