<!--
Author:  Younggil Lee
  Student ID: 991 395 505
  Description: Create sign-up Application that stores users data, handles attributes
               between logical components. Also, filter to prevent pages from unauthorized access.    
-->

<%@ page contentType="text/html" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Login Page</title>

<!-- CSS -->
<link rel="stylesheet" type="text/css" href="files/css/screen.css">

</head>
<body>

<div class="contentblock">
    <c:if test="${!empty loginMessage}">
        <p class ="red">${loginMessage}</p>
    </c:if>


<form action="Login" method="post">
<div class="row">
<div class="col1">User ID: </div> <input type="text" name="user">
</div>
<div class="row">
<div class="col1">Password: </div> <input type="password" name="pass">
</div>
<br>
<div class="row">
<div class="col1">&nbsp; </div> <input type="submit" value="Login">
</div>
</form>
<br>

<p>
Not register yet? <a href="Register">Sign up here</a>.
</p>

</div>

</body>
</html>
