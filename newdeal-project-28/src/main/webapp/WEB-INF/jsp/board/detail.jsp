<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>게시물 상세정보</title>
</head>
<style>
  table{
    all: unset;
  }
</style>
<body>
<jsp:include page="../header.jsp"></jsp:include>
	<h1>게시물 상세정보</h1>
	<form action="./update" method="post">
		<table border='1'>
			<tr>
				<th>번호</th>
				<td><input type="text" name="no" value="${board.no}" readonly="readonly"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="5" cols="50" style="resize:none" name="contents">${board.contents}</textarea>
			</tr>
			<tr>
				<th>작성일</th>
				<td><input type="text" value="${board.createdDate}" readonly="readonly"></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td><input type="text" value="${board.viewCount}" readonly="readonly"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text"  value="${board.writer.name}" readonly="readonly"></td>
			</tr>
			<tr>
				<th>수업</th>
				<td><input type="text" value="${board.lesson.title}" readonly="readonly"></td>
			</tr>
			<tr>
	      <td>
		      <button>변경</button>
		      <button type="button" onclick="remove()">삭제</button>
	      </td>
	    </tr>
		</table>
		<input type="hidden" name="writerNo" value="${board.writer.no}">
		<input type="hidden" name="lessonNo" value="${board.lesson.no}">
	</form>
</body>
<script>
  const remove = () => {
	  location.href = "delete?no=${board.no}";
}
</script>
</html>
