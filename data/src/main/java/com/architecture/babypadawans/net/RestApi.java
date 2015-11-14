package com.architecture.babypadawans.net;

/**
 * Created by Spiros I. Oikonomakis on 11/12/15.
 */
public interface RestApi {

  void login(String username, String password);

  void register(String username, String password, String email);
}
