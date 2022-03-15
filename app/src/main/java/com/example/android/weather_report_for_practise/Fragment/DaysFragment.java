package com.example.android.weather_report_for_practise.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.android.weather_report_for_practise.DataModel.Day;
import com.example.android.weather_report_for_practise.R;
import com.example.android.weather_report_for_practise.RecyclerView.DaysListRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class DaysFragment extends Fragment {
    private List<Day> daysInfoList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DaysListRecyclerViewAdapter recyclerAdapter;

    public static DaysFragment constructDaysFragment(List<Day> daysList){
        DaysFragment daysFragment = new DaysFragment();
        Bundle bundle3 = new Bundle();
        bundle3.putParcelableArrayList("daysInfoList", new ArrayList<>(daysList));
        daysFragment.setArguments(bundle3);
        return daysFragment;
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle bundle ) {
        View rootView = inflater.inflate(R.layout.fragment_days, container, false);
        daysInfoList = requireArguments().getParcelableArrayList("daysInfoList");
        recyclerView = rootView.findViewById(R.id.recyclerview_days);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        recyclerAdapter = new DaysListRecyclerViewAdapter(rootView.getContext(),daysInfoList);
        recyclerView.setAdapter(recyclerAdapter);
        return rootView;
    }

}
