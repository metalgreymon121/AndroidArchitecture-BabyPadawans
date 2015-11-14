package com.architecture.babypadawans.entities.user;

/**
 * Created by Spiros I. Oikonomakis on 11/12/15.
 */
public class UserEntity {

  private final String username;

  private String email;

  private String token;

  public UserEntity(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
