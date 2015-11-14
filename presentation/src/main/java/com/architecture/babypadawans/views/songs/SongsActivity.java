package com.architecture.babypadawans.views.songs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.architecture.babypadawans.R;
import com.architecture.babypadawans.managers.SessionManager;
import com.architecture.babypadawans.views.BaseActivity;

public class SongsActivity extends BaseActivity {

  private SessionManager sessionManager;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_fragment);
  }

  @Override
  protected void initializeActivity(Bundle savedInstanceState) {
    sessionManager = new SessionManager(this);
    addFragment(R.id.fragmentContainer, SongsFragment.newInstance());
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_songs, menu);
    return true;
  }
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    //if you have more items use switch not multiple if/else
    if (item.getItemId() == R.id.action_logout) {
      sessionManager.setLoggedIn(false);
      finish();
      navigator.navigateToLogin(this);
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  /**
   * Returns the intent for this activity
   *
   * @param context {@link Context}
   * @return {@link Intent}
   */
  public static Intent getCallingIntent(Context context) {
    return new Intent(context, SongsActivity.class);
  }
}
