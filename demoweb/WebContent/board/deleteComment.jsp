<%@page import="net.sf.json.JSONArray"%>
<%@page import="com.demoweb.model.dto.BoardComment"%>
<%@page import="java.util.List"%>
<%@page import="com.demoweb.model.dao.CommentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int commentno = Integer.parseInt(request.getParameter("commentno"));
int boardno = Integer.parseInt(request.getParameter("boardno"));
CommentDao dao = new CommentDao();
dao.deleteComment(commentno);

List<BoardComment> list = dao.getCommentList(boardno);
JSONArray jsonarray = JSONArray.fromObject(list);
%>
<%=jsonarray%>