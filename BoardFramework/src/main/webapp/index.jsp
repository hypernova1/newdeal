<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.bit.member.model.MemberDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
  MemberDto memberDto = new MemberDto();
  memberDto.setId("hypernova");
  memberDto.setEmail("chtlstjd01@naver.com");
  memberDto.setName("sam");
  
  session.setAttribute("userInfo", memberDto);

  response.sendRedirect(request.getContextPath() + "/badmin/boardmenu.bit");
%>