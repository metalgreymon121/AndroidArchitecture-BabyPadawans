package com.architecture.babypadawans.views.songs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.architecture.babypadawans.R;
import com.architecture.babypadawans.entities.song.SongEntity;
import com.squareup.picasso.Picasso;
import java.util.Collection;
import java.util.List;

/**
 * Created by Spiros I. Oikonomakis on 11/12/15.
 */
public class SongsAdapter extends BaseAdapter {

  private List<SongEntity> songsList;
  private final Context context;
  private final LayoutInflater layoutInflater;

  static class ViewHolder {

    @Bind(R.id.trackName) TextView txtTrackName;
    @Bind(R.id.trackArtistName) TextView txtTrackArtistname;
    @Bind(R.id.avatar) ImageView imgAvatar;

    public ViewHolder(View itemView) {
      ButterKnife.bind(this, itemView);
    }
  }

  public SongsAdapter(Context context, Collection<SongEntity> songsCollection) {
    this.layoutInflater =
        (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    this.songsList = (List<SongEntity>) songsCollection;
    this.context = context;
  }

  @Override
  public int getCount() {
    return songsList.size();
  }

  @Override
  public Object getItem(int position) {
    return songsList.get(position);
  }

  @Override
  public long getItemId(int position) {
    return songsList.get(position).hashCode();
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {

    ViewHolder holder;
    if (convertView != null) {
      holder = (ViewHolder) convertView.getTag();
    } else {
      convertView = layoutInflater.inflate(R.layout.row_song, parent, false);
      holder = new ViewHolder(convertView);
      convertView.setTag(holder);
    }

    final SongEntity songEntity = this.songsList.get(position);
    holder.txtTrackName.setText(songEntity.getTrackName());
    holder.txtTrackArtistname.setText(songEntity.getArtistName());
    Picasso.with(context).load(songEntity.getImageBig()).into(holder.imgAvatar);

    return convertView;
  }

  public void setSongsCollection(Collection<SongEntity> songsCollection) {
    this.songsList = (List<SongEntity>) songsCollection;
    this.notifyDataSetChanged();
  }
}
