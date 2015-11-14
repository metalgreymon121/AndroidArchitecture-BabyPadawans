package com.architecture.babypadawans.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.architecture.babypadawans.navigation.Navigator;

public abstract class BaseActivity extends AppCompatActivity {

  protected Navigator navigator = Navigator.INSTANCE;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


    this.initializeActivity(savedInstanceState);
  }

  /**
   * Adds a {@link Fragment} to this activity's layout.
   *
   * @param containerViewId The container view to where add the fragment.
   * @param fragment The fragment to be added.
   */
  protected void addFragment(int containerViewId, Fragment fragment) {
    FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
    fragmentTransaction.add(containerViewId, fragment);
    fragmentTransaction.commit();
  }

  /**
   * Initialize activity
   *
   * @param savedInstanceState {@link Bundle}
   */
  protected abstract void initializeActivity(Bundle savedInstanceState);
}