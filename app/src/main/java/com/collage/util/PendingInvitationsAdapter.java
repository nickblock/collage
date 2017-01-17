package com.collage.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.collage.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PendingInvitationsAdapter extends RecyclerView.Adapter<PendingInvitationsAdapter.ViewHolder> {

    private List<String> pendingInvitationsList;

    public PendingInvitationsAdapter(List<String> pendingInvitationsList) {
        this.pendingInvitationsList = pendingInvitationsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pending, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(pendingInvitationsList.get(position));
    }

    @Override
    public int getItemCount() {
        return pendingInvitationsList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_pending_text_view)
        TextView textView;

        @BindView(R.id.item_pending_accept_button)
        Button button;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}