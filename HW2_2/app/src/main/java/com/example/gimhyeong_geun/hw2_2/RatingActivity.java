package com.example.gimhyeong_geun.hw2_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

            //info: 영화 점수 평가
            //description: 영화제목과 점수를 입력하여 디비에 저장함.

class DBHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME="movie.db";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE_NAME = "movie";


    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, movie_name TEXT NOT NULL, movie_rating float);");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

}


public class RatingActivity extends AppCompatActivity {

    private static final String TABLE_NAME = "movie";

    private DBHelper helper;
    private SQLiteDatabase db;

    private EditText title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating);

        //디비 연결
        helper = new DBHelper(this);
        try{
            db = helper.getWritableDatabase();
        }catch (SQLiteException e){
            e.printStackTrace();
            finish();
        }

        //save_btn
        Button saveBtn = (Button)findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                title = (EditText)findViewById(R.id.editTitle);
                String movie_title = title.getText().toString();
                RatingBar rating = (RatingBar)findViewById(R.id.ratingBar);
                float rating_num = rating.getRating();

                if(movie_title.equals("")){
                    Toast.makeText(getApplicationContext(),"영화제목을 입력해주세요.",Toast.LENGTH_LONG).show();
                    return;
                }

                movie_insert(movie_title, rating_num);
                finish();
            }
        });
    }

    //db_insert
    public void movie_insert(String movie_title, float rating_num){
        ContentValues values = new ContentValues();
        values.put("movie_name",movie_title);
        values.put("movie_rating", rating_num);
        db.insert(TABLE_NAME, null, values);
        title.setText("");
        Toast.makeText(getApplicationContext(),"평점이 성공적으로 등록 되었습니다.",Toast.LENGTH_LONG).show();
    }
}
