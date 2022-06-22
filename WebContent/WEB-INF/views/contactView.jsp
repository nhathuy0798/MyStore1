<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:extends name="baseView2.jsp">
    <layout:put block="title">Contact</layout:put>
    <layout:put block="body">
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
	</layout:put>
</layout:extends>