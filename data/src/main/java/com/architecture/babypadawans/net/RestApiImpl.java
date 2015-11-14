package com.architecture.babypadawans.net;

import com.architecture.babypadawans.entities.user.UserEntity;
import com.architecture.babypadawans.entities.user.mapper.UserEntityDataMapper;
import com.architecture.babypadawans.net.response.common.BaseResponse;
import com.architecture.babypadawans.net.response.login.UserDTO;
import com.architecture.babypadawans.event.login.LoginEvent;
import com.architecture.babypadawans.event.register.RegisterEvent;
import com.squareup.otto.Bus;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Spiros I. Oikonomakis on 11/12/15.
 */
public class RestApiImpl implements RestApi {

  private final Bus bus;
  private final ResourceService resourceService;
  private final UserEntityDataMapper userEntityDataMapper = new UserEntityDataMapper();

  public RestApiImpl(Bus bus) {
    RestAdapter restApi = new RestAdapter.Builder().setEndpoint(Constants.API_URL)
        .setLogLevel(RestAdapter.LogLevel.FULL)
        .build();

    this.resourceService = restApi.create(ResourceService.class);
    this.bus = bus;
  }

  @Override
  public void login(String username, String password) {
      this.resourceService.login(username, password, new Callback<BaseResponse<UserDTO>>() {
        @Override
        public void success(BaseResponse<UserDTO> loginResponseBaseResponse,
            Response response) {
          if (loginResponseBaseResponse.getResponse() != null) {
            UserEntity userEntity = userEntityDataMapper.transform(loginResponseBaseResponse.getResponse());

            bus.post(new LoginEvent(userEntity, loginResponseBaseResponse.getMessage()));
          }
        }

        @Override
        public void failure(RetrofitError error) {
          bus.post(new LoginEvent(error.getLocalizedMessage()));
        }
      });
  }

  @Override
  public void register(String username, String password, String email) {
    this.resourceService.register(username, password, email, new Callback<BaseResponse<UserDTO>>() {
      @Override
      public void success(BaseResponse<UserDTO> registerResponseBaseResponse,
          Response response) {

        if (registerResponseBaseResponse.getResponse() != null) {
          bus.post(new RegisterEvent(true, registerResponseBaseResponse.getMessage()));
        }
      }

      @Override
      public void failure(RetrofitError error) {
        bus.post(new LoginEvent(error.getLocalizedMessage()));

      }
    });
  }
}
