package com.architecture.babypadawans.net.itunes.songs;

import com.google.gson.annotations.SerializedName;

public class TrackInfoDTO {

  @SerializedName("trackName") private String trackName;

  @SerializedName("artistName") private String artistName;

  @SerializedName("collectionName") private String collectionName;

  @SerializedName("artworkUrl30") private String image;

  @SerializedName("artworkUrl60") private String imageMedium;

  @SerializedName("artworkUrl100") private String imageBig;

  public TrackInfoDTO() {
  }

  public String getTrackName() {
    return trackName;
  }

  public void setTrackName(String trackName) {
    this.trackName = trackName;
  }

  public String getArtistName() {
    return artistName;
  }

  public void setArtistName(String artistName) {
    this.artistName = artistName;
  }

  public String getCollectionName() {
    return collectionName;
  }

  public void setCollectionName(String collectionName) {
    this.collectionName = collectionName;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getImageMedium() {
    return imageMedium;
  }

  public void setImageMedium(String imageMedium) {
    this.imageMedium = imageMedium;
  }

  public String getImageBig() {
    return imageBig;
  }

  public void setImageBig(String imageBig) {
    this.imageBig = imageBig;
  }
}