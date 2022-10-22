package com.example.betterpoll_android;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.betterpoll_android.databinding.FragmentInteractionSectionBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class InteractionFragment extends Fragment {
private FragmentInteractionSectionBinding fragmentInteractionSectionBinding;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        fragmentInteractionSectionBinding = FragmentInteractionSectionBinding.inflate(inflater, container, false);
        View root = fragmentInteractionSectionBinding.getRoot();


        return root;
        //return inflater.inflate(R.layout.fragment_video, container, false);
    }
}