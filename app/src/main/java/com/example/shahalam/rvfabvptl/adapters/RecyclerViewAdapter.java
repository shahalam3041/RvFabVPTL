package com.example.shahalam.rvfabvptl.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shahalam.rvfabvptl.R;
import com.example.shahalam.rvfabvptl.models.MyDataModel;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context mContext;
    List<MyDataModel> myDataModels;

    public RecyclerViewAdapter(Context mContext, List<MyDataModel> myDataModels) {
        this.mContext = mContext;
        this.myDataModels = myDataModels;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_recyclerview, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Log.d("onResume", "data=" + myDataModels.size() + myDataModels.get(position).getTitle());

        holder.title.setText(myDataModels.get(position).getTitle());
        holder.description.setText(myDataModels.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        Log.d("onResume", "data2=" + myDataModels.size());
        return myDataModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleInRecyclerViewSingleItem);
            description = itemView.findViewById(R.id.descriptionInRecyclerViewSingleItem);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "Clicked.", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
