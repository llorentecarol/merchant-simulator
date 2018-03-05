<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="spring-form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<!-- 
<head>
	<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/3.2.0/css/bootstrap.min.css"/>
    <script type="text/javascript" src="/webjars/jquery/2.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
 -->
<head>

	<!-- Access the bootstrap Css like this,
		Spring boot will handle the resource mapping automcatically -->
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	<c:url value="/css/main.css" var="jstlCss" />
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
			
			<spring-form:form method="POST" action="/process-barcode" modelAttribute="initializeProcessRequest">
			
				<table style="width:50%">
					<tr>
						<td><spring-form:label path="timeout">Simulate Timeout</spring-form:label></td>
                    	<td><spring-form:select path="timeout" style="width:100%;box-sizing: border-box;">
                    			<option value="2000">2 seconds</option>
							    <option value="5000">5 seconds</option>
							    <option value="10000">10 seconds</option>
							    <option value="60000">1 minute</option>
							</spring-form:select>    
						</td>
					</tr>
					<tr>
		                <td><spring-form:label path="merchantId">Merchant ID</spring-form:label></td>
		                <td><spring-form:input path="merchantId" style="width:100%;box-sizing: border-box;"/></td>
		            </tr>
		            <tr>
		                <td><spring-form:label path="merchantTransId">Merchant Trans ID</spring-form:label></td>
		                <td><spring-form:input path="merchantTransId" style="width:100%;box-sizing: border-box;"/></td>
		            </tr>
		            <tr>
		                <td><spring-form:label path="merchantWallet">Merchant Wallet</spring-form:label></td>
		                <td><spring-form:input path="merchantWallet" style="width:100%;box-sizing: border-box;"/></td>
		            </tr>
		            <tr>
		                <td><spring-form:label path="merchantPin">Merchant PIN</spring-form:label></td>
		                <td><spring-form:input path="merchantPin" style="width:100%;box-sizing: border-box;"/></td>
		            </tr>
		            <tr>
		                <td><spring-form:label path="amount">Amount</spring-form:label></td>
		                <td><spring-form:input path="amount" style="width:100%;box-sizing: border-box;"/></td>
		            </tr>
		            <tr>
		                <td><spring-form:label path="transactionDetails">transactionDetails</spring-form:label></td>
		                <td><spring-form:input path="transactionDetails" style="width:100%;box-sizing: border-box;"/></td>
		            </tr>
					<tr>
						<td><spring-form:label path="serviceType">Service Type</spring-form:label></td>
						<td><spring-form:select path="serviceType" style="width:100%;box-sizing: border-box;">
							    <option value="00">General Cashin</option>
							    <option value="01">General Payments</option>
							    <option value="02">711 Specific Cashin</option>
							</spring-form:select>
						</td>
					</tr>
					<tr>
						<td><spring-form:label path="barcodeString">Barcode</spring-form:label></td>
						<td><spring-form:input path="barcodeString" style="width:100%;box-sizing: border-box;"/></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Process CashIn"/></td>
					</tr>
				</table>
			</spring-form:form>

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