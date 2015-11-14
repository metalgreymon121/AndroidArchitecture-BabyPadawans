package com.architecture.babypadawans.navigation;

import android.content.Context;
import android.content.Intent;
import com.architecture.babypadawans.views.login.LoginActivity;
import com.architecture.babypadawans.views.register.RegisterActivity;
import com.architecture.babypadawans.views.songs.SongsActivity;

/**
 * Created by Spiros I. Oikonomakis on 11/12/15.
 */
public enum  Navigator {
  INSTANCE;

  /**
   * Goes to the login screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToLogin(Context context) {
    if (context != null) {
      Intent intentToLaunch = LoginActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  /**
   * Goes to the register screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToRegister(Context context) {
    if (context != null) {
      Intent intentToLaunch = RegisterActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  /**
   * Goes to the register screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToSongs(Context context) {
    if (context != null) {
      Intent intentToLaunch = SongsActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

}
