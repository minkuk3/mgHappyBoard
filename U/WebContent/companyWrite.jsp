<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form action="companyWrite" method="post">

	<table>
		<tr>
			<th>회사번호</th>
			<td><input type="text" name="com_no" value="${com_no}"></td>
		</tr>
		
		<tr>
			<th>회사이름</th>
			<td>
				<input type="text" name="com_name">
			</td>
		</tr>
		
		<tr>
			<th>회사주소</th>
			<td>
				<input type="text" name="com_addr">
			</td>
		</tr>
		
	</table>
	<input type="submit" value="회사등록">

</form>