<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<head>
<style type="text/css">
  		<%@include file="/css/home.css" %>
  		</style>
</head>
<div class="topnav">

 <li>
 <center><a> Welcome  ${sdata.cname}</a> </center>
  <a href="find">Search Customer</a>
  <a href="logout1">Logout</a>
 </li>
</div>


 <h2 style="text-align: center;color:SlateBlue">Customer List</h2>
	
<center>
<div style="padding-left:18px">
  
 <table>
		<tr>
			<th>Customer.Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>LoanType</th>
			<th>Address</th>
		</tr>
		<c:forEach var="tab" items="${data}">
		<tr>
		<td>${tab.cust_id}</td>
		<td>${tab.cname}</td>
		<td>${tab.cemail}</td>
		<td>${tab.cloantype}</td>
		<td>${tab.caddress}</td>
		</tr>		
		</c:forEach>
	</table>
<br>
<h3> ${msg } </h3>

	
</div>
</center>