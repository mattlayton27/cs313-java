<%-- 
    Document   : index
    Created on : Jun 22, 2016, 3:37:00 PM
    Author     : Matthew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Search</title>
    </head>
    <body>
        <h1>Movie Search</h1>
        <form method="post" action="MovieSearch">
            <label for="searchParam">Search</label>
            <input type="text" id="searchParam" name="searchParam"></input>
            <br>
            <br>
            <input type="submit" value="Search">
        </form>
        
        <h2>Movies</h2>
        <c:forEach var="movie" items="${movies}">
            <p>${movie.Title} (${movie.Year})</p>
        </c:forEach>
    </body>
</html>
