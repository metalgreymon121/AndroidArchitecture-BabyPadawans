package com.architecture.babypadawans.entities.song;

import java.io.Serializable;

/**
 * Created by Spiros I. Oikonomakis on 11/12/15.
 */
public class SongEntity implements Serializable {

  private final String trackName;

  private final String artistName;

  private String collectionName;

  private String image;

  private String imageMedium;

  private String imageBig;

  public SongEntity(String trackName, String artistName) {
    this.trackName = trackName;
    this.artistName = artistName;
  }

  public String getTrackName() {
    return trackName;
  }

  public String getArtistName() {
    return artistName;
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
