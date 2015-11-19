package com.architecture.babypadawans.views.songs;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.architecture.babypadawans.entities.song.SongEntity;
import com.architecture.babypadawans.net.itunes.ItunesRestApi;
import com.architecture.babypadawans.net.itunes.ItunesRestApiImpl;
import com.architecture.babypadawans.event.songs.SongsListEvent;
import com.architecture.babypadawans.R;
import com.architecture.babypadawans.views.BaseFragment;
import com.architecture.babypadawans.views.custom.DividerItemDecoration;
import com.architecture.babypadawans.views.songs.adapters.SongsAdapter;
import com.architecture.babypadawans.views.songs.show.SongActivity;
import com.squareup.otto.Subscribe;
import java.util.ArrayList;

/**
 * Created by Spiros I. Oikonomakis on 11/12/15.
 */
public class SongsFragment extends BaseFragment implements AdapterView.OnItemClickListener {

  private ItunesRestApi itunesRestApi;
  private SongsAdapter songsAdapter;
  private SongsListener songsListener;

  /**
   * Interface for listening user list events.
   */
  interface SongsListener {
    void onSongClicked(SongEntity songEntity);
  }

  // UI
  @Bind(R.id.rvSongs) GridView rvSongs;

  public SongsFragment() {
    super();
  }

  public static SongsFragment newInstance() {
    return new SongsFragment();
  }

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    View fragmentView = inflater.inflate(R.layout.fragment_songs, container, false);

    ButterKnife.bind(this, fragmentView);

    setupUI();
    return fragmentView;
  }

  @Override public void onAttach(Activity activity) {
    super.onAttach(activity);
    if (activity instanceof SongsActivity) {
      this.songsListener = (SongsListener) activity;
    }
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    this.initialize();

    itunesRestApi.getTrackListByTerm("Dream Theater");
  }

  @Override
  protected void initialize() {
    itunesRestApi = new ItunesRestApiImpl(bus);
  }

  @Override
  protected void setupUI() {
    songsAdapter = new SongsAdapter(getContext(), new ArrayList<SongEntity>());
    this.rvSongs.setAdapter(songsAdapter);
  }


  // EVENTS SUBSCRIBER
  @Subscribe
  public void onSongsListEvent(SongsListEvent event) {
    if (event.getResult() != null) {
      songsAdapter.setSongsCollection(event.getResult());
      rvSongs.setOnItemClickListener(this);
    }
  }

  @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    SongEntity songEntity = (SongEntity) songsAdapter.getItem(position);
    if (songEntity != null) {
      this.songsListener.onSongClicked(songEntity);
    }
  }
}
