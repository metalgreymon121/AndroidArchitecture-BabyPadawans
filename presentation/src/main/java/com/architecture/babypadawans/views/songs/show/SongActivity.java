package com.architecture.babypadawans.views.songs.show;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.architecture.babypadawans.R;
import com.architecture.babypadawans.entities.song.SongEntity;
import com.architecture.babypadawans.managers.SessionManager;
import com.architecture.babypadawans.views.BaseActivity;

public class SongActivity extends BaseActivity {

  public static final String EXTRA_SONG_ENTITY = "extra_song_entity";

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_song_show);

    Bundle extras = getIntent().getExtras();
    if (extras != null) {
      SongEntity songEntity = (SongEntity) extras.getSerializable(EXTRA_SONG_ENTITY);
      if (songEntity != null) {
        initializeFragment(songEntity);
      }
    }
  }

  @Override
  protected void initializeActivity(Bundle savedInstanceState) {
  }

  /**
   * Returns the intent for this activity
   *
   * @param context {@link Context}
   * @return {@link Intent}
   */
  public static Intent getCallingIntent(Context context) {
    return new Intent(context, SongActivity.class);
  }



  /**
   * Propagates the tv show identifier to the fragment.
   */
  private void initializeFragment(SongEntity songEntity) {
    SongShowFragment songShowFragment =
        (SongShowFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentSongShow);
    songShowFragment.songShow(songEntity);
  }
}
