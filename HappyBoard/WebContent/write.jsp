<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form action="write" method="post">

	<input type="hidden" name="btype" value="${btype}"> <br /> 
	제목: <input type="text" name="btitle"> <br />
	내용 : <textarea name="bcontent"></textarea> <br />
	비밀번호 : <input type="password" name="pw">

<input type="submit" value="글작성">



</form>