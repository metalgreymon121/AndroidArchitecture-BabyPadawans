package com.architecture.babypadawans.event.login;

import com.architecture.babypadawans.entities.user.UserEntity;
import com.architecture.babypadawans.event.BaseEvent;

/**
 * Created by Spiros I. Oikonomakis on 11/12/15.
 */
public class LoginEvent extends BaseEvent<UserEntity> {

  public LoginEvent(UserEntity result, String message) {
    super(result, message);
  }

  public LoginEvent(String error) {
    super(error);
  }

}
