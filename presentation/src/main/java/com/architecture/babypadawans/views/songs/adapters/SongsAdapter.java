package com.architecture.babypadawans.views.songs.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.architecture.babypadawans.entities.song.SongEntity;
import com.architecture.babypadawans.R;
import com.squareup.picasso.Picasso;
import java.util.Collection;
import java.util.List;

/**
 * Created by Spiros I. Oikonomakis on 11/12/15.
 */
public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongViewHolder> {

  public interface OnItemClickListener {
    void onSongItemClicked(SongEntity placeEntity);
  }

  private List<SongEntity> songsList;
  private final Context context;
  private final LayoutInflater layoutInflater;

  private OnItemClickListener onItemClickListener;

  public SongsAdapter(Context context, Collection<SongEntity> songsCollection) {
    this.validatePlacesCollection(songsCollection);
    this.layoutInflater =
        (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    this.songsList = (List<SongEntity>) songsCollection;
    this.context = context;
  }

  @Override public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = this.layoutInflater.inflate(R.layout.row_song, parent, false);
    return new SongViewHolder(view);
  }

  @Override public void onBindViewHolder(SongViewHolder holder, int position) {
    final SongEntity songEntity = this.songsList.get(position);

    holder.txtTrackName.setText(songEntity.getTrackName());
    holder.txtTrackArtistname.setText(songEntity.getArtistName());

    Picasso.with(context)
        .load(songEntity.getImageMedium())
        .into(holder.imgAvatar);

    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if (SongsAdapter.this.onItemClickListener != null) {
          SongsAdapter.this.onItemClickListener.onSongItemClicked(songEntity);
        }
      }
    });
  }

  @Override public int getItemCount() {
    return this.songsList != null ? this.songsList.size() : 0;
  }

  public void setSongsCollection(Collection<SongEntity> songsCollection) {
    this.validatePlacesCollection(songsCollection);
    this.songsList = (List<SongEntity>) songsCollection;
    this.notifyDataSetChanged();
  }

  public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
    this.onItemClickListener = onItemClickListener;
  }

  private void validatePlacesCollection(Collection<SongEntity> songsCollection) {
    if (songsCollection == null) {
      throw new IllegalArgumentException("The list cannot be null");
    }
  }

  static class SongViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.trackName) TextView txtTrackName;
    @Bind(R.id.trackArtistName) TextView txtTrackArtistname;
    @Bind(R.id.avatar) ImageView imgAvatar;

    public SongViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
