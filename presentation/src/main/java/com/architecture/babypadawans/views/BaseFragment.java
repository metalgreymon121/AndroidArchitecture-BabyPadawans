package com.architecture.babypadawans.views;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.architecture.babypadawans.R;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Base {@link android.app.Fragment} class for every fragment in this application.
 */
public abstract class BaseFragment extends Fragment {

  protected Bus bus = new Bus(ThreadEnforcer.MAIN);

  @Bind(R.id.rlProgress) protected RelativeLayout progressBar;
  @Bind(R.id.pgBar) protected ProgressBar pgBar;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);
  }

  @Override
  public void onStart() {
    super.onStart();
    bus.register(this);
  }

  @Override
  public void onStop() {
    super.onStop();
    bus.unregister(this);
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    ButterKnife.unbind(this);
  }

  /**
   * Shows a {@link android.widget.Toast} message.
   *
   * @param message An string representing a message to be shown.
   */
  protected void showToastMessage(String message) {
    Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
  }


  public Context getContext() {
    return this.getActivity().getApplicationContext();
  }

  /**
   * Shows a loading view
   */
  protected void showViewLoading() {
    getActivity().runOnUiThread(new Runnable() {
      @Override public void run() {
        progressBar.setVisibility(ProgressBar.VISIBLE);
        pgBar.setVisibility(ProgressBar.VISIBLE);
        getActivity().setProgressBarIndeterminateVisibility(true);
      }
    });
  }

  /**
   * Shows a loading view
   */
  public void hideViewLoading() {
    getActivity().runOnUiThread(new Runnable() {
      @Override public void run() {
        progressBar.setVisibility(ProgressBar.INVISIBLE);
        pgBar.setVisibility(ProgressBar.INVISIBLE);
        getActivity().setProgressBarIndeterminateVisibility(false);
      }
    });
  }

  /**
   * Initializes the fragment with Presenter and injection
   */
  protected abstract void initialize();

  /**
   * Setups the UI
   */
  protected abstract void setupUI();
}