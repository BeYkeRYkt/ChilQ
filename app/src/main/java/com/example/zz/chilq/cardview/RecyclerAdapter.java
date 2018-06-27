package com.example.zz.chilq.cardview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zz.chilq.R;

import java.util.List;
import java.util.Random;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<String> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTitleView;
        public ImageView mImageView;
        public TextView mDescriptionView;
        public TextView mRewardTextView;


        public ViewHolder(View v) {
            super(v);
            mTitleView = (TextView) v.findViewById(R.id.card_view_title);
            mImageView = (ImageView) v.findViewById(R.id.card_view_image);
            mDescriptionView = (TextView) v.findViewById(R.id.card_view_description);
            mRewardTextView = (TextView) v.findViewById(R.id.card_view_reward);
        }
    }

    public RecyclerAdapter(List<String> dataset) {
        mDataset = dataset;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card_view, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mImageView.setImageResource(R.drawable.ic_launcher_background);
        holder.mTitleView.setText(mDataset.get(position));
        holder.mDescriptionView.setText("SAMPLE TEXT SAMPLE TEXT SAMPLE TEXT SAMPLE TEXT SAMPLE TEXT SAMPLE TEXT SAMPLE TEXT SAMPLE TEXT SAMPLE TEXT SAMPLE TEXT");

        Random r = new Random();
        holder.mRewardTextView.setText("Баллы: " + r.nextInt(100));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}