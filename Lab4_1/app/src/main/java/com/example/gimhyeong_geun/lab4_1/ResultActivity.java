package com.example.gimhyeong_geun.lab4_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    //info: 치킨 주문 앱.
    //description: 주문 결과를 확인하는 화면.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        //값이 저장된 intent 객체 불러오기
        Intent intent = getIntent();
        //값 불러오기
        String sb = intent.getStringExtra("food");
        TextView result_str=(TextView)findViewById(R.id.result_str);

        //메뉴 선택 결과 값.
        result_str.setText(sb);
    }
}
