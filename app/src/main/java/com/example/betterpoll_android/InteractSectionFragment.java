package com.example.betterpoll_android;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.betterpoll_android.databinding.FragmentInteractionSectionBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class InteractSectionFragment extends Fragment {
private FragmentInteractionSectionBinding fragmentInteractionSectionBinding;

     RecyclerView postrecyclerView;
     InteractSectionAdapter postAdapter;
     LinearLayoutManager postLayoutManager;
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

        postrecyclerView=root.findViewById(R.id.idRVPost);


        ArrayList<InteractCardItem> cardItemList=new ArrayList<InteractCardItem>();
        cardItemList.add(new InteractCardItem("Aditya ","24/10","Hi i am aditya nice to meet u"));
        cardItemList.add(new InteractCardItem("Nishit ","24/10","Hi i am nishit "));




        postAdapter=new InteractSectionAdapter(getContext(),cardItemList);
        postLayoutManager=new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        postrecyclerView.setLayoutManager(postLayoutManager);
        postrecyclerView.setAdapter(postAdapter);

        return root;
        //return inflater.inflate(R.layout.fragment_video, container, false);
    }
}