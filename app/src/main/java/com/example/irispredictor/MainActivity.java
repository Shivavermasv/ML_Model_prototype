package com.example.irispredictor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "HI THIS IS PROTOTYPE", Toast.LENGTH_SHORT).show();
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
                    try{
                        Float.parseFloat(inp_sepal_len.toString());
                        Float.parseFloat(inp_sepal_width.toString());
                        Float.parseFloat(inp_petal_len.toString());
                        Float.parseFloat(inp_petal_width.toString());
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "ENTER VALID VALUES", Toast.LENGTH_SHORT).show();
                    }
                    intent.putExtra("sepal_len",inp_sepal_len.getText().toString());
                    intent.putExtra("sepal_width",inp_sepal_width.getText().toString());
                    intent.putExtra("petal_len",inp_petal_len.getText().toString());
                    intent.putExtra("petal_width",inp_petal_width.getText().toString());
                    startActivity(intent);
                }
            }
        });

    }
}