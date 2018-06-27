package com.example.zz.chilq.cardview.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zz.chilq.R;

public class TaskRecycleViewHolder extends RecyclerView.ViewHolder {
    public TextView mTitleView;
    public ImageView mImageView;
    public TextView mDescriptionView;
    public TextView mRewardTextView;

    public TaskRecycleViewHolder(View view) {
        super(view);
        mTitleView = (TextView) view.findViewById(R.id.card_view_title);
        mImageView = (ImageView) view.findViewById(R.id.card_view_image);
        mDescriptionView = (TextView) view.findViewById(R.id.card_view_description);
        mRewardTextView = (TextView) view.findViewById(R.id.card_view_reward);
    }
}
