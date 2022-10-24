package com.example.betterpoll_android;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.betterpoll_android.databinding.FragmentAvailableShuttlesBinding;

import java.util.ArrayList;


public class AvailableShuttlesFragment extends Fragment {
    private FragmentAvailableShuttlesBinding availableShuttlesFragment;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        availableShuttlesFragment = FragmentAvailableShuttlesBinding.inflate(inflater, container, false);
        View root = availableShuttlesFragment.getRoot();
        RecyclerView shuttleRV = root.findViewById(R.id.idRVCourse);

        // Here, we have created new array list and added data to it
        ArrayList<ShuttleModel> shuttleModelArrayList = new ArrayList<ShuttleModel>();
        shuttleModelArrayList.add(new ShuttleModel("Campus to IFFCO Chowk",  R.drawable.ic_baseline_directions_bus_24));
        shuttleModelArrayList.add(new ShuttleModel("IFFCO Chowk to Campus",  R.drawable.ic_baseline_directions_bus_24));
        shuttleModelArrayList.add(new ShuttleModel("Campus to KashMere Gate",  R.drawable.ic_baseline_directions_bus_24));


        ShuttleAdapter shuttleAdapter = new ShuttleAdapter(getContext(), shuttleModelArrayList);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);


        shuttleRV.setLayoutManager(linearLayoutManager);
        shuttleRV.setAdapter(shuttleAdapter);

        return root;

    }
}