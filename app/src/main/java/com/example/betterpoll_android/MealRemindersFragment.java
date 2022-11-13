package com.example.betterpoll_android;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.betterpoll_android.databinding.FragmentInteractionSectionBinding;
import com.example.betterpoll_android.databinding.FragmentMealRemindersBinding;



public class MealRemindersFragment extends Fragment {
    private FragmentMealRemindersBinding fragmentMealRemindersBinding;
    SharedPreferences sharedPreferences;
    TextView breakfastCodeTextView;
    TextView lunchCodeTextView;
    TextView snacksCodeTextView;
    TextView dinnerCodeTextView;

    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        fragmentMealRemindersBinding = FragmentMealRemindersBinding.inflate(inflater, container, false);
        View root = fragmentMealRemindersBinding.getRoot();
        breakfastCodeTextView=root.findViewById(R.id.breakfastCode);
        lunchCodeTextView=root.findViewById(R.id.lunchCode);
        snacksCodeTextView=root.findViewById(R.id.snacksCode);
        dinnerCodeTextView=root.findViewById(R.id.dinnerCode);
        //get mess codes
        getMessCodes();
        System.out.println(breakfastCodeTextView.getText());
        return root;
        //return inflater.inflate(R.layout.fragment_video, container, false);
    }

    private void getMessCodes(){
          sharedPreferences= this.getActivity().getSharedPreferences("saveUserData", Context.MODE_PRIVATE);;
        int id = sharedPreferences.getInt("id", -1);
        //if id could not be retrived it will be -1
        if(id==-1) {
            Toast.makeText(getContext(), "Mess Codes not available !!", Toast.LENGTH_LONG).show();
        }
        //set the codes equal to the id
        breakfastCodeTextView.setText(id+"");
        lunchCodeTextView.setText(id+"");
        snacksCodeTextView.setText(id+"");
        dinnerCodeTextView.setText(id+"");


    }
}