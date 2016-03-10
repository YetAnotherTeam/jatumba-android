package com.jat.jatumba.presentation.main.compositions;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jat.jatumba.R;
import com.jat.jatumba.data.entity.Composition;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by bulat on 22.02.16.
 */
public class CompositionsAdapter extends RecyclerView.Adapter<CompositionsAdapter.CompositionViewHolder>{
    private final List<Composition> compositions;
    private View.OnClickListener onItemClickListener;

    public CompositionsAdapter(List<Composition> compositions) {
        this.compositions = compositions;
    }

    public void setOnItemClickListener(View.OnClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public CompositionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.composition_view, parent, false);
        return new CompositionViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(CompositionViewHolder holder, int position) {
        holder.bind(compositions.get(position));
    }

    @Override
    public int getItemCount() {
        return compositions.size();
    }

    public class CompositionViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.composition_name)
        TextView compositionNameTextView;

        public CompositionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(onItemClickListener);
        }

        public void bind(Composition composition) {
            compositionNameTextView.setText(composition.getName());
            itemView.setTag(composition);
        }
    }
}
