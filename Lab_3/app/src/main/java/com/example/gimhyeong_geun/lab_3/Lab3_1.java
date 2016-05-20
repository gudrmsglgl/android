package com.example.gimhyeong_geun.lab_3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

/*
 name: 201003011_김형근
 e-mail: gudrmsglgl@naver.com
 date: 2016.04.09
 */


public class Lab3_1 extends AppCompatActivity {

    //성과 취미 전역 변수
    private String sex = "";
    private String[] hobbys = {"","",""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_1);

        Button btn=(Button)findViewById(R.id.button);
        //무명 클래스 버튼 이벤트
        if (btn != null) {
            btn.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    EditText input_id = (EditText)findViewById(R.id.editText);
                    String id = (String)input_id.getText().toString();
                    TextView str_result=(TextView)findViewById(R.id.textView6);
                    str_result.setText(id+"님의 성별은 "+sex+"이고"+"\n"+"취미는 "+hobbys[0]+" "+hobbys[1]+" "+hobbys[2]);
                }
            });
        }
    }
    //체크 박스 이벤트
    public void onCheckboxClicked(View view){

        boolean checked = ((CheckBox)view).isChecked();
        CheckBox hobby1 = (CheckBox)findViewById(R.id.checkBox);
        CheckBox hobby2 = (CheckBox)findViewById(R.id.checkBox2);
        CheckBox hobby3 = (CheckBox)findViewById(R.id.checkBox3);
        switch (view.getId()){
            case R.id.checkBox:
                if(checked){
                    hobbys[0]=(String)hobby1.getText();
                    break;
                }else{
                    hobbys[0]="";
                    break;
                }
            case R.id.checkBox2:
                if(checked){
                    hobbys[1]=(String)hobby2.getText();
                    break;
                }else{
                    hobbys[1]="";
                    break;
                }
            case R.id.checkBox3:
                if(checked){
                    hobbys[2]=(String)hobby3.getText();
                    break;
                }else{
                    hobbys[2]="";
                    break;
                }

        }

    }


    //성 레디오 버튼 이벤트
    public void onRadioBtnClicked(View view) {

        //Radio btn select_check
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radioButton:
                if (checked) {
                    RadioButton radioBtn_1 = (RadioButton) findViewById(R.id.radioButton);
                    sex = (String) radioBtn_1.getText();
                    break;
                }
            case R.id.radioButton2:
                if (checked) {
                    RadioButton radioBtn_2 = (RadioButton) findViewById(R.id.radioButton2);
                    sex = (String) radioBtn_2.getText();
                    break;
                }
        }
    }






}
