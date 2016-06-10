package com.example.gimhyeong_geun.homework_2;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.ProgressDialog;
/*
* Date: 2016.06.06
* name: 201003011_김형근
* e-mail:gudrmsglgl@naver.com
*
* */


/*
* 느낀점 : 안드로이드 DB를 처음 사용해보는데 메소드들이 다양해서 처음 쿼리문을 작성했을 때 insert into ~~~ 하였는데 계속 오류가 나서
* ContentValues 객체를 이용하여 db를 insert 하였습니다.
*
* 그리고 입력 아이디&비번 값과 DB에 저장되어 있는 아이디 비번값을 비교하는 부분에서 계속 오류가 났습니다
* 컬럼명이 존재하지 않다는 오류였는데
* 해결 방안은 DATABASE_VERSION 을 수정하여 재실행 하였더니 insert 부분이 입력되고 정확하게 비교가 되었습니다.
*
* 결론
* 커리 값을 String으로 적다보니 문법 오류와(띄어쓰기) 테이블 수정에 따른 DATABASE_VERSION 수정 문제로 시간을 많이 투자해서 해결했습니다.
* ##############보다 전문적인 로그인 화면을 구현하기 위해 ProgressDialog를 사용했습니다###################
* */




public class MainActivity extends AppCompatActivity {

    //info: 로그인 회원가입 화면
    //description: 회원 가입과 로그인 버튼이 나뉘어져 있는 메인화면, 로그인 시 ProgressDialog (AsyncTask<>)사용.

    private String user_id;
    private String user_pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login_btn = (Button)findViewById(R.id.login_btn);
        Button regist_btn = (Button)findViewById(R.id.regist_btn);


        regist_btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, joinActivity.class);
                startActivity(intent);
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                CheckTypesTask task = new CheckTypesTask();
                task.execute();

                EditText edit_id = (EditText) findViewById(R.id.idetxt);
                EditText edit_pwd = (EditText) findViewById(R.id.pwdetxt);
                user_id = edit_id.getText().toString();
                user_pwd = edit_pwd.getText().toString();



            }
        });
    }

    //Login_ProgressDialog
    private class CheckTypesTask extends AsyncTask<Void, Void, Void>{

        ProgressDialog asyncDialog = new ProgressDialog(MainActivity.this);

        @Override
        protected void onPreExecute(){
            asyncDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            asyncDialog.setMessage("로그인 로딩중입니다.");

            //show dialog
            asyncDialog.show();
            super.onPreExecute();

        }
        @Override
        protected Void doInBackground(Void... arg0){
            try{
                for(int i=0; i<5; i++){
                    //asyncDialog.setProgress(i*30);
                    Thread.sleep(600);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result){
            asyncDialog.dismiss();
            super.onPreExecute();
            if (user_id.equals("") && user_pwd.equals("")) {
                Toast.makeText(getApplicationContext(), "아이디와 비밀번호를 입력하세요.", Toast.LENGTH_LONG).show();
            } else if (user_id.equals("")) {
                Toast.makeText(getApplicationContext(), "아이디를 입력하세요.", Toast.LENGTH_LONG).show();
            } else if (user_pwd.equals("")) {
                Toast.makeText(getApplicationContext(), "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
            }
            Intent intent = new Intent(MainActivity.this, infoActivity.class);
            intent.putExtra("user_id", user_id);
            intent.putExtra("user_pwd", user_pwd);

            startActivity(intent);
        }

    }


}
