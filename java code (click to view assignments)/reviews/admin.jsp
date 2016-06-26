<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <link href="screen.less" type="text/css" rel="stylesheet/less" media="screen">
        <script src="//cdnjs.cloudflare.com/ajax/libs/less.js/2.5.1/less.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Admin | Latest Movie Reviews</title>
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
            <div id="admin">
                <div id="welcome">Welcome, (name of reviewer)</div>
                <a href="Logout" id="logout">Log Out</a>
                <h2>Add Movie Review</h2>
                <form method="POST" action="AddReview">
                    <label for="movie"><b>Movie</b></label><br>
                    <input type="text" id="movie" name="movieName"></input><br><br>
                    <label for="review"><b>Review</b></label><br>
                    <textarea id="review" name="movieReview" cols="100" rows="5"></textarea><br>
                    <input type="submit" name="action" id="addMovie" value="Add"></input>
                </form>

                <!--Here is where the list of all the reviews will be-->
                <table>
                    <tr>
                        <th class="movieTd">Movie</th>
                        <th class="reviewerTd">Reviewer</th>
                        <th class="reviewTd">Review</th>
                    </tr>
                    <!-- Start of foreach loop -->
                    <tr>
                        <td class="movieTd">Example</td>
                        <td class="reviewerTd">Example</td>
                        <td class="reviewTd">Example</td>
                        <td class="deleteTd">
                            <form method="POST" action="DeleteReview">
                                <input type="hidden" name="reviewId" value="exampleId"></input>
                                <input type="submit" id="deleteButton" value="Delete"></input>
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td class="movieTd">Example</td>
                        <td class="reviewerTd">Example</td>
                        <td class="reviewTd">Example</td>
                        <td class="deleteTd">
                            <form method="POST" action="DeleteReview">
                                <input type="hidden" name="reviewId" value="exampleId"></input>
                                <input type="submit" id="deleteButton" value="Delete"></input>
                            </form>
                        </td>
                    </tr>
                </table>
            </div>
        </main>
    </body>
</html>
