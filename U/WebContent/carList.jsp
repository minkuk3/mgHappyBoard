<%@page import="kr.co.hk.CarVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% List<CarVO> list = (List<CarVO>)request.getAttribute("carList"); %>


<div class="carTable_wrap">

	<% if(list != null && list.size() > 0) {%>
	<table>
		<tr>
			<th>등록번호</th>
			<th>차량이름</th>
			<th>출시일자</th>
			<th>차량가격</th>
		</tr>
		<%for(CarVO vo : list) {%>		
		<tr>
			<td><%=vo.getC_no() %></td>	
			<td><a href="detail?c_no=<%=vo.getC_no() %>" ><%=vo.getC_name() %></a></td>	
			<td><%=vo.getC_regdate() %></td>	
			<td><%=vo.getC_price() %></td>	
		</tr>
		
		<%} %>	
	</table>
	<% }else{ %>
		<p>등록된 차량이 없습니다 등록해주세요</p>
	<%} %>
	
	<div class="carList_btnBox">
		<input class="carBtn" type="button" value="차량등록" onclick="location.href='carWrite'" />
	</div>
	
</div>

