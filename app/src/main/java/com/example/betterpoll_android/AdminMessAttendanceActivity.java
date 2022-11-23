package com.example.betterpoll_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AdminMessAttendanceActivity extends AppCompatActivity {


    Button btnSubmitCode;
    EditText editTextAttendance;
    TextView apiResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_mess_attendance);

        btnSubmitCode=findViewById(R.id.btnMessAttendance);
        editTextAttendance=findViewById(R.id.editTextAttendanceCode);
        apiResult=findViewById(R.id.textViewMessApiResult);

        btnSubmitCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do something when the corky is clicked
                addMessAttendance(editTextAttendance.getText().toString());

                Toast.makeText(AdminMessAttendanceActivity.this, "Submitted", Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void addMessAttendance(String code) {
        // url to post our data
        String url = "http://10.0.2.2:3000/admin/log-attendance";

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(AdminMessAttendanceActivity.this);

        // on below line we are calling a string
        // request method to post the data to our API
        // in this we are calling a post method.

        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                // if we are here then api is working
                Toast.makeText(AdminMessAttendanceActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();
                try {
                    // on below line we are parsing the response
                    // to json object to extract data from it.
                    JSONObject respObj = new JSONObject(response);


                    boolean success=respObj.getBoolean("success");
                    String message=respObj.getString("msg");

                    if(success){
                        //if response then we tell admin that user is saved
                        Toast.makeText(AdminMessAttendanceActivity.this,"shuttle Added !",Toast.LENGTH_LONG).show();
                        apiResult.setText(message);

                    }
                    else{
                        Toast.makeText(AdminMessAttendanceActivity.this,"Failed to log attendance error response from api !",Toast.LENGTH_SHORT).show();
                        apiResult.setText(message);
                    }
                } catch (JSONException e) {

                    Toast.makeText(AdminMessAttendanceActivity.this,"Some error occured",Toast.LENGTH_LONG).show();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(AdminMessAttendanceActivity.this, "FAILED TO GET API RESPONSE", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // below line we are creating a map for
                // storing our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our key
                // and value pair to our parameters.
                params.put("code", code);



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

