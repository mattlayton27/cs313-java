/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.MovieReview;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Model.User;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander
 */
public class DatabaseInterface {

    static String FORNAME_URL = "com.mysql.jdbc.Driver";
    Connection conn = null;

    public DatabaseInterface() {

        try {
            // Register JDBC driver
            Class.forName(FORNAME_URL);

            // Open a connection
            String user = null;
            String pass = null;
            String url = null;

            if (System.getenv("OPENSHIFT_MYSQL_DB_USERNAME") != null) {
                user = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
                pass = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
                url = "jdbc:mysql://" + System.getenv("OPENSHIFT_MYSQL_DB_HOST") + ":" + System.getenv("OPENSHIFT_MYSQL_DB_PORT") + "/MovieReviewWebsite";
            } else {
                user = "root";
                pass = "password";
                url = "jdbc:mysql://localhost/MovieReviewWebsite";
            }

            conn = DriverManager.getConnection(url, user, pass);

        } catch (ClassNotFoundException | SQLException e) {

            System.out.println("Error initializing database connection: " + e.getMessage());
        }
    }

    public User authorizeUser(String username, String password) {

        ResultSet rs = null;
        User user = null;

        if (conn != null) {

            try {
                Statement stmt = conn.createStatement();
                String sql = "SELECT user_id, name, username, password FROM User WHERE username = '" + username + "' AND password = '" + password + "'";
                rs = stmt.executeQuery(sql);

                if (rs.first()) {
                    int id = rs.getInt("user_id");
                    String d_name = rs.getString("name");
                    String d_username = rs.getString("username");
                    String d_password = rs.getString("password");

                    user = new User(d_name, d_username, d_password);
                    user.setId(id);
                } else {

                    user = null;
                }

                rs.close();
                stmt.close();
            } catch (Exception e) {

                System.out.println("Error executing sql: " + e.getMessage());
            }

        } else {

            System.out.println("Connection not established!");
        }

        return user;
    }

    private boolean userExists(String username) {

        boolean exists = false;
        ResultSet rs = null;

        if (conn != null) {

            try {
                Statement stmt = conn.createStatement();
                String sql = "SELECT username FROM User WHERE username = '" + username + "'";
                rs = stmt.executeQuery(sql);

                if (rs.first()) {

                    exists = true;
                } else {

                    exists = false;
                }

                rs.close();
                stmt.close();
            } catch (Exception e) {

                System.out.println("Error executing sql: " + e.getMessage());
            }

        } else {

            System.out.println("Connection not established while checking if username exists!");
        }

        return exists;
    }

    public boolean registerUser(String name, String username, String password) {

        boolean success = false;
        boolean userExists = userExists(username);

        if (!userExists) {

            if (conn != null) {

                try {
                    PreparedStatement pstmt = null;
                    String sql = "INSERT INTO User (name, username, password) VALUES (?, ?, ?)";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, name);
                    pstmt.setString(2, username);
                    pstmt.setString(3, password);
                    pstmt.executeUpdate();
                    pstmt.close();
                    success = true;
                } catch (Exception e) {

                    System.out.println("Error updating user table: " + e.getMessage());
                }

            } else {

                System.out.println("Connection not established while registering user!");
            }

        } else {

            // user with that username already exists
            success = false;
        }

        return success;
    }

    public List<MovieReview> getMovieReviews() {

        ResultSet rs = null;
        MovieReview review = null;
        List<MovieReview> reviews = new ArrayList<>();

        if (conn != null) {

            try {
                Statement stmt = conn.createStatement();
                String sql = "SELECT r.review_id, r.movie_title, r.review_content, u.name FROM Review AS r INNER JOIN User AS u WHERE r.user_id = u.user_id";
                rs = stmt.executeQuery(sql);

                while (rs.next()) {

                    String id = Integer.toString(rs.getInt("review_id"));
                    String movieTitle = rs.getString("movie_title");
                    String reviewContent = rs.getString("review_content");
                    String reviewerName = rs.getString("name");
                    review = new MovieReview(id, movieTitle, reviewContent, reviewerName);
                    reviews.add(review);
                }

                rs.close();
                stmt.close();
            } catch (Exception e) {

                System.out.println("Error executing sql: " + e.getMessage());
            }

        } else {

            System.out.println("Connection not established while getting movie reviews!");
        }

        return reviews;
    }
    
    public List<MovieReview> getMovieReviewsByReviewer() {

        ResultSet rs = null;
        MovieReview review = null;
        List<MovieReview> reviews = new ArrayList<>();

        if (conn != null) {

            try {
                Statement stmt = conn.createStatement();
                String sql = "SELECT r.review_id, r.movie_title, r.review_content, u.name FROM Review AS r INNER JOIN User AS u WHERE r.user_id = u.user_id ORDER BY u.name ASC";
                rs = stmt.executeQuery(sql);

                while (rs.next()) {

                    String id = Integer.toString(rs.getInt("review_id"));
                    String movieTitle = rs.getString("movie_title");
                    String reviewContent = rs.getString("review_content");
                    String reviewerName = rs.getString("name");
                    review = new MovieReview(id, movieTitle, reviewContent, reviewerName);
                    reviews.add(review);
                }

                rs.close();
                stmt.close();
            } catch (Exception e) {

                System.out.println("Error executing sql: " + e.getMessage());
            }

        } else {

            System.out.println("Connection not established while getting movie reviews!");
        }

        return reviews;
    }
    
    public List<MovieReview> getMovieReviewsByMovie() {

        ResultSet rs = null;
        MovieReview review = null;
        List<MovieReview> reviews = new ArrayList<>();

        if (conn != null) {

            try {
                Statement stmt = conn.createStatement();
                String sql = "SELECT r.review_id, r.movie_title, r.review_content, u.name FROM Review AS r INNER JOIN User AS u WHERE r.user_id = u.user_id ORDER BY r.movie_title ASC";
                rs = stmt.executeQuery(sql);

                while (rs.next()) {

                    String id = Integer.toString(rs.getInt("review_id"));
                    String movieTitle = rs.getString("movie_title");
                    String reviewContent = rs.getString("review_content");
                    String reviewerName = rs.getString("name");
                    review = new MovieReview(id, movieTitle, reviewContent, reviewerName);
                    reviews.add(review);
                }

                rs.close();
                stmt.close();
            } catch (Exception e) {

                System.out.println("Error executing sql: " + e.getMessage());
            }

        } else {

            System.out.println("Connection not established while getting movie reviews!");
        }

        return reviews;
    }

    public void deleteReview(int id) {

        if (conn != null) {

            try {
                PreparedStatement pstmt = null;
                String sql = "DELETE FROM Review WHERE review_id=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
                pstmt.close();
            } catch (Exception e) {

                System.out.println("Error executing sql: " + e.getMessage());
            }

        } else {

            System.out.println("Connection not established while deleting review!");
        }
    }

    public void addReview(int id, String movie, String review) {

        if (conn != null) {

            try {
                PreparedStatement pstmt = null;
                String sql = "INSERT INTO Review (movie_title, review_content, user_id) VALUES (?, ?, ?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, movie);
                pstmt.setString(2, review);
                pstmt.setInt(3, id);
                pstmt.executeUpdate();
                pstmt.close();
                
            } catch (Exception e) {

                System.out.println("Error updating user table: " + e.getMessage());
            }

        } else {

            System.out.println("Connection not established while adding review!");
        }

    }

    public void close() {

        try {

            conn.close();
        } catch (Exception e) {

            System.out.println("Error closing: " + e.getMessage());
        }
    }
}
