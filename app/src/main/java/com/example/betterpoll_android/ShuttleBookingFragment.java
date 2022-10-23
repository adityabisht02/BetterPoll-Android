package com.example.betterpoll_android;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.betterpoll_android.databinding.FragmentShuttleBookingListBinding;


public class ShuttleBookingFragment extends Fragment {
    private FragmentShuttleBookingListBinding fragmentShuttleBookingListBinding;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        fragmentShuttleBookingListBinding= FragmentShuttleBookingListBinding.inflate(inflater, container, false);
        View root =fragmentShuttleBookingListBinding.getRoot();


        return root;
        //return inflater.inflate(R.layout.fragment_video, container, false);
    }
}