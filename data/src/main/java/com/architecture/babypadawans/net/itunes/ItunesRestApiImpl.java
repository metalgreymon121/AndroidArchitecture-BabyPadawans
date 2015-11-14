package com.architecture.babypadawans.net.itunes;

import com.architecture.babypadawans.entities.song.SongEntity;
import com.architecture.babypadawans.entities.song.mapper.SongEntityDataMapper;
import com.architecture.babypadawans.net.itunes.songs.TrackInfoResponse;
import com.architecture.babypadawans.event.songs.SongsListEvent;
import com.squareup.otto.Bus;
import java.util.ArrayList;
import java.util.List;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Spiros I. Oikonomakis on 11/12/15.
 */
public class ItunesRestApiImpl implements ItunesRestApi {

  private final Bus bus;
  private final ItunesResourceService resourceService;
  private final SongEntityDataMapper songEntityDataMapper = new SongEntityDataMapper();

  public ItunesRestApiImpl(Bus bus) {
    RestAdapter restApi = new RestAdapter.Builder().setEndpoint(Constants.API_URL)
        .setLogLevel(RestAdapter.LogLevel.FULL)
        .build();

    this.resourceService = restApi.create(ItunesResourceService.class);
    this.bus = bus;
  }

  @Override
  public void getTrackListByTerm(String term) {
    resourceService.getTrackListByTerm(term, new Callback<TrackInfoResponse>() {
      @Override
      public void success(TrackInfoResponse trackInfoResponse, Response response) {
        if (trackInfoResponse.getResultsCount() > 0) {
          List<SongEntity> songs = songEntityDataMapper.transform(trackInfoResponse.getTrackInfoList());
          bus.post(new SongsListEvent(songs, ""));
        } else {
          bus.post(new SongsListEvent(new ArrayList<SongEntity>(), "No results found"));
        }
      }

      @Override
      public void failure(RetrofitError error) {
        bus.post(error.getMessage());
      }
    });
  }
}
