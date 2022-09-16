package com.example.irispredictor;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class Result extends AppCompatActivity {
Intent intent;
private TextView result;
private ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        intent=getIntent();
        result=findViewById(R.id.result);
        layout=(ConstraintLayout) findViewById(R.id.bg);
        String res=intent.getStringExtra("result").replace("\"", "");
        Log.d("mytag",res);
        if(res==("Iris-setosa")){
            layout.setBackgroundResource(R.drawable.irissetosa);
            Log.d("mytag","done");
        }
        Log.d("mytag","out");
        result.setText(intent.getStringExtra("result"));
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        result.setText("");
        this.finish();
    }
}