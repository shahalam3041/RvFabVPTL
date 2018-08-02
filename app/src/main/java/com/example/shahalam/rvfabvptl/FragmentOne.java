package com.example.shahalam.rvfabvptl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FragmentOne extends Fragment {

    RecyclerView fragOneRecyclerView;
    List<MyDataModel> myDataModels = new ArrayList<>();
    RecyclerViewAdapter adapterFragmentOne = new RecyclerViewAdapter(getActivity(), myDataModels);
    String title, description;

    FragmentCommunicator fragmentCommunicator;


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


        Log.d("onResume", "data=" + myDataModels.size() + "title" + title);

        fragOneRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapterFragmentOne = new RecyclerViewAdapter(getContext(), myDataModels);
        fragOneRecyclerView.setAdapter(adapterFragmentOne);
        adapterFragmentOne.notifyDataSetChanged();
    }
}
