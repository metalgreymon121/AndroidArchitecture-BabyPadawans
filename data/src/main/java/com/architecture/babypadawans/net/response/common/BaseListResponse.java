package com.architecture.babypadawans.net.response.common;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Spiros I. Oikonomakis on 10/26/15.
 */
public class BaseListResponse<T> {

  /**
   * The http code or a custom code
   */
  @SerializedName("code") private Long code;

  /**
   * The message of the response
   */
  @SerializedName("message") private String message;

  /**
   * The data of the response in a list
   */
  @SerializedName("response") private List<T> response;

  public BaseListResponse() {
  }

  public BaseListResponse(Long code, String message, List<T> response) {
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

  public List<T> getResponse() {
    return this.response;
  }

  public void setCode(Long code) {
    this.code = code;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setResponse(List<T> response) {
    this.response = response;
  }
}