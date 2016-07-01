<%-- 
    Document   : index
    Created on : Jun 29, 2016, 4:17:10 PM
    Author     : Alexander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Persons Database</title>
    </head>
    <body>
        <h1>People</h1>
        <c:forEach var="person" items="${people}">
            <a href="details.jsp?data=${person.getPersonInfo()}">${person.getName()}</a><br /> 
        </c:forEach>
    </body>
</html>
