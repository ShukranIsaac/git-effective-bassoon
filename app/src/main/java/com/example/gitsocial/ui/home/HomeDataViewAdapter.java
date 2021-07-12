package com.example.gitsocial.ui.home;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gitsocial.R;
import com.example.gitsocial.domain.Tutorial;
import com.example.gitsocial.domain.User;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Tutorial}.
 */
public class HomeDataViewAdapter extends RecyclerView.Adapter<HomeDataViewAdapter.ViewHolder> {
    private List<User> mUsers;
    private Context mContext;

    public HomeDataViewAdapter(Context context, List<User> ITEMS) {
        this.mUsers = ITEMS;
        this.mContext = context;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_home_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final @NotNull ViewHolder holder, int position) {
        // bind individual item to view items
        User user = mUsers.get(position);

        //Render image using Picasso library
        if (!TextUtils.isEmpty(user.avatar_url())) {
            Picasso.with(mContext).load(user.avatar_url())
                    .error(R.drawable.ic_launcher_foreground)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(holder.mUserAvatar);
        }

        //Setting text view title
        holder.mUser.setText(Html.fromHtml(user.login()));
    }

    @Override
    public int getItemCount() {
        return (null != mUsers ? mUsers.size() : 0);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mUserAvatar;
        public final TextView mUser;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mUserAvatar = view.findViewById(R.id.thumbnail);
            mUser = view.findViewById(R.id.title);
        }

        @NotNull
        @Override
        public String toString() {
            return super.toString() + " '" + mUser.getText() + "'";
        }
    }
}