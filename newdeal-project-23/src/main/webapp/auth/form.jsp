<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>로그인</title>
</head>
<style>
  table{
    all: unset;
  }
</style>
<body>
	<h1>로그인</h1>
	<form action="login" method="post">
		<table>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email">
			</tr>
			<tr>
				<th>암호</th>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
	      <td>
		      <button>등록</button>
		      <button type="button" onclick="location.href='list'">취소</button>
	      </td>
	    </tr>
		</table>
	</form>
</body>
</html>
