<%-- 
    Document   : discussions
    Created on : Jun 18, 2016, 9:45:17 AM
    Author     : Matthew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %> 
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scripture List</title>
    </head>
    <body>
    <h1>Posts</h1>
    <c:forEach var="post" items="${posts}">
        <p>${post.post};
        <p>- ${post.username}</p><br>
    </c:forEach>
    <h2>Add New Post</h2>
    <form method="POST" action="CreatePost">
        <textarea cols="50" rows="3" type="text" name="post"></textarea>
        <input type="hidden" name="username" value="${username}"><br>
        <input type="submit" value="Submit">
    </form><br>
    <a href="SignOut">Sign Out</a>
    </body>
</html>
