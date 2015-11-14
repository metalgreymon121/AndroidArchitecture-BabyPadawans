package com.architecture.babypadawans.managers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Spiros I. Oikonomakis on 11/12/15.
 */
public class SessionManager {

  private final static String SESSION_DB_NAME = "com.architecture.babypadawans.SESSION";
  private final static String FIELD_AUTHENTICATED = "AUTHENTICATED";

  private SharedPreferences prefs;
  private SharedPreferences.Editor editor;


  public SessionManager(Context context) {
    this.prefs = context.getSharedPreferences(SESSION_DB_NAME, Context.MODE_PRIVATE);
    this.editor = this.prefs.edit();
  }

  public boolean setLoggedIn(boolean status) {
    this.editor.putBoolean(FIELD_AUTHENTICATED, status);
    return this.editor.commit();
  }

  public boolean isLoggedIn() {
    return this.prefs.getBoolean(FIELD_AUTHENTICATED, false);
  }
}
