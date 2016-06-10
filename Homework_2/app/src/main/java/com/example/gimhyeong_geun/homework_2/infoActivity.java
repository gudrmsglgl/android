package com.example.gimhyeong_geun.homework_2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class infoActivity extends AppCompatActivity {

    //info: 로그인 화면
    //descritpion: 메인 화면에서 넘어오는 값을 getIntent()하여 받아와 id와 password를 디비 테이블과 비교하여 맞으면 유저 정보를 보여줌.
    //Cursor객체를 이용하여 컬럼 추출 및, SharedPreferences를 이용하여 세션 유지.

    private SQLiteDatabase db;
    private static final String TABLE_NAME = "Student";

    static final String PREFS_NAME = "LoginPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        TextView id_txt = (TextView)findViewById(R.id.idViewTxt);
        TextView name_txt = (TextView)findViewById(R.id.nameViewTxt);

        DBHelper dbHelper = new DBHelper(this);
        try{
            db = dbHelper.getWritableDatabase();
        }catch(SQLiteException e){
            Log.e("db","데이터베이스 오류");
            finish();
        }

        Intent intent = getIntent();
        String user_id =intent.getStringExtra("user_id");
        String user_pwd = intent.getStringExtra("user_pwd");

        //입력된 아이디를 조건 값으로 디비에 저장된 컬럼 가져오기
        String dbData[] = record_IdProcess(user_id);

        if(user_id.equals(dbData[0]) && user_pwd.equals(dbData[1])){
            SharedPreferences pref =
                    getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("id",user_id);
            editor.putString("password", user_pwd);
            editor.commit();

            id_txt.setText(user_id + "님 로그인되었습니다.");
            name_txt.setText("이름 : "+dbData[2]);

            Toast.makeText(getApplicationContext(), "로그인에 성공했습니다.", Toast.LENGTH_LONG).show();


        }else{
            Toast.makeText(getApplicationContext(),"아이디와 비밀번호가 일치하지 않습니다",Toast.LENGTH_LONG).show();
            finish();
        }

    }

    //Cusor 객체를 이용하여 컬럼 추출 메소드
    public String[] record_IdProcess(String inputId){
        Log.e("db", "record_IdProcess시작");
        String resultString[] = new String[3];
        String colString[] = {"id","password","name"};
        String selection = "id='"+inputId+ "'";

        Cursor c = db.query(TABLE_NAME, colString, selection, null, null, null, null);
        Log.e("db","Cursor객체 생성됨");

        if(c.getCount()>0){
            Log.e("db", "if문들어옴");

            c.moveToFirst();
            resultString[0]=c.getString(0);
            Log.e("db", "0번 스트링");
            resultString[1]=c.getString(1);
            Log.e("db", "1번 스트링");
            resultString[2]=c.getString(2);
        }
        return resultString;
    }
}
