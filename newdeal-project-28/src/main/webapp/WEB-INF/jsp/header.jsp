<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
  div>a[href]{
    border: 1px solid black;
    border-radius: 3px;
    padding: 3px;
  }
</style>

<div>
  <c:choose>
	  <c:when test="${not empty sessionScope.loginUser.name}">
		  <span>${sessionScope.loginUser.name}</span>
		  <a href="/auth/logout">로그아웃</a>
	  </c:when>
	<c:otherwise>
	  <a href="/auth/login">로그인</a>
  </c:otherwise>
</c:choose>
</div>