package com.example.shahalam.rvfabvptl;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FragmentOne extends Fragment {

    public FragmentOne() {
    }

    RecyclerView fragOneRecyclerView;
    List<MyDataModel> myDataModels = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one,container,false);

        fragOneRecyclerView = view.findViewById(R.id.fragmentOneRecyclerView);
        fragOneRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        final RecyclerViewAdapter adapterFragmentOne = new RecyclerViewAdapter(getContext(),myDataModels);
        fragOneRecyclerView.setAdapter(adapterFragmentOne);

        Bundle mBundle =getArguments();
        String title, description;
        if (mBundle != null) {
            title = this.getArguments().getString("title");
            description = this.getArguments().getString("description");

            MyDataModel mOne4 = new MyDataModel(title,description);

            myDataModels.add(mOne4);

            adapterFragmentOne.notifyDataSetChanged();
        }
        else {
            title = "No Title ";
            description ="No description";

            MyDataModel mOne4 = new MyDataModel(title,description);

            myDataModels.add(mOne4);

            adapterFragmentOne.notifyDataSetChanged();
        }

        return view;
    }


}
