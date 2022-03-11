package com.example.android.weather_report_for_practise.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.weather_report_for_practise.DataModel.Hour;
import com.example.android.weather_report_for_practise.R;

import java.util.List;

public class RecyclerViewAdapterForHourlyList extends RecyclerView.Adapter<ViewHolderForHourlyList> {
    private final Context context;
    private final List<Hour> itemList;

    public RecyclerViewAdapterForHourlyList(Context context, List<Hour> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolderForHourlyList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderForHourlyList
                (LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.list_item_hourly, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolderForHourlyList holder, int position) {
        holder.bind(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        if (itemList != null) {
            return itemList.size();
        }
        return 0;
    }
}