<!--
Author:  Younggil Lee
  Student ID: 991 395 505
  Description: Create sign-up Application that stores users data, handles attributes
               between logical components. Also, filter to prevent pages from unauthorized access.    
-->
<%@ page contentType="text/html" pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>EJD Registration Page</title>

<!-- CSS -->
<link rel="stylesheet" type="text/css" href="files/css/screen.css">

</head>
<body>

<div class="contentblock">
<h2>Registration Form</h2>

<p>
Please fill out the form below...
</p>
 <c:if test="${not empty message}">
     <p class ="red">  ${message} </p>
        </c:if> 

 
<form action="Register" method="post">
<div class="row">
<div class="col3">Choose user ID:</div> <input class="col4" type="text" name="userId">
</div>
<div class="row">
<div class="col3">Choose your password:</div> <input class="col4" type="password" name="pass1">
</div>
<div class="row">
<div class="col3">Re-enter password:</div> <input class="col4" type="password" name="pass2">
</div>
<div class="row">
<div class="col3">Enter your nickname:</div> <input class="col4" type="text" name="nickname">
</div>
<div class="row">
<div class="col3">Enter your email address:</div> <input class="col4" type="text" name="email">
</div>
<div class="row">
<div class="col3">&nbsp;</div>    <input class="col4" type="submit" value="Signup">
</div>
</form>

</div>
<a href="index.html">Go to Home page.</a>
</body>
</html>
