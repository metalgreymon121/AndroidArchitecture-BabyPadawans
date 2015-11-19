package com.architecture.babypadawans.views.songs.show;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.architecture.babypadawans.R;
import com.architecture.babypadawans.entities.song.SongEntity;
import com.architecture.babypadawans.views.BaseFragment;
import com.squareup.picasso.Picasso;

/**
 * Created by Spiros I. Oikonomakis on 19/11/15.
 */
public class SongShowFragment extends BaseFragment {


  @Bind(R.id.trackName) TextView txtTrackName;
  @Bind(R.id.trackArtistName) TextView txtTrackArtistname;
  @Bind(R.id.avatar) ImageView imgAvatar;

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {


    View fragmentView = inflater.inflate(R.layout.fragment_song_show, container, false);

    ButterKnife.bind(this, fragmentView);

    setupUI();
    return fragmentView;
  }

  @Override
  protected void initialize() {

  }

  @Override
  protected void setupUI() {

  }

  public void songShow(SongEntity songEntity) {
    if (songEntity != null) {
      txtTrackName.setText(songEntity.getTrackName());
      txtTrackArtistname.setText(songEntity.getArtistName());
      Picasso.with(getContext()).load(songEntity.getImageBig().replace("100x100", "500x500")).into(imgAvatar);
    }
  }
}
