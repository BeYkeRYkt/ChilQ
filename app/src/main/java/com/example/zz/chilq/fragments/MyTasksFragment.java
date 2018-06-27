package com.example.zz.chilq.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zz.chilq.R;
import com.example.zz.chilq.cardview.adapters.TaskRecyclerAdapter;

import java.util.ArrayList;

public class MyTasksFragment extends Fragment {

    // CardView
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private TaskRecyclerAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my_tasks, container,
                false);
        getActivity().setTitle("Мои дела");

        // CardView
        ArrayList<String> myDataset = getDataSet();
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(rootView.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new TaskRecyclerAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
        return rootView;
    }

    private ArrayList<String> getDataSet() {
        ArrayList<String> mDataSet = new ArrayList();
        for (int i = 0; i < 15; i++) {
            mDataSet.add(i, "Test №" + i);
        }
        return mDataSet;
    }
}
