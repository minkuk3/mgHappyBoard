<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form action="update" method="post">
	<input type="hidden" name="seq" value="${vo.seq}"> 
	<input type="hidden" name="btype" value="${vo.btype}">
	 제목:
	<input type="text" name="btitle" value="${vo.btitle}"> <br />
	 내용 :
	<textarea name="bcontent" >${vo.bcontent}</textarea>
	<br />
	 <input	type="submit" value="수정완료">
</form>
