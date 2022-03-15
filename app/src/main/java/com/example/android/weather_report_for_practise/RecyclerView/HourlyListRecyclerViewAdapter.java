package com.example.android.weather_report_for_practise.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.android.weather_report_for_practise.DataModel.Hour;
import com.example.android.weather_report_for_practise.R;
import java.util.List;

public class HourlyListRecyclerViewAdapter extends RecyclerView.Adapter<HourlyListViewHolder> {
    private final List<Hour> itemList;

    public HourlyListRecyclerViewAdapter(List<Hour> itemList) {
        this.itemList = itemList;
    }

    @Override
    public HourlyListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
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
        return itemList.size();
    }
}