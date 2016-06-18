/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posts.model;

/**
 *
 * @author Matthew
 */
public class Post {
  private String post;
  private String username;

  public Post(){
    setPost("");
    setUsername("");
  }

  public Post(String post, String username) {
    this.setPost(post);
    this.setUsername(username);
  }

  public String getPost() {
    return post;
  }

  public void setPost(String post) {
    this.post = post;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
  
  @Override
  public String toString() {
      return post + "\n" + username;
  }
  
  public String toFileString() {
        return post + "," + username;
  }

 
  public void loadFromFileString(String str) {
        // TODO: Validation should be done here
        String[] parts = str.split(",");

 
        post = parts[0];
        username = parts[1];
  }
}
