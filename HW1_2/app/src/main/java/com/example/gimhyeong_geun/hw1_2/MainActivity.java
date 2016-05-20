package com.example.gimhyeong_geun.hw1_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*
    * name : 201003011_김형근
    * date : 2016.4.17
    * email: gudrmsglgl@naver.com
    * 느낀점: 사실 이 부분은 팝업메뉴 띄우기 연습이라고만 봐도 무방 하였습니다.
    * 키 포인트는 변수값을 파싱하는 것과 팝업 메뉴 xml을 따로 생성하여 만드는 것이 핵심이었습니다
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //button click_Event
    public void onClicked(View button){

        //PopupMenu 생성
        PopupMenu popup = new PopupMenu(this, button); // 현재 화면 제어권자
        popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu()); //인플레이

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {

                //인풋1,2 불러오기
                EditText input_1 = (EditText)findViewById(R.id.editText);
                String str_1 = input_1.getText().toString();
                int num1 = Integer.parseInt(str_1);

                EditText input_2 = (EditText)findViewById(R.id.editText2);
                String str_2 = input_2.getText().toString();
                int num2 = Integer.parseInt(str_2);

                //결과값
                int result =0;

                switch (item.getItemId()) {
                    case R.id.add :
                        result = num1 + num2 ;
                        Toast.makeText(getApplicationContext(),"덧셈 결과 값:"+result,Toast.LENGTH_LONG).show();
                        break;
                    case R.id.mul :
                        result = num1 * num2;
                        Toast.makeText(getApplicationContext(),"곱셈 결과 값:"+result,Toast.LENGTH_LONG).show();
                        break;
                }
                return true;
            }
        });
        popup.show(); //메뉴 띄우기
    }
}
