package com.example.irispredictor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Result extends AppCompatActivity {
Intent intent;
private TextView result;
String url = " http://ec2-3-88-224-68.compute-1.amazonaws.com:8080/predict ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        intent=getIntent();
        result=findViewById(R.id.result);
        StringRequest stringrequest =new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        result.setText(response);
                        Log.d("mytag",result.getText().toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Result.this, error.getMessage()+" ", Toast.LENGTH_SHORT).show();
                        Log.d("mytag",error.getMessage()+" 00 ");
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> param=new HashMap<String,String>();
                param.put("sepal_len",(intent.getStringExtra("sepal_len")));
                param.put("petal_len",(intent.getStringExtra("petal_len")));
                param.put("sepal_wid",(intent.getStringExtra("sepal_width")));
                param.put("petal_wid",(intent.getStringExtra("petal_width")));
                Log.d("mytag",(intent.getStringExtra("sepal_len")));
                Log.d("mytag",(intent.getStringExtra("petal_len")));
                Log.d("mytag",(intent.getStringExtra("sepal_width")));
                Log.d("mytag",(intent.getStringExtra("petal_width")));
                return param;
            }

        };
        RequestQueue queue= Volley.newRequestQueue(Result.this);
        queue.add(stringrequest);

    }
}