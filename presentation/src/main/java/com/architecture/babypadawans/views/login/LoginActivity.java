package com.architecture.babypadawans.views.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.architecture.babypadawans.R;
import com.architecture.babypadawans.managers.SessionManager;
import com.architecture.babypadawans.views.BaseActivity;

public class LoginActivity extends BaseActivity implements LoginFragment.LoginListener {

  private SessionManager sessionManager;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_fragment);
  }

  @Override
  protected void initializeActivity(Bundle savedInstanceState) {
    sessionManager = new SessionManager(this);

    if (sessionManager.isLoggedIn()) {
      navigator.navigateToSongs(this);
      finish();
    }
    addFragment(R.id.fragmentContainer, LoginFragment.newInstance());
  }

  /**
   * Returns the intent for this activity
   *
   * @param context {@link Context}
   * @return {@link Intent}
   */
  public static Intent getCallingIntent(Context context) {
    return new Intent(context, LoginActivity.class);
  }

  @Override
  public void onSuccessLogin() {
    navigator.navigateToSongs(this);
    sessionManager.setLoggedIn(true);
    finish();
  }

  @Override public void onClickRegister() {
    navigator.navigateToRegister(this);

  }
}
