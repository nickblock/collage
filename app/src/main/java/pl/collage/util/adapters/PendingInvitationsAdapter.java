package pl.collage.util.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import pl.collage.friendsearch.FriendSearchListener;
import pl.collage.util.models.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PendingInvitationsAdapter extends RecyclerView.Adapter<PendingInvitationsAdapter.ViewHolder> {

    private List<User> pendingInvitationsList;
    private FriendSearchListener friendSearchListener;

    public PendingInvitationsAdapter(List<User> pendingInvitationsList,
                                     FriendSearchListener friendSearchListener) {
        this.pendingInvitationsList = pendingInvitationsList;
        this.friendSearchListener = friendSearchListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(pl.collage.R.layout.item_pending, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.textView.setText(pendingInvitationsList.get(position).fullName);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                friendSearchListener.onInvitationAccepted(holder.getAdapterPosition(),
                        pendingInvitationsList.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return pendingInvitationsList.size();
    }

    public void setPendingInvitationsList(List<User> pendingInvitationsList) {
        this.pendingInvitationsList = pendingInvitationsList;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(pl.collage.R.id.item_pending_text_view)
        TextView textView;

        @BindView(pl.collage.R.id.item_pending_accept_button)
        Button button;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
