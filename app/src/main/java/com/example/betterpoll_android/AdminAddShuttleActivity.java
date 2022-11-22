package com.example.betterpoll_android;



import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.example.betterpoll_android.databinding.ActivityMainBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AdminAddShuttleActivity extends AppCompatActivity {

    EditText editTextTripName,editTextBusNumber;
    Button addShuttle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_new_shuttle);

        editTextBusNumber=findViewById(R.id.editTextBusNumber);
        editTextTripName=findViewById(R.id.editTextTripName);
        addShuttle=findViewById(R.id.btnAddShuttle);

        addShuttle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do something when the btn is clicked

                addShuttleApi(editTextTripName.getText().toString(),editTextBusNumber.getText().toString());
                Toast.makeText(AdminAddShuttleActivity.this, "Submitted", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addShuttleApi(String tripName,String busNumber) {
        // url to post our data
        String url = "http://10.0.2.2:3000/admin/add-shuttle";

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(AdminAddShuttleActivity.this);

        // on below line we are calling a string
        // request method to post the data to our API
        // in this we are calling a post method.

        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                // if we are here then api is working
                Toast.makeText(AdminAddShuttleActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();
                try {
                    // on below line we are parsing the response
                    // to json object to extract data from it.
                    JSONObject respObj = new JSONObject(response);


                    boolean success=respObj.getBoolean("success");

                    if(success){
                        //if response then we tell admin that user is saved
                        Toast.makeText(AdminAddShuttleActivity.this,"shuttle Added !",Toast.LENGTH_LONG).show();

                    }
                    else{
                        Toast.makeText(AdminAddShuttleActivity.this,"Failed to add shuttle error response from api !",Toast.LENGTH_SHORT).show();

                    }
                } catch (JSONException e) {

                    Toast.makeText(AdminAddShuttleActivity.this,"Some error occured",Toast.LENGTH_LONG).show();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(AdminAddShuttleActivity.this, "FAILED TO GET API RESPONSE", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // below line we are creating a map for
                // storing our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our key
                // and value pair to our parameters.
                params.put("busNumber", busNumber);
                params.put("trip",tripName);


                // at last we are
                // returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);

    }

}

