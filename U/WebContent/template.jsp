<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자동차 쇼핑몰</title>
<link type="text/css" rel="stylesheet" href="css/common.css">
</head>
<body>

	<jsp:include page="top.jsp"></jsp:include>
	<div class="wrap_template">
	<jsp:include page="nav.jsp"></jsp:include>
		<jsp:include page="${template}.jsp"></jsp:include>
	</div>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>