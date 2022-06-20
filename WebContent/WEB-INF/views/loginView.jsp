<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Login</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <%-- <script><%@include file="/WEB-INF/static/js/validateInput.js"%></script>  --%>
    <script type="text/javascript" src="js/validateInput.js"></script>

   </head>
   <body>
      <jsp:include page="_header.jsp"></jsp:include>

		<div id="login-form-1">
		    <div class="container">
		        <div id="login-row" class="row justify-content-center align-items-center">
		            <div id="login-column" class="col-sm-6">
		                <div class="login-box col-md-6">
		                    <form id="login-form" name="login-form" class="form" method="post" action="${pageContext.request.contextPath}/login" >
		                        <h3 class="text-center text-info">Login</h3>
		                        <div class="form-group" name="form-group">
		                            <label for="username" class="text-info">Username:</label><br>
		                            <input type="text" name="userName" id="userName" name="userName" class="form-control" value= "${user.userName}">
		                        </div>
		                        <div class="form-group">
		                            <label for="password" class="text-info">Password:</label><br>
		                            <input type="password" name="password" id="password" class="form-control" value= "${user.password}">
		                        </div>
		                        <div class="form-group">
		                            <label for="remember-me" class="text-info"><span>Remember me</span> <span><input id="remember-me" name="remember-me" type="checkbox" value= "Y"></span></label><br>
		                            <input type="submit" name="submit" onclick="validateLogin()" class="btn btn-info btn-md" value="Login">
		                            <a href="${pageContext.request.contextPath}/" class="btn btn-danger" role="button">Cancel</a>	
		                        </div>
		                        <div id="register-link" class="text-right">
		                            <a href="${pageContext.request.contextPath}/register" class="text-info">Register here</a>
		                            <p style="color: red;">${errorString}</p>
		                        </div>
		                    </form>
		                </div>
		            </div>
		            <div id="login-image" class="col-sm-6">
		            
		            </div>
		        </div>
		    </div>
	  </div>	
      <jsp:include page="_footer.jsp"></jsp:include>
   </body>
</html>