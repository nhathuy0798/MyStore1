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
	<div class="container-fluid">
	  <div class="row" id="header-id">
	    <div class="col-sm-12">
		    <nav class="navbar navbar-inverse" id="navbar">
			    <ul class="nav navbar-nav">
			     <c:if test="${!loginedUser.role_admin}">
				      <li class="nav-item">
				        <a class="nav-link" href="${pageContext.request.contextPath}/">Home <span class="glyphicon glyphicon-home"></span></a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link" id="id_product_list" href="${pageContext.request.contextPath}/productList">Product List</a>
				      </li>
				      <%-- <li class="nav-item">
				        <a class="nav-link" id="id_account_info" href="${pageContext.request.contextPath}/userInfo">My Account Info</a>
				      </li> --%>
				      <li class="nav-item">
				        <a class="nav-link" id="id_contact" href="${pageContext.request.contextPath}/contact">Contact</a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link" id="id_register" href="${pageContext.request.contextPath}/register">Register</a>
				      </li>
			      </c:if>
			      
			       <c:if test="${loginedUser.role_admin}">
			       		<li class="nav-item">
				        <a class="nav-link" href="${pageContext.request.contextPath}/admin">Admin Home <span class="glyphicon glyphicon-home"></span></a>
				      </li>
			       </c:if>
			    </ul>
			    <div id="login-form">
				     Hello <b>${loginedUser.userName}</b>
				     <c:if test="${loginedUser.role_admin}">
				     		<b>(admin)</b>
				     </c:if>				     
				     <br>
				      <c:if test="${!loginedUser.role_admin}">
				     	<a href="${pageContext.request.contextPath}/cart" class="btn btn-warning" role="button" id="cart">
				     	<img src="img/cart-icon2.png" width="30" height="20" id="add-icon"/></a>
				      </c:if>
				     	<a href="${pageContext.request.contextPath}/login" class="btn btn-info" role="button" id="login-id">Login</a>
				     <c:if test="${loginedUser.userName != null}">
				     	<a href="${pageContext.request.contextPath}/logout" class="btn btn-danger" role="button" id="logout-id">Logout</a>	
				     </c:if>
			     </div>
			</nav>		    
	      </div>
	   </div>
  	  </div>
  <body>