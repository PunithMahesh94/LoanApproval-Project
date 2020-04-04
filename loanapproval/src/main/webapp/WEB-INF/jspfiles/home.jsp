<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<head>
<style type="text/css">
  		<%@include file="/css/home.css" %>
  		</style>
</head>

<body>
<div class="topnav">
  <li>
  <a href="display">Display Customers</a>
  <a href="find">Search Customer</a>
  <a href="logout1">Logout</a>
 </li>
</div>
<br>
<p style="text-align: center;font-size: 30px;text-transform: uppercase;color:SlateBlue">Welcome
			&nbsp; ${sdata.cname}
			 
</p>
<br>

 <h4 style="text-align: center;">Your Details</h4>
	
<center>
<div style="padding-left:16px">
  
 <table>
		<tr>
			<th> CustomerID </th>
			<th>Email</th>
			<th>Name</th>
			<th>LoanType</th>
			<th>Address</th>
			<th>Update</th>
			<th>Delete</th>
			
		</tr>
		<c:forEach var="tab1" items="${li2}">
		<tr>
		<td> 
			<form action="update1" method="post" modelAttribute="bean">
			<input type="text" value="${tab1.cust_id}" name="cust_id" readonly/>
		 </td>
		
		<td ><input type="text" value="${tab1.cemail}" name="cemail"/></td>
		
		<td ><input type="text" value="${tab1.cname}" name="cname"/></td>
		<td>${tab1.cloantype}</td>
		<td><input type="text" value="${tab1.caddress}" name="caddress"/></td>
		<td align="center"> <input type="submit" value="Update"/> 
		</form> </td>
		
		
		<td align="center"> 
			<form action="delete1" method="post" modelAttribute="bean">
			<input type="hidden" value="${tab1.cust_id}" name="cust_id"/>
			
			<input type="submit" value="Delete"/> 
		</td>
		
		
		
		</tr>		
		</c:forEach>
	</table>
	<br>

			<c:if test="${not empty msg2}">
				<script>
					alert("${msg2}");
					
				</script>
			</c:if></body>
			<br>
			<h3> ${msg3} </h3>
			
			
			
			
			
			
			
			<a href="apply">Apply</a>
			