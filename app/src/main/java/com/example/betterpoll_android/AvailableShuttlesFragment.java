package com.example.betterpoll_android;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.betterpoll_android.databinding.FragmentAvailableShuttlesBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class AvailableShuttlesFragment extends Fragment {
    private FragmentAvailableShuttlesBinding availableShuttlesFragment;

    ArrayList<ShuttleModel> shuttleModelArrayList;
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
        shuttleModelArrayList= new ArrayList<ShuttleModel>();

        //method to add shuttles from view-shuttles api
        getAvailableShuttles();

        shuttleModelArrayList.add(new ShuttleModel("Campus to IFFCO Chowk",  R.drawable.ic_baseline_directions_bus_24));

//        Toast.makeText(getContext(),shuttleModelArrayList.get(0).getCourse_name(),Toast.LENGTH_LONG).show();

        ShuttleAdapter shuttleAdapter = new ShuttleAdapter(getContext(), shuttleModelArrayList);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);


        shuttleRV.setLayoutManager(linearLayoutManager);
        shuttleRV.setAdapter(shuttleAdapter);

        return root;

    }

     public void getAvailableShuttles() {
        // url to post our data
        String url = "http://10.0.2.2:3000/view-shuttles";

        RequestQueue queue = Volley.newRequestQueue(getContext());

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject respObj = new JSONObject(response);
                            String message = respObj.getString("msg");
//                            shuttleModelArrayList.add(new ShuttleModel(message,R.drawable.ic_baseline_directions_bus_24));
                            shuttleModelArrayList.add(new ShuttleModel("Campus to IFFCO Chowk",  R.drawable.ic_baseline_directions_bus_24));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"Error response !!",Toast.LENGTH_LONG).show();
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }
}