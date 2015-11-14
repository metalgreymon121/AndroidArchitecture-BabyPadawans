package com.architecture.babypadawans.event.register;

import com.architecture.babypadawans.event.BaseEvent;

/**
 * Created by Spiros I. Oikonomakis on 11/12/15.
 */
public class RegisterEvent extends BaseEvent<Boolean> {

  public RegisterEvent(Boolean result, String message) {
    super(result, message);
  }

  public RegisterEvent(String error) {
    super(error);
  }
}
