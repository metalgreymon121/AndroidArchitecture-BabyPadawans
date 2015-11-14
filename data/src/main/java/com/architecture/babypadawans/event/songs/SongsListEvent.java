package com.architecture.babypadawans.event.songs;

import com.architecture.babypadawans.entities.song.SongEntity;
import com.architecture.babypadawans.event.BaseEvent;
import java.util.List;

/**
 * Created by Spiros I. Oikonomakis on 11/12/15.
 */
public class SongsListEvent extends BaseEvent<List<SongEntity>> {

  public SongsListEvent(List<SongEntity> result, String message) {
    super(result, message);
  }

  public SongsListEvent(String error) {
    super(error);
  }
}
