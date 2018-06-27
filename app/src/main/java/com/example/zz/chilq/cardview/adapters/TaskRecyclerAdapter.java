package com.example.zz.chilq.cardview.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zz.chilq.R;
import com.example.zz.chilq.cardview.viewholders.TaskRecycleViewHolder;

import java.util.List;
import java.util.Random;

public class TaskRecyclerAdapter extends RecyclerView.Adapter<TaskRecycleViewHolder> {

    private List<String> mDataset;

    public TaskRecyclerAdapter(List<String> dataset) {
        mDataset = dataset;
    }

    @Override
    public TaskRecycleViewHolder onCreateViewHolder(ViewGroup parent,
                                                    int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tasks_card_view, parent, false);

        TaskRecycleViewHolder vh = new TaskRecycleViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(TaskRecycleViewHolder holder, int position) {
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