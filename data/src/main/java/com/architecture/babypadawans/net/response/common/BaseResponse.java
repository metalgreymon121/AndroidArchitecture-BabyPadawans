package com.architecture.babypadawans.net.response.common;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Spiros I. Oikonomakis on 10/26/15.
 */
public class BaseResponse<T> {

  /**
   * The http code or a custom code
   */
  @SerializedName("code") private Long code;

  /**
   * The message of the response
   */
  @SerializedName("message") private String message;

  /**
   * The data of the response
   */
  @SerializedName("response") private T response;

  public BaseResponse() {
  }

  public BaseResponse(Long code, String message, T response) {
    this.code = code;
    this.message = message;
    this.response = response;
  }

  public Long getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  public T getResponse() {
    return this.response;
  }

  public void setCode(Long code) {
    this.code = code;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setResponse(T response) {
    this.response = response;
  }

}