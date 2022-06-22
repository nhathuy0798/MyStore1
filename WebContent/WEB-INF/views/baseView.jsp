<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title><layout:block name="title"></layout:block></title>
</head>
<div class="header">
        <layout:block name="header">
      		<jsp:include page="_header.jsp"></jsp:include>
        </layout:block>
    </div>
    <div class="body">
        <layout:block name="body">
           
        </layout:block>
    </div>
    <div class="footer">      
        <layout:block name="footer">
            <jsp:include page="_footer.jsp"></jsp:include>
        </layout:block>
    </div>
</html>