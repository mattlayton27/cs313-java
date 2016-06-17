<%-- 
    Document   : scriptureList
    Created on : Jun 15, 2016, 2:07:34 PM
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
    <c:forEach var="scripture" items="${scriptures}">

        <strong>${scripture.book}</strong> ${scripture.chapter}:${scripture.verse}<br />

    </c:forEach>
    </body>
</html>
