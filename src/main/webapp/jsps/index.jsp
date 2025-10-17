<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
		<title>Unit Converter App</title>
	</head>
	<body>
		<div class="container">
		<div>
			<h2>Unit Converter</h2>
			<br>
			<h3>Date=<%= new Date() %>
			</h3>
			</div>
			<div>
				<form id="formLength" action="processGet.jsp" method="GET">
					<h3>Length</h3>
					<datalist id="length_units">
						<option value="milimeters"></option>
						<option value="centimeters"></option>
						<option value="meters"></option>
						<option value="kilometers"></option>
						<option value="inches"></option>
						<option value="feet"></option>
						<option value="yards"></option>
						<option value="miles"></option>
					</datalist>
					<div>
						<label for="length_input">Enter the length to convert</label>
						<input type="number" id="length_input" name="length_input" required min="0" value="0" step="0.001"></input>
					</div>
					<div>
						<label for="length_unit_from">Unit to Convert from</label>
						<input type="text" list="length_units" id="length_unit_from" name="length_unit_from"></input>
					</div>
					<div>
						<label for="length_unit_to">Unit to convert to</label>
						<input type="text" list="length_units" id="length_unit_to" name="length_unit_to" required></input>
					</div>
					<div>
						<input type="submit" id="length_convert_submit" name="length_convert_submit" value="Convert"></input>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>