<%@page import="kr.co.hk.BoardDAO"%>
<%@page import="kr.co.hk.CompanyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% List<CompanyVO> list = (List<CompanyVO>)request.getAttribute("list"); %>

<div class="compantWrite_Box">
	<p>원하는 차량회사가 없으면 회사 등록 먼저 해주세요.</p>
	<input class="carBtn" type="button" value="회사등록" onclick="location.href='companyWrite'" />
</div>


<form action="carWrite" method="post">

	<table>
		<tr>
			<th>등록번호</th>
			<td><input type="text" name="c_no" value="${c_no}"></td>
		</tr>

		<tr>
			<th>차량회사</th>
			<td>
				<select name="com_no">
					<% for(CompanyVO vo : list ){%>
						<option value="<%=vo.getCom_no() %>"><%=vo.getCom_name() %></option>
					<% }%>
				</select>
			</td>
		</tr>

		<tr>
			<th>차량이름</th>
			<td><input type="text" name="c_name"></td>
		</tr>

		<tr>
			<th>차종</th>
			<td><select name="c_type">
					<option value="승용차">승용차</option>
					<option value="SUV">SUV</option>
			</select></td>
		</tr>

		<tr>
			<th>출시일자</th>
			<td><input type="date" name="c_regdate"></td>
		</tr>

		<tr>
			<th>차량가격</th>
			<td><input type="text" name="c_price"></td>
		</tr>

		<tr>
			<th>배 기 량</th>
			<td><input type="text" name="c_cc"></td>
		</tr>
	</table>

	<input type="submit" value="차량등록" />

</form>