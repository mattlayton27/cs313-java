<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <link href="screen.less" type="text/css" rel="stylesheet/less" media="screen">
        <script src="//cdnjs.cloudflare.com/ajax/libs/less.js/2.5.1/less.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Login | Latest Movie Reviews</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="myscript.js"></script>
    </head>
    <body>
        <nav>
            <div id="header">
                <h1>Latest Movie Reviews</h1>
            </div>
            <div id="console_navigation">
                <ul>
                    <li id="homenav"><a href="index.jsp">Home</a></li>
                    <li id="reviewsnav"><a href="reviews.jsp">Reviews</a></li>
                    <li id="adminnav"><a href="Admin">Admin</a></li>
                </ul>
            </div>
            <img src="media/hamburger_menu.png" alt="Hamburger Menu" title="Menu" id="hamburger_menu">
            <div id="mobile_navigation">
                <ul>
                    <li id="mobilehomenav"><div class="space"><a href="index.jsp">Home</a></div></li>
                    <li id="mobilereviewsnav"><div class="space"><a href="reviews.jsp">Reviews</a></div></li>
                    <li id="mobileadminnav"><div class="space"><a href="Admin">Admin</a></div></li>
                </ul>
            </div>
        </nav>
        <main>
            <div id="login">
                <h2>Login</h2>
                <c:if test="${not empty error}">
                    <p id="error">${error}</p>
                </c:if>
                <form method="POST" action="Login">
                    <label for="username">Username</label>
                    <input class="align" type="text" name="username" id="username" required></input><br>
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" required></input><br>
                    <input type="submit" id="submit" value="Login"></input>
                </form>
                <p id="or">Need an account?</p>
                <form method="POST" action="registration.jsp">
                    <input type="submit" id="submit" value="Register"></input>
                </form>
            </div>
        </main>
    </body>
</html>