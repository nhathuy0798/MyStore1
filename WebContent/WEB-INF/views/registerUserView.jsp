<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:extends name="baseView2.jsp">
    <layout:put block="title">Register</layout:put>
    
    <layout:put block="body">
    <script type="text/javascript" src="js/validateInput.js"></script>
    	<div id="login">
		    <div class="container">
		        <div id="login-row" class="row justify-content-center align-items-center">
		            <div id="login-column" class="col-md-6">
		                <div class="login-box col-md-6">
		                    <form id="login-form" class="form" method="post" action="${pageContext.request.contextPath}/register" >
		                        <h3 class="text-center text-info">Register</h3>
		                        <p style="color: red;">${errorString}</p>
		                        <div class="form-group">
		                            <label for="username" class="text-info">Username:</label><br>
		                            <input type="text" name="user_name" id="user_name" class="form-control" value= "${user.userName}">
		                        </div>
		                        <div class="form-group">
		                            <label for="gender" class="text-info">Gender:</label><br>
		                            <input type="text" name="gender" id="gender" class="form-control" value= "${user.gender}">
		                        </div>
		                        <div class="form-group">
		                            <label for="password" class="text-info">Password:</label><br>
		                            <input type="password" name="password" id="password" class="form-control" value= "${user.password}">
		                        </div>
		                        <div class="form-group">
		                            <label for="repassword" class="text-info">Confirm Password:</label><br>
		                            <input type="password" name="repassword" id="repassword" class="form-control">
		                        </div>
		                        <c:if test="${userLogined.role_admin}">
		                        	<label for="remember-me" class="text-info"><span>Create Admin Role:</span> <span><input id="role_admin" name="role_admin" type="checkbox" value= "Y"></span></label><br>
	                        	</c:if>
		                        <div class="form-group">		                      
		                            <input type="submit" name="submit" onclick=" return validateRegister()" class="btn btn-info btn-md" value="Register">
		                            <a href="${pageContext.request.contextPath}/" class="btn btn-danger" role="button">Cancel</a>	
		                        </div>		                        
		                    </form>
		                </div>
		            </div>
		        </div>
		    </div>
	  </div>
    </layout:put>
</layout:extends>