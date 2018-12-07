<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>게시물 등록</title>
</head>
<style>
  table{
    all: unset;
  }
</style>
<body>
  <jsp:include page="../header.jsp"></jsp:include>
	<h1>게시물 등록</h1>
	<form action="./add" method="post">
		<table>
			<tr>
				<th>내용</th>
				<td><textarea rows="5" cols="50" style="resize:none" name="contents"></textarea>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writerNo"
				      value="${loginUser.name}" readonly="readonly"></td>
			</tr>
			<tr>
				<th>수업</th>
				<td><select name="lessonNo">
				  <c:forEach items="${lessons}" var="map">
				    <option value="${map.lessonNo}">${map.title}</option>
				  </c:forEach>
				</select></td>
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
