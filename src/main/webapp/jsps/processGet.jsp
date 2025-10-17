<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>GET form processing</title>
	</head>
	<body>
		<div class="container">
			<h2>GET Form processing</h2>
			<%--Retrieving parameters from the request --%>
			<% String length_input = request.getParameter("length_input"); %>
			<% String length_unit_from = request.getParameter("length_unit_from"); %>
			<% String length_unit_to = request.getParameter("length_unit_to"); %>
			
			<h3>You want to convert the amount of: <%=length_input %></h3>
			<h3>from <%=length_unit_from%> to <%=length_unit_to%>. </h3>
		</div>
	</body>
</html>