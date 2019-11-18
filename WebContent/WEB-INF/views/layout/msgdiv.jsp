<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty msg}">
	<div class="msg-div">
		<h2>${msg}</h2>
	</div>
	<c:remove var="msg"/>
</c:if>
