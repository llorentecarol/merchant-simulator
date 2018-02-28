<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

	<!-- Access the bootstrap Css like this,
		Spring boot will handle the resource mapping automcatically -->
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
	 
	<c:url value="/css/basic.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Mynt Merchant Simulator</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">
		
			<br>
			
			<form action="/process-barcode">
			
				<table style="width:50%" cellpadding="10">
					<tr>
						<td>Simulate Timeout</td>
						<td>
							<select name="timeout">
							    <option value="2000">2 seconds</option>
							    <option value="5000">5 seconds</option>
							    <option value="10000">10 seconds</option>
							    <option value="60000">1 minute</option>
							  </select>
						</td>
					</tr>
					<tr>
						<td>Service Type</td>
						<td>
							<select name="serviceType">
							    <option value="00">General Cashin</option>
							    <option value="01">General Payments</option>
							    <option value="02">711 Specific Cashin</option>
							  </select>
						</td>
					</tr>
					<tr>
						<td>Barcode</td>
						<td><input type="text" style="width:100%;box-sizing: border-box;" name="barcodeString"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Process CashIn"/></td>
					</tr>
				</table>
			</form>

		</div>
		<div class="starter-template">
			<font color="red">${error}</font>
			<br>
			
			<p>${request} </p>
		</div>

	</div>

	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>