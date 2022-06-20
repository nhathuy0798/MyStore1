<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Contract</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style><%@include file="/WEB-INF/static/css/styles.css"%></style> 
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<div class="container">
	<h1>Contact Us</h1>
	<form class="cf">
	  <div class="half left cf">
	    <input type="text" id="input-name" placeholder="Name">
	    <input type="email" id="input-email" placeholder="Email address">
	    <input type="text" id="input-subject" placeholder="Subject">
	  </div>
	  <div class="half right cf">
	    <textarea name="message" type="text" id="input-message" placeholder="Message"></textarea>
	  </div>  
	  <input type="submit" value="Submit" id="input-submit">
	</form>
</div>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>