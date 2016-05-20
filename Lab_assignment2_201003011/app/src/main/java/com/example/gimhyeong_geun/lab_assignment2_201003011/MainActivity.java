package com.example.gimhyeong_geun.lab_assignment2_201003011;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*
     이름 : 김형근
     학번 : 201003011
     이메일: gudrmsglgl@naver.com
     Date: 2016.04.01
    * */


    TextView name_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //버튼 불러옴
        Button confirm_btn = (Button)findViewById(R.id.button);
        name_text = (TextView)findViewById(R.id.textView);
        confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //이름 메세지 알림
                Toast.makeText(getApplicationContext(),"안녕하세요! "+name_text.getText()+"님",Toast.LENGTH_LONG).show();
            }
        });
    }

    //2_2 과제로 액티비티 이동
    public void onButton2Clicked(View v){
        Toast.makeText(getApplicationContext(),"Lab_2_2로 넘어갑니다.",Toast.LENGTH_LONG).show();
        Intent intent2 = new Intent(this, Lab2_2.class);
        startActivity(intent2);

    }

    //2_3 과제로 액티비티 이동
    public void onButton3Clicked(View v){
        Toast.makeText(getApplicationContext(),"Lab_2_3로 넘어갑니다.",Toast.LENGTH_LONG).show();
        Intent intent3 = new Intent(this, Lab2_3.class);
        startActivity(intent3);
    }


}
