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
        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="files/css/screen.css">
        <title>Main Page</title>
    </head>
    <body>       

        <c:if test="${empty user}">
            <c:redirect url="Login"/>
        </c:if> 

        <h3>Welcome EJD HomePage</h3>
        <br>
        <p>Hello,${user.nickname} </p>
        <br>
        <h4 class="red">Your login information</h4>
        <br>
        <p>User ID: ${user.userId}</p> <br>
        <p>Nick Name: ${user.nickname}</p> <br>
        <p>Email: ${user.email}</p> <br>
        <br>
        <a href="logout.jsp">Log out</a>
        <br>
        <h3>Users</h3>

        <table>
            <tr>
                <th>ID</th><th>Nick Name</th><th>Email</th>
            </tr>             
            <c:forEach var="users" items="${users}">
                <tr>
                    <th>${users.userId}</th>
                    <td>${users.nickname}</td>
                    <td>${users.email}</td>
                </tr>
            </c:forEach>            
        </table>

    </body>
</html>