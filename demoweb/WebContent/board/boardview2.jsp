<%@page import="com.demoweb.model.dao.BoardDao"%>
<%@page import="com.demoweb.model.dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
//목록 페이지에서 선택한 글의 번호를 읽어서 변수에 저장
Integer boardNo = null;
try {
	boardNo = Integer.valueOf(request.getParameter("boardno"));
} catch (Exception ex) {}
//글번호가 없다면
if (boardNo == null) {
	//목록으로 이동
	response.sendRedirect("boardlist.jsp");
	return;
}
BoardDao dao = new BoardDao();
Board board = dao.getBoardByBoardNo(boardNo);

if (board == null) {//조회된 글이 없다면
	//목록으로 이동
	response.sendRedirect("boardlist.jsp");
	return;
}

dao.increaseReadCount(boardNo);

String pageNo = "1";
if (request.getParameter("pageno") != null) {
	pageNo = request.getParameter("pageno");
}
Member login = (Member)session.getAttribute("loginuser");
String id = null;
if (login != null)
  id = login.getMemberId();
%>


<!DOCTYPE html>

<%@page import="com.demoweb.model.dto.Member"%>
<html>
<head>
	<meta charset="UTF-8" />
	<title>글쓰기</title>
	<link rel="Stylesheet" href="/demoweb/styles/default.css" />
	<link rel="Stylesheet" href="/demoweb/styles/input2.css" />
	<script src="https://code.jquery.com/jquery-1.12.4.js" ></script>
	<script type="text/javascript">
	
	$(function() {
		commentList();
		
		$(document).on("click","#addComment", function() {
			var data = $("#content").val();
			var content = {
					"boardNo" : <%= boardNo %>,
					"writer" : '<%= id%>',
					"content" : data
			}
			$.post("commentAdd", content).done(function() {
				commentList();
				$("#content").val("");
			});
			
			
		});
		
		$(document).on("click", ".updateFormComment", function() {
			var datasrc = $(this).attr("data-src");
		  $("#content").val($(this).parents("td").prev().text());
		     $("#buttonArea").html("<button style='float: right;' id='updateComment' data-src='"+ datasrc +"'>댓글변경</button>")
		    });
		
		$(document).on("click", "#updateComment", function() {
			var data = {
			           "no" : $(this).attr("data-src"),
			           "content" : $("#content").val()
			       }
		  $.post("commentUpdate", data).done(function() {
			  commentList();
			  $("#buttonArea").html("<button style='float: right;' id='addComment'>댓글등록</button>");
			  $("#content").val("");
		  });
			
	  });
	      
    $(document).on("click", ".deleteComment", function() {
       var data = {
    		   "no" : $(this).attr("data-src")
       }
       $.post("commentDelete", data).done(function() {
    	   commentList();
    	   $("#buttonArea").html("<button style='float: right;' id='addComment'>댓글등록</button>");
       });
       
    });
		
	});
	
	
	function deleteBoard(number, pageno) {
		//confirm : 예/아니오 버튼의 선택에 따라 true/false 반환
		if (confirm(number + "번 글을 삭제할까요?")) {
			//location.href=path -> 지정된 경로로 이동
			location.href='boarddelete.jsp?boardno=' 
				+ number + "&pageno=" + pageno;
		}
	}
	
	function commentList() {
		$.getJSON("commentList?boardno=" + <%= boardNo %>, function(result) {
      var html = "";
      $.each(result, function(index, data){
        html += '<tr>';
        html += '<th>번호</th>';
        html += '<td>' + data.commentNo + '</td>';
        html += '<th>작성자</th>';
        html += '<td>' + data.writer + '</td>';
        html += '<th>등록일</th>';
        html += '<td>' + data.regDate + '</td>';
        html += '</tr>';
        html += '<tr>';
        html += '<th>내용</th>';
        html += '<td colspan="4">' + data.content + '</td>';
        if (data.writer == '<%=id %>') {
        	 html += '<td><button class="updateFormComment" data-src="'+ data.commentNo +'">변경</button><button class="deleteComment" data-src="'+ data.commentNo +'">삭제</button></td>';
        } else {
        	html += '<td></td>';
        }
         
        html += '</tr>';
      });
      
      $('#commentList').html(html);
    });
	}
	</script>
</head>
<body>

	<div id="pageContainer">
	
		<% pageContext.include("/include/header.jsp"); %>
		
		<div style="padding-top:25px;text-align:center">
		<div id="inputcontent">
		    <div id="inputmain">
		        <div class="inputsubtitle">게시판 글 쓰기</div>
		        <table>
		            <tr>
		                <th>제목</th>
		                <td><%= board.getTitle() %></td>
		            </tr>
		            <tr>
		                <th>작성자</th>
		                <td><%= board.getWriter() %></td>
		            </tr>
		            <tr>
		                <th>작성일</th>
		                <td><%= board.getRegDate() %></td>
		            </tr>
					<tr>
		                <th>조회수</th>
		                <td><%= board.getReadCount() + 1 %></td>
		            </tr>
		            <tr>
		                <th>내용</th>
		                <td style="height:200px;vertical-align:top">		                    
		                    <%= board.getContent().replaceAll(
		                    	"\r\n", "<br />") %>
		                </td>
		            </tr>
		            <tr>
		              <th>댓글입력</th>
		              <td>
		                <textarea id = "content" style="width:580px" rows="3"></textarea>
                    <div id="buttonArea"><button style="float: right;" id="addComment">댓글등록</button></div>
                  </td>
		            </tr>
		        </table>
		        

		        <table id="commentList">
		          
		        </table>
		        
		        <div class="buttons">
		        	<% if (session.getAttribute("loginuser") != null) { %>
			        	<% Member member = 
			        		(Member)session.getAttribute("loginuser"); %>
			        	<% if (member.getMemberId().equals(board.getWriter())) { %>
			        	<a href="boardeditform.jsp?boardno=<%= board.getBoardNo() %>&pageno=<%= pageNo %>">편집</a>
			        	<a href="javascript:deleteBoard(<%= board.getBoardNo() %>,<%= pageNo %>);">삭제</a>
			        	<% } %>
			        	<a href="boardreplyform.jsp?boardno=<%= board.getBoardNo() %>&pageno=<%= pageNo %>">댓글쓰기</a>
		        	<% } %>
		        	<a href="boardlist.jsp?pageno=<%= pageNo %>">목록보기</a>
		        </div>
		    </div>
		</div>   	
	
	</div>
	</div>

</body>
</html>