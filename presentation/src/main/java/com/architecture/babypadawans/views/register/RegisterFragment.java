package com.architecture.babypadawans.views.register;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Patterns;
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
import com.architecture.babypadawans.event.register.RegisterEvent;
import com.architecture.babypadawans.R;
import com.architecture.babypadawans.views.BaseFragment;
import com.squareup.otto.Subscribe;

/**
 * Created by Spiros I. Oikonomakis on 11/12/15.
 */
public class RegisterFragment extends BaseFragment {

  private RestApi restApi;
  // UI
  @Bind(R.id.edtUsername) EditText edtUsername;

  @Bind(R.id.edtPassword) EditText edtPasword;

  @Bind(R.id.edtEmail) EditText edtEmail;

  public static RegisterFragment newInstance() {
    return new RegisterFragment();
  }

  public RegisterFragment() {
    super();
  }

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    View fragmentView = inflater.inflate(R.layout.fragment_register, container, false);

    ButterKnife.bind(this, fragmentView);

    setupUI();
    return fragmentView;
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    initialize();
  }

  @Override
  protected void initialize() {
    this.restApi = new RestApiImpl(bus);
  }

  @Override
  protected void setupUI() {

  }

  @OnClick(R.id.btnSignUp) public void onSignInClick() {
    if (TextUtils.isEmpty(edtUsername.getText())) {
      edtUsername.setError("Cannot be empty");
      return;
    }
    if (TextUtils.isEmpty(edtPasword.getText())) {
      edtPasword.setError("Cannot be empty");
      return;
    }
    if (TextUtils.isEmpty(edtEmail.getText())) {
      edtPasword.setError("Cannot be empty");
      return;
    }

    if (!Patterns.EMAIL_ADDRESS.matcher(edtEmail.getText()).matches()) {
      edtPasword.setError("This fields must be an email");
      return;
    }

    restApi.register(edtUsername.getText().toString(), edtPasword.getText().toString(),
        edtEmail.getText().toString());
  }


  // EVENTS SUBSCRIBER
  @Subscribe public void onRegisterEvent(RegisterEvent event) {
    if (event.getResult() != null) {
      this.edtUsername.setError(null);
      this.edtPasword.setError(null);
      this.edtEmail.setError(null);
    } else {
      this.edtUsername.setError("Wrong username");
      this.edtPasword.setError("Wrong password");
      this.edtEmail.setError("Wrong email");
    }
    Toast.makeText(getContext(), event.getMessage(), Toast.LENGTH_LONG).show();
  }
}
