<%-- 
    Document   : login
    Created on : Jun 18, 2016, 9:39:15 AM
    Author     : Matthew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Discussion Thread</h1>
        <form action="SignIn" method="POST">
            Username <input type="text" name="username"/><br/><br/>
            Password <input type="password" name="password"/><br/><br/>
            <input type="submit"/>
        </form>
    </body>
</html>
