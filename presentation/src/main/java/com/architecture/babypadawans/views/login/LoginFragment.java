package com.architecture.babypadawans.views.login;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.architecture.babypadawans.net.RestApi;
import com.architecture.babypadawans.net.RestApiImpl;
import com.architecture.babypadawans.event.login.LoginEvent;
import com.architecture.babypadawans.R;
import com.architecture.babypadawans.views.BaseFragment;
import com.squareup.otto.Subscribe;

public class LoginFragment extends BaseFragment {

  private RestApi restApi;
  /**
   * Interface for listening user list events.
   */
  interface LoginListener {
    void onSuccessLogin();
    void onClickRegister();
  }
  // UI

  @Bind(R.id.edtUsername) EditText edtUsername;

  @Bind(R.id.edtPassword) EditText edtPasword;


  private LoginListener loginListener;

  public LoginFragment() {
    super();
  }

  public static LoginFragment newInstance() {
    return new LoginFragment();
  }

  @Override public void onAttach(Activity activity) {
    super.onAttach(activity);
    if (activity instanceof LoginListener) {
      this.loginListener = (LoginListener) activity;
    }
  }

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    View fragmentView = inflater.inflate(R.layout.fragment_login, container, false);

    ButterKnife.bind(this, fragmentView);

    setupUI();
    return fragmentView;
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    this.initialize();
  }

  @OnClick({R.id.btnSignIn, R.id.txtRegister})
  public void onSignInClick(View view) {
    switch (view.getId()) {
      case R.id.btnSignIn:
        if (TextUtils.isEmpty(edtUsername.getText())) {
          edtUsername.setError("Cannot be empty");
          return;
        }
        if (TextUtils.isEmpty(edtPasword.getText())) {
          edtPasword.setError("Cannot be empty");
          return;
        }

        restApi.login(edtUsername.getText().toString(), edtPasword.getText().toString());
        break;
      case R.id.txtRegister:
        this.loginListener.onClickRegister();
        break;
    }
  }

  @Override protected void initialize() {
     restApi = new RestApiImpl(bus);
  }

  @Override protected void setupUI() {

  }

  // EVENTS SUBSCRIBER
  @Subscribe public void onLoginEvent(LoginEvent event) {
    if (event.getResult() != null) {
      this.loginListener.onSuccessLogin();
    } else {
      this.edtUsername.setError("Wrong username");
      this.edtPasword.setError("Wrong password");
    }
    Toast.makeText(getContext(), event.getMessage(), Toast.LENGTH_LONG).show();
  }
}
