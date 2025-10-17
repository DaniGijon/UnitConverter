<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    
<link href="../css/styles.css" rel="stylesheet" type="text/css">
<link href="css/styles.css" rel="stylesheet" type="text/css">
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
				
				</div>
			<div>
				<ul>
					<li>
						<form id="formLength" action="/UnitConverter/Length" method="GET"">
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
					</li>
					
					<li>
						<form id="formWeight" action="/UnitConverter/Weight" method="GET"">
							<h3>Weight</h3>
							<datalist id="weight_units">
								<option value=milligram></option>
								<option value="gram"></option>
								<option value="kilogram"></option>
								<option value="ounce"></option>
								<option value="pound"></option>
							</datalist>
							<div>
								<label for="weight_input">Enter the weight to convert</label>
								<input type="number" id="weight_input" name="weight_input" required min="0" value="0" step="0.001"></input>
							</div>
							<div>
								<label for="weight_unit_from">Unit to Convert from</label>
								<input type="text" list="weight_units" id="weight_unit_from" name="weight_unit_from"></input>
							</div>
							<div>
								<label for="weight_unit_to">Unit to convert to</label>
								<input type="text" list="weight_units" id="weight_unit_to" name="weight_unit_to" required></input>
							</div>
							<div>
								<input type="submit" id="weight_convert_submit" name="weight_convert_submit" value="Convert"></input>
							</div>
							
						</form>
					</li>
				
					<li>
						<form id="formTemperature" action="/UnitConverter/Temperature" method="GET"">
							<h3>Temperature</h3>
							<datalist id="temperature_units">
								<option value=celsius></option>
								<option value="fahrenheit"></option>
								<option value="kelvin"></option>
							</datalist>
							<div>
								<label for="temperature_input">Enter the temperature to convert</label>
								<input type="number" id="temperature_input" name="temperature_input" required value="0" step="0.001"></input>
							</div>
							<div>
								<label for="temperature_unit_from">Unit to Convert from</label>
								<input type="text" list="temperature_units" id="temperature_unit_from" name="temperature_unit_from"></input>
							</div>
							<div>
								<label for="temperature_unit_to">Unit to convert to</label>
								<input type="text" list="temperature_units" id="temperature_unit_to" name="temperature_unit_to" required></input>
							</div>
							<div>
								<input type="submit" id="temperature_convert_submit" name="temperature_convert_submit" value="Convert"></input>
							</div>
							
						</form>
					</li>
				</ul>
				
				<div>
					<h4>Result of your calculation</h4>
					<h5>
						<% 
					        String input = (String) request.getAttribute("input");
					        String result = (String) request.getAttribute("result");
					        String unit_from = (String) request.getAttribute("unit_from");
				            String unit_to = (String) request.getAttribute("unit_to");
				            if (null != input && null != result && null != unit_from && null != unit_to) {

					            out.println(input + " " + unit_from + " = " + result + " " + unit_to);
				            } else {
				            	 out.println("will be showed here.");
				            }
				        %>
			        </h5>
				</div>
			</div>
		</div>
	</body>
</html>