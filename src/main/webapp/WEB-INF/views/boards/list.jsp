<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글</h1>
	<hr>
	<table>
		<thead>
			<tr>
				<td>글 번호</td>
				<td>제목</td>
				<td>조회수</td>
				<td>작성자</td>
				<td>수정일</td>
				<td>작성일</td>
			</tr>
		</thead>
		<tbody>
			<% //넘어올때 ResultSet 타입의 정보가 담겨 있기때문에 형변환 해줘야된다
			ResultSet rs =(ResultSet)request.getAttribute("list");
			while(rs.next()) { 
				int no = rs.getInt("no");
				String title = rs.getString("title");
				int readCount = rs.getInt("read_count");
				String writer = rs.getString("writer");
				Timestamp udate = rs.getTimestamp("updated_date");
				Timestamp cDate = rs.getTimestamp("created_date");	
				%>
			<tr>
				<td><%= no %></td>
				<td><%= title %></td>
				<td><%= readCount %></td>
				<td><%= writer %></td>
				<td><%= udate %></td>
				<td><%= cDate %></td>
			</tr>
			<% } %>
			<tr>
				<td colspan="6">게시글이 더이상 존재 하지 않습니다</td>
			</tr>
		</tbody>

	</table>
</body>
</html>