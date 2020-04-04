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
  <a href="hdisplay">Display Managers</a>
   <a href="hfdisplay">Display Customers</a>
  <a href="hfind">Search Customer</a>
  <a href="hlogout1">Logout</a>
 </li>
</div>
<br>
<p style="text-align: center;font-size: 20px;text-transform: uppercase;color:Green">Welcome
			&nbsp; ${shdata.mname}
			 
</p>
<br>

 <h4 style="text-align: center;">Your Details</h4>
	
<center>
<div style="padding-left:16px">
  
 <table>
		<tr>
			<th> Manager Id </th>
			<th>Email</th>
			<th>Name</th>
			<th>Address</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="tab1" items="${li2}">
		<tr>
		<td align="center"> 
			<form action="hupdate1" method="post" modelAttribute="bean">
			<input type="text" value="${tab1.mid}" name="cust_id" readonly/>
		 </td>
		
		<td align="center"><input type="text" value="${tab1.memail}" name="memail"/></td>
		
		<td align="center"><input type="text" value="${tab1.mname}" name="mname"/></td>
		
		<td align="center"><input type="text" value="${tab1.maddress}" name="maddress"/></td>
		<td align="center"> <input type="submit" value="Update"/> 
		</form> </td>
		
		
		<td align="center"> 
			<form action="hdelete1" method="post" modelAttribute="bean">
			<input type="hidden" value="${tab1.mid}" name="mid"/>
			
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
			