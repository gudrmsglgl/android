package com.example.gimhyeong_geun.hw2_2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
/*
* name: 201003011_김형근
* date: 2016.06.10(금)
* email:gudrmsglgl@naver.com
*
* 느낀점 : SimpleCursorAdaptor 를 처음 사용하여 조금 어려웠지만 2_1 문제를 해결했더니 금방 풀렸다.
* 다만 교수님 pdf 파일에 ListView에 대한 XML 레이아웃 파일을 따로 만들고 그 레이아웃 안에 있는 TextView id 값을
* int[] to  부분에 넣어야 하는데 그 설명이 없어 오류인지 알고 시간이 조금 걸렸습니다.
*
* */
public class MainActivity extends AppCompatActivity {

    //info: 메인 액티비티
    //descritpion : 영화 평점을 등록 시 버튼 클릭 , 평가한 항목 디비에서 불러와 ListView에 보여주기.

    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private static final String TABLE_NAME = "movie";
    private Button addBtn;

    //리스트 뷰
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //디비 연결
        dbHelper = new DBHelper(this);
        try{
            db = dbHelper.getWritableDatabase();
        }catch (SQLiteException e){
            e.printStackTrace();
            finish();
        }

        //Cursor 객체 추출
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        cursor.moveToFirst();
        startManagingCursor(cursor);

        //가져올 컬럼명
        String[] from ={"movie_name","movie_rating"};

        //ListView TextView id 값.
        int[] to = {R.id.movie_name,R.id.movie_rating};

        //(해당객체,리스트 뷰 레이아웃, 커서 객체, 컬럼명, 컬럼을 어떻게 보여줄 것인지 id값 넣기)
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,R.layout.movie_list, cursor, from, to);

        //리스트뷰와 커서어뎁터 연결.
        list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        addBtn = (Button)findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RatingActivity.class);
                startActivity(intent);
            }
        });
    }
}
