<%-- 
    Document   : register
    Created on : 29-Nov-2016, 15:51:30
    Author     : yglee
--%>

<%@ page contentType="text/html" pageEncoding="utf-8"%>
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

</body>
</html>
