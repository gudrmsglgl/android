package com.example.gimhyeong_geun.homework_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//info: 회원가입 페이지
//description: 디비를 연결하여 입력한 값을 테이블에 insert함.

class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "myStudent.db";
    private static final int DATABASE_VERSION=2;

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE Student (_id INTEGER PRIMARY KEY " +
                "AUTOINCREMENT, id TEXT, password TEXT, name TEXT, stu_num INTEGER);");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS Student");
        onCreate(db); //다시 테이블 생성
    }

}

public class joinActivity extends AppCompatActivity {

    //테이블명
    private static final String TABLE_NAME = "Student";

    private DBHelper helper;
    private SQLiteDatabase db;

    EditText idEdit;
    EditText pwdEdit;
    EditText nameEdit;
    EditText stuNumEdit;

    Button regist_btn;
    Button cancel_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);

        idEdit = (EditText)findViewById(R.id.idEdit);
        pwdEdit = (EditText)findViewById(R.id.pwdEdit);
        nameEdit = (EditText)findViewById(R.id.nameEdit);
        stuNumEdit = (EditText)findViewById(R.id.stu_numEdit);

        regist_btn = (Button)findViewById(R.id.regist_btn);
        cancel_btn = (Button)findViewById(R.id.cancel_btn);

        //디비 연결
       helper = new DBHelper(this);
           try {
               db = helper.getWritableDatabase();
           } catch (SQLiteException e){
               Log.e("db", "데이터베이스를 열수 없음");
               finish();
           }

        //회원가입 버튼 클릭시
        regist_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("regist", "버튼 들어옴");

                String id = idEdit.getText().toString();
                String password = pwdEdit.getText().toString();
                String name = nameEdit.getText().toString();
                String stu_num = stuNumEdit.getText().toString();
                int stuNum=Integer.parseInt(stu_num);
                if(id.equals("")||password.equals("")||name.equals("")||stu_num.equals("")){
                    Log.e("regist", "회원가입 실패 if문");
                    Toast.makeText(joinActivity.this, "회원가입에 실패했습니다. 빠짐없이 입력해주세요.", Toast.LENGTH_LONG).show();
                    return; //그냥 빠져나감
                }
                Log.e("regist", "insert문 실행");

                //DB_insert
                insert(id, password,name,stuNum);
            }
        });

        //취소버튼 클릭 시
        cancel_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getApplicationContext(),"이전 화면으로 돌아갑니다.",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

    public void insert(String id, String password, String name, int stu_num){
        Log.e("regist", "insert문 들어옴");
        ContentValues values = new ContentValues();
        values.put("id",id);
        values.put("password",password);
        values.put("name",name);
        values.put("stu_num",stu_num);
        db.insert(TABLE_NAME,null,values);
       // db.execSQL("INSERT INTO Student (_id, id, password, name, student_num) VALUES (null, '" + id + "', '" + password + "', '" + name + "', '" + stu_num + "');");
        Log.e("regist", "insert into 쿼리 실행됨");
        Toast.makeText(getApplicationContext(),"회원가입에 성공했습니다.",Toast.LENGTH_LONG).show();

      //빈칸으로 셋팅
        idEdit.setText("");
        pwdEdit.setText("");
        nameEdit.setText("");
        stuNumEdit.setText("");
    }



}
