package com.architecture.babypadawans.views.register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.architecture.babypadawans.R;
import com.architecture.babypadawans.views.BaseActivity;

public class RegisterActivity extends BaseActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_fragment);
  }

  @Override
  protected void initializeActivity(Bundle savedInstanceState) {
    addFragment(R.id.fragmentContainer, RegisterFragment.newInstance());
  }

  /**
   * Returns the intent for this activity
   *
   * @param context {@link Context}
   * @return {@link Intent}
   */
  public static Intent getCallingIntent(Context context) {
    return new Intent(context, RegisterActivity.class);
  }
}
