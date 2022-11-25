package com.example.betterpoll_android;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.betterpoll_android.databinding.FragmentInteractionSectionBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class InteractSectionFragment extends Fragment {
private FragmentInteractionSectionBinding fragmentInteractionSectionBinding;



     RecyclerView postRV;
     InteractSectionAdapter postAdapter;
     LinearLayoutManager postLayoutManager;
    Button sendPostBtn;
    EditText editTextPostContent;
    SharedPreferences sharedPreferences;
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        postRV=view.findViewById(R.id.idRVPost);
        sendPostBtn=view.findViewById(R.id.btnSendPost);
        editTextPostContent=view.findViewById(R.id.editTextPostContent);
        getAvailableChats();

        sendPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do something when the corky is clicked
                int id=getSharedPreferencesId();
                makePost(editTextPostContent.getText().toString(),id);

            }
        });
    }
    public int getSharedPreferencesId(){
        sharedPreferences= this.getActivity().getSharedPreferences("saveUserData", Context.MODE_PRIVATE);;
        int id = sharedPreferences.getInt("id", -1);

        return id;
    }


    public void makePost(String postContent,int id){
        // url to post our data
        String url = "http://10.0.2.2:3000/make-post";

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(getContext());

        // on below line we are calling a string
        // request method to post the data to our API
        // in this we are calling a post method.

        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                // if we are here then api is working
                Toast.makeText(getContext(), "Data added to API", Toast.LENGTH_SHORT).show();
                try {
                    // on below line we are parsing the response
                    // to json object to extract data from it.
                    JSONObject respObj = new JSONObject(response);


                    if(respObj.getBoolean("success")) {
                        editTextPostContent.setText("");
                    }


                } catch (JSONException e) {

                    Toast.makeText(getContext(),e.toString(),Toast.LENGTH_LONG).show();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(getContext(), "FAILED TO GET API RESPONSE", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // below line we are creating a map for
                // storing our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our key
                // and value pair to our parameters.
                params.put("id",id+"");
                params.put("postcontent",postContent);


                // at last we are
                // returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);

    }



    public void getAvailableChats() {
        // url to post our data
        String url = "http://10.0.2.2:3000/view-all-posts";
// Here, we have created new array list and added data to it
        ArrayList<InteractCardItem> cardItemList= new ArrayList<InteractCardItem>();

        RequestQueue queue = Volley.newRequestQueue(getContext());

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject respObj = new JSONObject(response);

                            String message = respObj.getString("msg");
                            JSONArray results=respObj.getJSONArray("results");

//                            shuttleModelArrayList.add(new ShuttleModel(message,R.drawable.ic_baseline_directions_bus_24));

                            for(int i=0;i<results.length();i++) {
                                JSONObject obj=results.getJSONObject(i);
                                String name=obj.getString("name");
                                String content=obj.getString("content");
                                String date=obj.getString("date");
                                cardItemList.add(new InteractCardItem(name,content,date ));
                            }

                            //System.out.println(shuttleModelArrayList)

                            postAdapter=new InteractSectionAdapter(getContext(),cardItemList);
                            postLayoutManager=new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                            postRV.setLayoutManager(postLayoutManager);
                            postRV.setAdapter(postAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getContext(),"Error !!",Toast.LENGTH_LONG).show();
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