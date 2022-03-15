package com.example.android.weather_report_for_practise.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.weather_report_for_practise.DataModel.Hour;
import com.example.android.weather_report_for_practise.R;

import java.util.List;

public class HourlyListRecyclerViewAdapter extends RecyclerView.Adapter<HourlyListViewHolder> {
    private final Context context;
    private final List<Hour> itemList;

    public HourlyListRecyclerViewAdapter(Context context, List<Hour> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public HourlyListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HourlyListViewHolder
                (LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.list_item_hourly, parent, false));
    }

    @Override
    public void onBindViewHolder(HourlyListViewHolder holder, int position) {
        holder.bindData(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        if (itemList != null) {
            return itemList.size();
        }
        return 0;
    }
}