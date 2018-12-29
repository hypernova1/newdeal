<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/public.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Page Title</title>
<style>

#commonForm {
float: right;
}

.menu_list { width: 200px; }
.menu_category {
position: relative;
padding: 5px 10px;
cursor: pointer;
font-weight: bold;
background: darkgray;
color: lightgray;
}
.menu_body {
display: none;
text-align: left;
}
.menu_body a {
display:block;
display: black;
color: black;
background: lightgray;
padding: 10px;
text-decoration: none;
}
.menu_body a:hover {
color: steelblue;
text-decoration: underline;
}
</style>
</head>
<body>
	<div id="boardmenu" class="menu_list">
		<c:set var="idx" value="0" />
		<c:forEach varStatus="i" items="${menu}" var="board">
			<c:if test="${board.ccode != idx}">
				<div class="menu_category">${board.cname}</div>
				<c:set var="idx" value="${board.ccode}" />
			<div class="menu_body">
			</c:if>
			<a href="${root}/${board.control}/list.bit?bcode=${board.bcode}&page=1&key=&word=">
			   ${board.bname}</a>
	  	<c:if test="${i.index < menu.size() - 1}">
		  	<c:if test="${idx != menu.get(i.index + 1).ccode}">
			    </div>
		  	</c:if>
	  	</c:if>
	</c:forEach>
	</div>
	<script defer="defer">
  $('#boardmenu .menu_category').click(function(){
    $(this).next('div.menu_body').slideDown(500).siblings("div.menu_body").slideUp('slow');
  });
</script>
</body>
</html>