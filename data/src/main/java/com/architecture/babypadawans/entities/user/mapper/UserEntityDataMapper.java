package com.architecture.babypadawans.entities.user.mapper;

import com.architecture.babypadawans.entities.user.UserEntity;
import com.architecture.babypadawans.net.response.login.UserDTO;

/**
 * Created by Spiros I. Oikonomakis on 11/12/15.
 */
public class UserEntityDataMapper {

  public UserEntityDataMapper() {
  }

  /**
   * Transforms a {@link UserDTO} to a {@link UserEntity}
   * @param userDTO {@link UserDTO}
   * @return {@link UserEntity}
   */
  public UserEntity transform(UserDTO userDTO) {
    UserEntity userEntity = null;
    if (userDTO != null) {
      userEntity = new UserEntity(userDTO.getUsername());
      userEntity.setToken(userDTO.getToken());
    }
    return userEntity;
  }
}
