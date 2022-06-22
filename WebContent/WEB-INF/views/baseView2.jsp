<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:extends name="baseView.jsp">
	<layout:put block="title" type="REPLACE">
            <layout:block name="title">
             </layout:block>
    </layout:put>
    <layout:put block="body" type="APPEND">
        <div>
            <layout:block name="body">
            
            </layout:block>
        </div>
    </layout:put>
</layout:extends>