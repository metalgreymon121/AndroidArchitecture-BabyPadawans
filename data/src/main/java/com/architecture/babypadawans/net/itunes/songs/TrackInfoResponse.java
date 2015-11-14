package com.architecture.babypadawans.net.itunes.songs;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TrackInfoResponse {

  @SerializedName("resultCount") private long resultsCount;

  @SerializedName("results") private List<TrackInfoDTO> trackInfoList;

  public long getResultsCount() {
    return resultsCount;
  }

  public void setResultsCount(long resultsCount) {
    this.resultsCount = resultsCount;
  }

  public List<TrackInfoDTO> getTrackInfoList() {
    return trackInfoList;
  }

  public void setTrackInfoList(List<TrackInfoDTO> trackInfoList) {
    this.trackInfoList = trackInfoList;
  }
}