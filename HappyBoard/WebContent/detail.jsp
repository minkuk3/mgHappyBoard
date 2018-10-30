<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    ${vo.seq}<br/>
    ${vo.btitle}<br/>
    ${vo.bcontent}<br/>
    ${vo.bregdate}<br/>
    
   <button onclick="location.href='update?btype=${param.btype}&seq=${vo.seq}'">수정</button>
   <button onclick="location.href='delete?btype=${param.btype}&seq=${vo.seq}'">삭제</button>