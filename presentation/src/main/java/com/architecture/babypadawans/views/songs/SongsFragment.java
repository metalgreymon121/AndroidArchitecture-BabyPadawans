package com.architecture.babypadawans.views.songs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.squareup.otto.Subscribe;
import java.util.ArrayList;

/**
 * Created by Spiros I. Oikonomakis on 11/12/15.
 */
public class SongsFragment extends BaseFragment {

  private ItunesRestApi itunesRestApi;
  private SongsAdapter songsAdapter;

  // UI
  @Bind(R.id.rvSongs) RecyclerView rvSongs;

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
    this.rvSongs.setLayoutManager(new LinearLayoutManager(getActivity()));
    songsAdapter = new SongsAdapter(getContext(), new ArrayList<SongEntity>());
    this.songsAdapter.setOnItemClickListener(onItemClickListener);
    this.rvSongs.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL_LIST));
    this.rvSongs.setAdapter(songsAdapter);
  }


  // EVENTS SUBSCRIBER
  @Subscribe
  public void onSongsListEvent(SongsListEvent event) {
    if (event.getResult() != null) {
      songsAdapter.setSongsCollection(event.getResult());
      songsAdapter.setOnItemClickListener(onItemClickListener);
    }
  }

  private SongsAdapter.OnItemClickListener onItemClickListener =
      new SongsAdapter.OnItemClickListener() {
        @Override public void onSongItemClicked(SongEntity songEntity) {
          if (songEntity != null) {
          }
        }
      };
}
