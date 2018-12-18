<%@page import="com.demoweb.model.dto.Member"%>
<%@page import="java.util.List"%>
<%@page import="net.sf.json.JSONArray"%>
<%@page import="com.demoweb.model.dto.BoardComment"%>
<%@page import="com.demoweb.model.dao.CommentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
int boardno = Integer.parseInt(request.getParameter("boardno"));
String content = request.getParameter("content");
Member member = (Member) request.getSession().getAttribute("loginuser");
String writer = member.getMemberId();

BoardComment bc = new BoardComment();
bc.setBoardNo(boardno);
bc.setContent(content);
bc.setWriter(writer);


CommentDao dao = new CommentDao();
dao.insert(bc);

List<BoardComment> list = dao.getCommentList(boardno);
JSONArray jsonarray = JSONArray.fromObject(list);
%>
<%=jsonarray%>