<%@page import="kr.co.happy.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%
	ArrayList<BoardVO> list = (ArrayList<BoardVO>) request.getAttribute("list");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>날짜</th>
	</tr>
	<%
		for (int i = 0; i < list.size(); i++) {
	%>
	<tr>
		<td><%=list.get(i).getSeq()%></td>
		<td><a href="boarddetail?btype=<%=list.get(i).getBtype()%>&seq=<%=list.get(i).getSeq()%>"><%=list.get(i).getBtitle()%></a></td>
		<td><%=list.get(i).getBregdate()%></td>
	</tr>
	<%
		}
	%>


</table>
<a href="write?btype=${param.btype }">
	<input type="button" value="글쓰기">
</a>
