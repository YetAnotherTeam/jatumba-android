package com.jat.jatumba.presentation.main.bandMembers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jat.jatumba.R;
import com.jat.jatumba.data.model.User;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by bulat on 22.02.16.
 */
public class BandMembersAdapter extends RecyclerView.Adapter<BandMembersAdapter.BandMemberViewHolder>{
    private final List<User> users;
    private View.OnClickListener onItemClickListener;

    public BandMembersAdapter(List<User> users) {
        this.users = users;
    }

    public void setOnItemClickListener(View.OnClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public BandMemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.band_member_view, parent, false);
        return new BandMemberViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(BandMemberViewHolder holder, int position) {
        holder.bind(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class BandMemberViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.member_full_name)
        TextView memberFullNameTextView;

        public BandMemberViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(onItemClickListener);
        }

        public void bind(User user) {
            memberFullNameTextView.setText(user.getFullName());
            itemView.setTag(user);
        }
    }
}
