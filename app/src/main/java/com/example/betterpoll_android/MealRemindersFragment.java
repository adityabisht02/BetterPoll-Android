package com.example.betterpoll_android;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.betterpoll_android.databinding.FragmentInteractionSectionBinding;
import com.example.betterpoll_android.databinding.FragmentMealRemindersBinding;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;


public class MealRemindersFragment extends Fragment {
    private FragmentMealRemindersBinding fragmentMealRemindersBinding;
    SharedPreferences sharedPreferences;
    TextView breakfastCodeTextView;
    TextView lunchCodeTextView;
    TextView snacksCodeTextView;
    TextView dinnerCodeTextView;
    TextView breakfastMenuTextView,lunchMenuTextView,snacksMenuTextView,dinnerMenuTextView;

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

        return root;
        //return inflater.inflate(R.layout.fragment_video, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        breakfastCodeTextView=view.findViewById(R.id.breakfastCode);
        lunchCodeTextView=view.findViewById(R.id.lunchCode);
        snacksCodeTextView=view.findViewById(R.id.snacksCode);
        dinnerCodeTextView=view.findViewById(R.id.dinnerCode);

        breakfastMenuTextView=view.findViewById(R.id.textViewBreakfastMenu);
        lunchMenuTextView=view.findViewById(R.id.textViewLunchMenu);
        snacksMenuTextView=view.findViewById(R.id.textViewSnacksMenu);
        dinnerMenuTextView=view.findViewById(R.id.textViewDinnerMenu);



        //get mess codes
        getMessCodes();
        //get menu
        getMessMenu();
    }

    private void getMessCodes(){
          sharedPreferences= this.getActivity().getSharedPreferences("saveUserData", Context.MODE_PRIVATE);;
        int id = sharedPreferences.getInt("id", -1);
        //if id could not be retrieved it will be -1
        if(id==-1) {
            Toast.makeText(getContext(), "Mess Codes not available !!", Toast.LENGTH_LONG).show();
        }
        //set the codes equal to the id
        breakfastCodeTextView.setText(id+"");
        lunchCodeTextView.setText(id+"");
        snacksCodeTextView.setText(id+"");
        dinnerCodeTextView.setText(id+"");


    }

    //api call for menus
    public void getMessMenu() {
        // url to post our data
        String url = "http://10.0.2.2:3000/view-mess-details";

        RequestQueue queue = Volley.newRequestQueue(getContext());
// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject respObj = new JSONObject(response);

                            String breakfast = respObj.getString("breakFastMenu");
                            String lunch=respObj.getString("lunchMenu");
                            String snacks=respObj.getString("snacksMenu");
                            String dinner=respObj.getString("dinnerMenu");

                            //setting views of menus
                            breakfastMenuTextView.setText(breakfast);
                            lunchMenuTextView.setText(lunch);
                            snacksMenuTextView.setText(snacks);
                            dinnerMenuTextView.setText(dinner);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"Error response !!",Toast.LENGTH_LONG).show();
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);



    }
}