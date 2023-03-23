<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	 * 기본적으로 자바를 jsp에서 사용 하기에는 불편하기 때문에
	 * JSTL(아파치에서 제공하는 라이브러리)을 사용해서 HTML의 태그 형식으로
	 * 자바를 쓴다.
	 */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 서버에 접속하면 자동으로 보여줍니다.
 <a href="<%= request.getContextPath() %>/boards/list">게시글</a>
</body>
</html>