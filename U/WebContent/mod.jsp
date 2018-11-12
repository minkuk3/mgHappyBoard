<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      
    <form action="mod" method="post">
    	<table>
    	
    	<tr>
    		<th>차량이름</th>
    		<td><input type="text" name="c_name" value="${vo.c_name}" /></td>
    	</tr>
    	<tr>
    		<th>차 종</th>
    		<td><input type="text" name="c_type" value="${vo.c_type}"/></td>
    	</tr>
    	<tr>
    		<th>출시일자</th>
    		<td><input type="text" name="c_regdate" value="${vo.c_regdate }"/></td>
    	</tr>
    	<tr>
    		<th>차량가격</th>
    		<td><input type="text" name="c_price" value="${vo.c_price }"/></td>
    	</tr>
    	<tr>
    		<th>배 기 량</th>
    		<td><input type="text" name="c_cc" value="${vo.c_cc }" /></td>
    	</tr>
    	
    	</table>
    	
    	<input type="hidden" value="${vo.c_no }" name="c_no" />
    	<input type="submit" value="정보수정" />
    	
    </form>