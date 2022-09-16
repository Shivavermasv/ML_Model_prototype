package com.example.irispredictor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView sepal_len;
    private EditText inp_sepal_len;
    private TextView petal_len;
    private EditText inp_petal_len;
    private TextView sepal_width;
    private EditText inp_sepal_width;
    private TextView petal_width;
    private EditText inp_petal_width;
    private Button submit;
    Intent intent;
    String url = " http://ec2-3-88-224-68.compute-1.amazonaws.com:8080/predict ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(MainActivity.this, "HI THIS IS PROTOTYPE", Toast.LENGTH_SHORT).show();
        sepal_len=findViewById(R.id.sl);
        inp_sepal_len=findViewById(R.id.inp_sl);
        petal_len=findViewById(R.id.pl);
        inp_petal_len=findViewById(R.id.inp_pl);
        sepal_width=findViewById(R.id.sw);
        inp_sepal_width=findViewById(R.id.inp_sw);
        petal_width=findViewById(R.id.pw);
        inp_petal_width=findViewById(R.id.inp_pw);
        submit=findViewById(R.id.submit);
        intent=new Intent(this,Result.class);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inp_sepal_len.getText().toString().equals("") || inp_petal_len.getText().toString().equals("") || inp_petal_width.getText().toString().equals("") || inp_sepal_width.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "FILL ALL THE VALUES !!", Toast.LENGTH_SHORT).show();
                }
                else{
                    StringRequest stringrequest =new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    //result.setText(response);
                                    intent.putExtra("result",response.toString());
                                    startActivity(intent);
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(MainActivity.this, error.getMessage()+" ", Toast.LENGTH_SHORT).show();
                                    Log.d("mytag",error.getMessage()+" 00 ");
                                }
                            }){
                        @Override
                        protected Map<String,String> getParams(){
                            Map<String,String> param=new HashMap<String,String>();
                            param.put("sepal_len",(inp_sepal_len.getText().toString()));
                            param.put("petal_len",inp_petal_len.getText().toString());
                            param.put("sepal_wid",inp_sepal_width.getText().toString());
                            param.put("petal_wid",inp_petal_width.getText().toString());
                            return param;
                        }

                    };
                    RequestQueue queue= Volley.newRequestQueue(MainActivity.this);
                    queue.add(stringrequest);

                }
            }
        });

    }
}