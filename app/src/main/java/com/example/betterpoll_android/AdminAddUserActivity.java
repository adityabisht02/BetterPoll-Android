package com.example.betterpoll_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AdminAddUserActivity extends AppCompatActivity {


    EditText editTextName,editTextEmail,editTextPhone;
    Button submit;
    String email,name,phoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_new_user);
        editTextEmail=findViewById(R.id.editTextEmail);
        editTextPhone=findViewById(R.id.editTextPhoneNumber);
        editTextName=findViewById(R.id.editTextUserName);
        submit=findViewById(R.id.buttonAddUser);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do something when the corky is clicked
                email=editTextEmail.getText().toString();
                name=editTextName.getText().toString();
                phoneNumber=editTextPhone.getText().toString();
                addUserApi(name,email,phoneNumber);
            }
        });

    }

    private void addUserApi(String name,String email,String phone) {
        // url to post our data
        String url = "http://10.0.2.2:3000/admin/add-new-user";

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(AdminAddUserActivity.this);

        // on below line we are calling a string
        // request method to post the data to our API
        // in this we are calling a post method.

        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                // if we are here then api is working
                Toast.makeText(AdminAddUserActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();
                try {
                    // on below line we are parsing the response
                    // to json object to extract data from it.
                    JSONObject respObj = new JSONObject(response);


                    boolean success=respObj.getBoolean("success");

                    if(success){
                        //if response then we tell admin that user is saved
                        Toast.makeText(AdminAddUserActivity.this,"Authentication failed !",Toast.LENGTH_LONG).show();

                    }
                    else{
                        Toast.makeText(AdminAddUserActivity.this,"Authentication failed !",Toast.LENGTH_SHORT).show();

                    }
                } catch (JSONException e) {

                    Toast.makeText(AdminAddUserActivity.this,"Some error occured",Toast.LENGTH_LONG).show();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(AdminAddUserActivity.this, "FAILED TO GET API RESPONSE", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // below line we are creating a map for
                // storing our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our key
                // and value pair to our parameters.
                params.put("email", email);
                params.put("name", name);
                params.put("phone", phone);


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


