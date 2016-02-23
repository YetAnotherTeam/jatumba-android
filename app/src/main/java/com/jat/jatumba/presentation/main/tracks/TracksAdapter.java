package com.jat.jatumba.presentation.main.tracks;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jat.jatumba.R;
import com.jat.jatumba.data.model.Track;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by bulat on 22.02.16.
 */
public class TracksAdapter extends RecyclerView.Adapter<TracksAdapter.TrackViewHolder>{
    private final List<Track> tracks;
    private View.OnClickListener onItemClickListener;

    public TracksAdapter(List<Track> tracks) {
        this.tracks = tracks;
    }

    public void setOnItemClickListener(View.OnClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public TrackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.band_member_view, parent, false);
        return new TrackViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(TrackViewHolder holder, int position) {
        holder.bind(tracks.get(position));
    }

    @Override
    public int getItemCount() {
        return tracks.size();
    }

    public class TrackViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.member_full_name)
        TextView memberFullNameTextView;

        public TrackViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(onItemClickListener);
        }

        public void bind(Track track) {
            memberFullNameTextView.setText(track.getName());
            itemView.setTag(track);
        }
    }
}
