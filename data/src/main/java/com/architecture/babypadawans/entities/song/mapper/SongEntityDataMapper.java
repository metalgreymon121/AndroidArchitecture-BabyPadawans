package com.architecture.babypadawans.entities.song.mapper;

import com.architecture.babypadawans.entities.song.SongEntity;
import com.architecture.babypadawans.net.itunes.songs.TrackInfoDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Spiros I. Oikonomakis on 11/12/15.
 */
public class SongEntityDataMapper {

  public SongEntityDataMapper() {
  }

  /**
   * Transforms a {@link TrackInfoDTO} to a {@link SongEntity}
   *
   * @param trackInfoDTO {@link TrackInfoDTO}
   * @return {@link SongEntity}
   */
  public SongEntity transform(TrackInfoDTO trackInfoDTO) {
    SongEntity songEntity = null;
    if (trackInfoDTO != null) {
      songEntity = new SongEntity(trackInfoDTO.getTrackName(), trackInfoDTO.getArtistName());
      songEntity.setImage(trackInfoDTO.getImage());
      songEntity.setImageBig(trackInfoDTO.getImageBig());
      songEntity.setImageMedium(trackInfoDTO.getImageMedium());
      songEntity.setCollectionName(trackInfoDTO.getCollectionName());
    }
    return songEntity;
  }

  /**
   * Transforms a Collection of {@link TrackInfoDTO} to a list  of {@link SongEntity}
   * @param trackInfoDTOCollection a list with {@link TrackInfoDTO}
   * @return a list with {@link SongEntity}
   */
  public List<SongEntity> transform(Collection<TrackInfoDTO> trackInfoDTOCollection) {
    List<SongEntity> entities = new ArrayList<>();
    SongEntity songEntity = null;
    for (TrackInfoDTO trackInfo : trackInfoDTOCollection) {
      songEntity = transform(trackInfo);
      if (songEntity != null) {
        entities.add(songEntity);
      }
    }
    return entities;
  }
}
