package com.example.gimhyeong_geun.lab_assignment2_201003011;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Lab2_2 extends AppCompatActivity {
    /*
       이름 : 김형근
       학번 : 201003011
       이메일: gudrmsglgl@naver.com
       Date: 2016.04.01
      * */

    private int result=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_2);
    }

    //Radio_btn Clicked
    public void onRadioClicked(View view){
        //editText value call
        EditText editText = (EditText)findViewById(R.id.editText);
        //editText value parsing
        String str_num = editText.getText().toString();
        int num = Integer.parseInt(str_num);

        //Radio_btn select_check
        boolean checked=((RadioButton) view).isChecked();
        switch(view.getId()){
            case R.id.radioButton:
                if(checked){
                    Toast.makeText(getApplicationContext(),((RadioButton)view).getText(),Toast.LENGTH_LONG).show();
                    result = 0;
                    for(int i=1; i<=num; i++){
                        result+=i;
                    }
                    break;
                }
            case R.id.radioButton2:
                if (checked) {
                    Toast.makeText(getApplicationContext(),((RadioButton)view).getText(),Toast.LENGTH_LONG).show();
                    result=1;
                    for(int i=1; i<=num; i++){
                        result*=i;
                    }
                    break;
                }
        }

    }

    //result_val btn_Clicked
    public void onButton4Clicked(View v){
        //result_val show()
        TextView result_val = (TextView)findViewById(R.id.textView8);
        Toast.makeText(getApplicationContext(),"value:"+result,Toast.LENGTH_LONG).show();
        result_val.setText(Integer.toString(result));
    }
}
