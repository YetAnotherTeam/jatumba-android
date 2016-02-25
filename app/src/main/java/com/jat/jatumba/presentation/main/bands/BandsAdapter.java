package com.jat.jatumba.presentation.main.bands;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jat.jatumba.R;
import com.jat.jatumba.data.entity.Band;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by bulat on 22.02.16.
 */
public class BandsAdapter extends RecyclerView.Adapter<BandsAdapter.BandViewHolder>{
    private final List<Band> bands;
    private View.OnClickListener onItemClickListener;

    public BandsAdapter(List<Band> bands) {
        this.bands = bands;
    }

    public void setOnItemClickListener(View.OnClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public BandViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.band_view, parent, false);
        return new BandViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(BandViewHolder holder, int position) {
        holder.bind(bands.get(position));
    }

    @Override
    public int getItemCount() {
        return bands.size();
    }

    public class BandViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.band_name)
        TextView bandNameTextView;

        public BandViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(onItemClickListener);
        }

        public void bind(Band band) {
            bandNameTextView.setText(band.getName());
            itemView.setTag(band);
        }
    }
}
