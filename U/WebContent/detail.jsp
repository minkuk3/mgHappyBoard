<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<table>
	<tr>
		<th>차량회사</th>
		<td>${vo.com_name }</td>
	</tr>

	<tr>
		<th>차량이름</th>
		<td>${vo.c_name }</td>
	</tr>

	<tr>
		<th>차 종</th>
		<td>${vo.c_type }</td>
	</tr>

	<tr>
		<th>출시일자</th>
		<td>${vo.c_regdate }</td>
	</tr>

	<tr>
		<th>차량가격</th>
		<td>${vo.c_price }</td>
	</tr>

	<tr>
		<th>배기량</th>
		<td>${vo.c_cc }</td>
	</tr>
</table>

<form action="detail" method="post">
	<input type="hidden" value="${vo.com_no}" name="com_no" /> 
	<input type="hidden" value="${vo.c_price}" name="c_price" />
<!-- 	<input type="hidden" value="0" name="type" />  -->
	<input type="submit" value="차량구매" />
	
</form>


<input type="button" value="정보수정" onclick="location.href='mod?c_no=${vo.c_no}'"/>