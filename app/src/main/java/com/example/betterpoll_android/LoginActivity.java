package com.example.betterpoll_android;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class LoginActivity extends AppCompatActivity {

    EditText editTextPhone;
    EditText editTextName;
    EditText editTextEmail;
    Button loginbtn;
    String name;
    String phoneNumber;
    int id;
    String email;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


//        editTextPhone=findViewById(R.id.editTextPhoneNumber);

        editTextName=findViewById(R.id.editTextName1);
        editTextEmail=findViewById(R.id.editTextEmail);
        editTextPhone=findViewById(R.id.editTextPhoneNumber);
        loginbtn=findViewById(R.id.loginbtn);

        //check if shared preferences already has the data and if it does directly login
        if(fetchUserData()!=-1){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do something when the corky is clicked
                 email=editTextEmail.getText().toString();
                 name=editTextName.getText().toString();
                 phoneNumber=editTextPhone.getText().toString();

//                for basic login without api integration
//                if(name.equals("aditya")){
//                    //put admin functions as the destination for testing
//                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
//                    startActivity(intent);
//                }
                userLoginApi(email);
            }
        });
    }


    //saves user data to shared preferences
    private void saveUserData(){
        sharedPreferences=getSharedPreferences("saveUserData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putInt("id",id);
        editor.putString("name",name);
        editor.putString("email",email);
        editor.commit();
        Toast.makeText(LoginActivity.this, "Shared preferences data saved", Toast.LENGTH_LONG).show();
    }

    //confirms if user is logged by returning the id ,if not logged in returns -1
    private int fetchUserData(){
        sharedPreferences=getSharedPreferences("saveUserData",Context.MODE_PRIVATE);
        id=sharedPreferences.getInt("id", -1);
        return id;
    }

    //this api only takes email to verify user
    private void userLoginApi(String email) {
        // url to post our data
        String url = "http://10.0.2.2:3000/login";

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);

        // on below line we are calling a string
        // request method to post the data to our API
        // in this we are calling a post method.

        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                // if we are here then api is working
                Toast.makeText(LoginActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();
                try {
                    // on below line we are parsing the response
                    // to json object to extract data from it.
                    JSONObject respObj = new JSONObject(response);

                    // if success is true means we can authenticate the user
                    boolean success=respObj.getBoolean("success");
                    id=respObj.getInt("id");

                    if(success){
                        //if response then use intent to login and save user using shared preferences
                        saveUserData();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(LoginActivity.this,"Authentication failed !",Toast.LENGTH_SHORT).show();

                    }
                } catch (JSONException e) {

                    Toast.makeText(LoginActivity.this,e.toString(),Toast.LENGTH_LONG).show();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(LoginActivity.this, "FAILED TO GET API RESPONSE", Toast.LENGTH_SHORT).show();
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