package com.example.android.weather_report_for_practise.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.weather_report_for_practise.DataModel.Day;
import com.example.android.weather_report_for_practise.R;

import java.util.List;

public class DaysListRecyclerViewAdapter extends RecyclerView.Adapter<DaysListViewHolder> {
    private final Context context;
    private final List<Day> itemList;

    public DaysListRecyclerViewAdapter(Context context, List<Day> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public DaysListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DaysListViewHolder
                (LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.list_item_daily, parent, false));
    }

    @Override
    public void onBindViewHolder(DaysListViewHolder holder, int position) {
        holder.bindData(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
