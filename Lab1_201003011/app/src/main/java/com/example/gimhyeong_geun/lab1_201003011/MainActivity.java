package com.example.gimhyeong_geun.lab1_201003011;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button_Inflation
       Button button = (Button)findViewById(R.id.button);
       button.setOnClickListener(new View.OnClickListener(){
          public void onClick(View v){
              Toast.makeText(getApplicationContext(),"랩1_2로 넘어갑니다.", Toast.LENGTH_LONG).show();
              Intent intent = new Intent(MainActivity.this,activity_Lab1_2.class);
              startActivity(intent);
          }
       });
    }




}
