package com.architecture.babypadawans.navigation;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.architecture.babypadawans.R;
import com.architecture.babypadawans.entities.song.SongEntity;
import com.architecture.babypadawans.views.login.LoginActivity;
import com.architecture.babypadawans.views.register.RegisterActivity;
import com.architecture.babypadawans.views.songs.SongsActivity;
import com.architecture.babypadawans.views.songs.show.SongActivity;
import com.architecture.babypadawans.views.songs.show.SongShowFragment;

/**
 * Created by Spiros I. Oikonomakis on 11/12/15.
 */
public enum  Navigator {
  INSTANCE;

  /**
   * Goes to the login screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToLogin(Context context) {
    if (context != null) {
      Intent intentToLaunch = LoginActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  /**
   * Goes to the register screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToRegister(Context context) {
    if (context != null) {
      Intent intentToLaunch = RegisterActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  /**
   * Goes to the register screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToSongs(Context context) {
    if (context != null) {
      Intent intentToLaunch = SongsActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  /**
   * Goes to song details screen
   *
   * @param context
   * @param songEntity
   */
  public void navigateToSongDetails(Context context, SongEntity songEntity) {
    if (context != null) {
      SongShowFragment songShowFragment =
          (SongShowFragment) ((FragmentActivity) context).getSupportFragmentManager().findFragmentById(R.id.fragmentSongView);
      if (songShowFragment != null) {
        if (songShowFragment.isAdded()) {
             songShowFragment.songShow(songEntity);
        }
      } else {
        Intent intentToLaunch = SongActivity.getCallingIntent(context);
        intentToLaunch.putExtra(SongActivity.EXTRA_SONG_ENTITY, songEntity);
        context.startActivity(intentToLaunch);
      }
    }
  }
}
