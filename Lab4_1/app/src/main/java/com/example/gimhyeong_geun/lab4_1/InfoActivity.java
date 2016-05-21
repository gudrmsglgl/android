package com.example.gimhyeong_geun.lab4_1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class InfoActivity extends AppCompatActivity {

    //info: 치킨 주문 앱.
    //description: 상점정보를 클릭하여 상점정보와 전화를 걸 수 있는 화면.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
    }

    //전화 버튼 눌렀을 경우.
    public void onDirectCallClicked(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:01020221149")); //내 전화번호로 파싱.
        startActivity(intent);
    }
}
