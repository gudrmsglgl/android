package com.example.gimhyeong_geun.lab4_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/*
* Date: 2016.05.21
* name: 201003011_김형근
* E-mail: gudrmsglgl@naver.com
*
* */
public class MainActivity extends AppCompatActivity {

    //info: 치킨 주문 앱.
    //description: 주문과 상점정보를 클릭할 수 있는 메인화면.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    //주문했을 경우.
    public void onOrderClicked(View view){
        Intent intent = new Intent(MainActivity.this,OrderActivity.class);
        startActivity(intent);
    }
    //상점정보
    public void onShopInfoClicked(View view){
        Intent intent = new Intent(MainActivity.this,InfoActivity.class);
        startActivity(intent);
    }
}
