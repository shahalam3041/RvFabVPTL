package com.example.shahalam.rvfabvptl.views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shahalam.rvfabvptl.models.MyDataModel;
import com.example.shahalam.rvfabvptl.R;
import com.example.shahalam.rvfabvptl.adapters.RecyclerViewAdapter;
import com.example.shahalam.rvfabvptl.interfaces.FragmentCommunicator;
import com.example.shahalam.rvfabvptl.utils.Sharedpreferences;

import java.util.ArrayList;
import java.util.List;

public class FragmentOne extends Fragment {

    RecyclerView fragOneRecyclerView;
    List<MyDataModel> myDataModels = new ArrayList<>();
    RecyclerViewAdapter adapterFragmentOne = new RecyclerViewAdapter(getActivity(), myDataModels);


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        fragOneRecyclerView = view.findViewById(R.id.fragmentOneRecyclerView);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((MainActivity) getActivity()).passVal(new FragmentCommunicator() {
            @Override
            public void sendData(List<MyDataModel> myDataModels) {

                updateRecyclerView(myDataModels);
            }
        });
    }


    public void updateRecyclerView(List<MyDataModel> myDataModels) {
        fragOneRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapterFragmentOne = new RecyclerViewAdapter(getContext(), myDataModels);
        fragOneRecyclerView.setAdapter(adapterFragmentOne);
        adapterFragmentOne.notifyDataSetChanged();
    }
}
