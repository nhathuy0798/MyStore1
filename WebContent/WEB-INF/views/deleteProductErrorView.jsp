<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:extends name="baseView2.jsp">
    <layout:put block="title">Delete Product</layout:put>
    
    <layout:put block="body">	   
	    <h3>Delete Product</h3>
	   
	    <p style="color: red;">${errorString}</p>
	    <a href="productList">Product List</a>
  </layout:put>
</layout:extends>