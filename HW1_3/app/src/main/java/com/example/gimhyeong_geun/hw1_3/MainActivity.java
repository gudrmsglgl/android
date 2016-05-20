package com.example.gimhyeong_geun.hw1_3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    /*
    * name: 201003011_김형근
    * email: gudrmsglgl@naver.com
    * date: '16.04.18(월)
    *
    * 느낀점 : 전체적인 Dialog 사용이 처음이였지만 교수님 수업 시간에 배운 것을 토대로 잘 해결하였습니다
    * 다만, AlertDialog 사용 시 없어지지 않아 구글링을 통하여 dismiss()라는 메소드를 확인 후 적용하여 선택 후 없어지게
    * 하였습니다.
    * */


    //Current_Time&Date
    private int mYear, mMonth, mDay, mHour, mMinute;

    //Reserve_Time&Date
    private int rYear, rMonth, rDay, rHour, rMinute;

    //현재 날짜 시간 셋
    private TextView txt_cur_Date;
    private TextView txt_cur_Time;

    //예약 날짜 시간 셋
    private EditText txt_res_Date;
    private EditText txt_res_Time;

    //예약 방 타입 셋
    private EditText txt_room_type;

    //방 타입 버튼
    private Button room_type_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_cur_Date = (TextView)findViewById(R.id.textView4);
        txt_cur_Time = (TextView)findViewById(R.id.textView5);

        txt_res_Date = (EditText)findViewById(R.id.editText);
        txt_res_Time = (EditText)findViewById(R.id.editText2);
        txt_room_type = (EditText)findViewById(R.id.editText3);
        room_type_btn = (Button)findViewById(R.id.button3);

        //현재 시간 불러오기.
        Calendar cal = new GregorianCalendar();
        mYear = cal.get(Calendar.YEAR);
        mMonth = cal.get(Calendar.MONTH);
        mDay = cal.get(Calendar.DAY_OF_MONTH);
        mHour = cal.get(Calendar.HOUR);
        mMinute = cal.get(Calendar.MINUTE);
        UpdateNow();
    }

    //현재시간 Update()
    void UpdateNow(){
        txt_cur_Date.setText(String.format("현재 날짜 : %d / %d / %d",mYear,mMonth+1,mDay));
        txt_cur_Time.setText(String.format("현재 시간 : %d : %d", mHour, mMinute));
    }

    //예약시간 Update()
    void reserve_Update(){
        txt_res_Date.setText(String.format("예약 날짜 : %d / %d / %d",rYear,rMonth+1,rDay));
        txt_res_Time.setText(String.format("예약 시간 : %d : %d",rHour, rMinute));

    }

    //각 버튼 클릭시 이벤트 처리
    public void onReserveBtnClicked(View view){
        switch(view.getId()){
            case R.id.button:
                new DatePickerDialog(MainActivity.this,mDateSetListener , mYear, mMonth, mDay).show();
                break;
            case R.id.button2:
                new TimePickerDialog(MainActivity.this,mTimeSetListener, rHour, rMinute, false).show();
                break;
            case R.id.button3:
                room_type_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog dialog = createDialogBox();
                        dialog.show();

                    }
                });
        }
    }

    private AlertDialog createDialogBox() {
        final CharSequence[] items = {"1인실", "2인실", "기타"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this); //AlertDialog.Builder 객체 생성
        builder.setTitle("객실 타입을 선택해 주세요."); //Dialog 제목
        //Dialog option select 경우 이벤트 처리
        builder.setSingleChoiceItems(items, -1, new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_LONG).show();
                        txt_room_type.setText(items[item]);
                        dialog.dismiss();
                    }
                });
             AlertDialog dialog = builder.create();

        return dialog;
        }


    public DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener(){

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    rYear = year;
                    rMonth = monthOfYear;
                    rDay = dayOfMonth;
                    reserve_Update();
                }
            };

    public TimePickerDialog.OnTimeSetListener mTimeSetListener =
            new TimePickerDialog.OnTimeSetListener(){

                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    rHour = hourOfDay;
                    rMinute = minute;
                    reserve_Update();
                }
            };

}
