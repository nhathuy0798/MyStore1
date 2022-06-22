<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:extends name="baseView2.jsp">
    <layout:put block="title">Home</layout:put>
    <layout:put block="body">
    	<h3>Hello: ${user.userName}</h3>

	    User Name: <b>${user.userName}</b>
	    <br />
	    Gender: ${user.gender } <br />
    	
    </layout:put>
</layout:extends>