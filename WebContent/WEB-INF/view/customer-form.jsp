<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Customer Form</title>
<link type="text/css" rel="stylesheet" 
	href="${pageContext.request.contextPath}/resources/css/style.css"/>
<link type="text/css" 
	  rel="stylesheet" 
	  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<h2>CRM-Customer RelationShip Manger</h2>
	</div>
</div>

<div  id="container">

	<form:form  action="saveCustomer" modelAttribute="customer" method="POST">
	
	<form:hidden path="id"/>
	<table>
	<tr>
		<td><label>First Name:</label></td>
		<td><form:input type="text" path="firstName"/></td>
	</tr>
	
	<tr>	
		<td><label>Last Name:</label></td>
		<td><form:input type="text" path="lastName"/></td>
	</tr>
	<tr>
		<td><label>Email:</label></td>
		<td><form:input type="text" path="email"/></td>
	</tr>
	<tr>
		<td><label></label></td>
		<td><input type="submit" value="Save" class="save"/></td>
	</tr>
	</table>
	</form:form>
	
	<div style="clear; both;"></div>
	
	<p>
		<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>	
	</p>
</div>
</body>
</html>