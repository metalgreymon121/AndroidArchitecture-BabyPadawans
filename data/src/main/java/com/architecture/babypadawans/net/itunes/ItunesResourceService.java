package com.architecture.babypadawans.net.itunes;

import com.architecture.babypadawans.net.itunes.songs.TrackInfoResponse;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

interface ItunesResourceService {

  /**
   * Returns track list
   */
  @GET("/search?media=music&entity=musicTrack")
  void getTrackListByTerm(
      @Query(value = "term", encodeValue = false) String keyword,
      Callback<TrackInfoResponse> trackInfoResponseCallback);
}