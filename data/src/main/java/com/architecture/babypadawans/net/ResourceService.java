package com.architecture.babypadawans.net;

import com.architecture.babypadawans.net.response.common.BaseResponse;
import com.architecture.babypadawans.net.response.login.UserDTO;
import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Spiros I. Oikonomakis on 11/12/15.
 */
interface ResourceService {

  @FormUrlEncoded
  @POST("/users/login.php")
  void login(@Field("username") String username,
      @Field("password") String password, Callback<BaseResponse<UserDTO>> response);


  @FormUrlEncoded
  @POST("/users/register.php")
  void register(@Field("username") String username,
      @Field("password") String password, @Field("email") String email,
      Callback<BaseResponse<UserDTO>> response);
}
