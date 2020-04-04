<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css"> <%@include file="/css/stylereg.css" %> </style>
</head>
<body>

<h2>Customer Registration Panel</h2>
<div class="container">
  <form:form action="save" method="post" modelAttribute="bean">
    <div class="row">
      <div class="col-25">
        <label for="fname">Full Name</label>
      </div>
      <div class="col-75">
        <form:input path="cname" placeholder="Enter Your name.." required="required"/>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="lname">Your Email</label>
      </div>
      <div class="col-75">
       <form:input path="cemail" type="email" placeholder="Enter Your email.." required="required"/>
      </div>
    </div>
    
    <div class="row">
      <div class="col-25">
        <label for="lname">Enter Password</label>
      </div>
      <div class="col-75">
       <form:input path="cpass" type="password"  placeholder="Enter Your password.." required="required"/>
      </div>
    </div>
      <div class="row">
      <div class="col-25">
        <label for="lname">Gender</label>
      </div>
      <div class="col-75">
      					<form:radiobutton path="gender" value="Male" />Male&nbsp;
					   	<form:radiobutton path="gender" value="Female" />Female&nbsp;
      </div>
    </div>
    
    <div class="row">
      <div class="col-25">
        <label for="country">LoanType</label>
      </div>
      <div class="col-75">
        <form:select path="cloantype" required="required">
		 	<form:option value=""> -- select LoanType -- </form:option>	
			<form:option value="PersonalLoan">Personal Loan</form:option>
			<form:option value="HomeLoan">HomeLoan</form:option>
			<form:option value="BusinessLoan">BusinessLoan</form:option>
			<form:option value="VehicleLoan">VehicleLoan</form:option>
			
			
			</form:select>
      </div>
    </div>
   
    <div class="row">
      <div class="col-25">
        <label for="subject">Address</label>
      </div>
      <div class="col-75">
        <form:input path="caddress" type="text" placeholder="Enter Your Adreess.." required="required"/>
      </div>
    </div>
    <div class="row">
      <input type="submit" value="Submit">
    </div><br>
    <a class="abc" href="login1"> Already Registered? Log in..</a>
  </form:form>
  
</div>

<h2>${msg }</h2>

</body>
</html>
