package com.example.gimhyeong_geun.lab4_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    //info: 치킨 주문 앱.
    //description: 주문 버튼 눌렀을 경우 메뉴 선택하는 화면.



    //아이탬 리스트 컨테이너 ArrayList
    ArrayList<String> Items;

    //아이템 리스트를 받을 어뎁터.
    ArrayAdapter<String>Adapter;

    //리스트 뷰
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);
        //아이탬 추가
        Items = new ArrayList<String>();
        Items.add("양념치킨");
        Items.add("후라이드");
        Items.add("양념반 후라이드반");
        Items.add("순살치킨");
        Items.add("순살양념치킨");
        Items.add("마늘치킨");

        //어뎁터 생성
         Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,Items);

        list = (ListView)findViewById(R.id.list);
        //어뎁터 리스트 연결
        list.setAdapter(Adapter);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }


    //클릭.
    public void oOnClick(View view){
        switch(view.getId()){
            //주문
            case R.id.order:
                SparseBooleanArray items_booleans = list.getCheckedItemPositions();
                //아이탬이 선택된 것이 없을 경우.
                if(items_booleans.size()==0){
                    Toast.makeText(getApplicationContext(),"음식을 선택하세요.",Toast.LENGTH_LONG).show();
                }
                else{
                StringBuilder food_sb = new StringBuilder();
                for(int i=0; i< Items.size(); i++){
                    if(items_booleans.get(i)){
                        food_sb.append(Items.get(i)+" ");
                    }
                }
                //다음 화면으로 전환 및 값 전달 객체 intent 생성.
                Intent intent = new Intent(OrderActivity.this,ResultActivity.class);
                intent.putExtra("food", (Serializable) food_sb);
                startActivity(intent);
                }
                break;

            //취소버튼 누를 시
            case R.id.cancel:
                finish();
                break;
        }

    }
}
