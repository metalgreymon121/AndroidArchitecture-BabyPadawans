package com.architecture.babypadawans.net.response.login;

/**
 * Created by Spiros I. Oikonomakis on 11/12/15.
 */
public class UserDTO {

  private final String username;

  private final String token;

  public UserDTO(String username, String token) {
    this.username = username;
    this.token = token;
  }

  public String getUsername() {
    return username;
  }

  public String getToken() {
    return token;
  }
}
