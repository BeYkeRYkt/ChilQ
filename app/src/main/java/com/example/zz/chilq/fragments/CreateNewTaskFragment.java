package com.example.zz.chilq.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zz.chilq.R;

public class CreateNewTaskFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_create_new_tasks, container,
                false);
        getActivity().setTitle("Список дел");
        return rootView;
    }
}
