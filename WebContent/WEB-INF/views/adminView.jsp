<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<br>
<br>
<br>
	<div class="container" id="managerment-id">    
	  <div class="row" id="managerment-row-id">
	    <div class="col-sm-4" id="user-manager">
	      <div class="panel panel-primary">
	        <div class="panel-heading">USER MANAGERMENT</div>
	        <div class="panel-body"><img src="img/user-icon.png" class="img-responsive" alt="Image"></div>
	        <div class="panel-footer">Add, edit, delete User...</div>
	      </div>
	    </div>
	    <div class="col-sm-4" id="product-manager">
	      <div class="panel panel-danger">
	        <div class="panel-heading">PRODUCT MANAGERMENT</div>
	        <div class="panel-body"><img src="img/product-icon.png" class="img-responsive" alt="Image"></div>
	        <div class="panel-footer">Add, edit, delete Product...</div>
	      </div>
	    </div>
	    <div class="col-sm-4" id="order-manager">
	      <div class="panel panel-success">
	        <div class="panel-heading">ORDER MANAGERMENT</div>
	        <div class="panel-body"><img src="img/order-icon.png" class="img-responsive" alt="Image"></div>
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
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>