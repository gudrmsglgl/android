package com.example.gimhyeong_geun.hw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*
    * name : 201003011_김형근
    * e-mail : gudrmsglgl@naver.com
    * Date : 16.04.15
    * 느낀점 : 프로젝트를 했을 때 가장 많은 시간을 투자한 것 같습니다
    * 이유는 오랜만에 별 그리기 연습을 하였는데, 처음에는 for 문을 첫줄로 끝낼려고 머리를 굴렸는데
    * 파이썬이랑 혼동하여 해메다가 힘들어서 이중 for 문을 사용하였고 이후는 등차 수열인데 일반화 방법을 까먹고
    * 종이로 써보다가 일반화 식 2n-1을 찾아서 적용하여 별 모양을 완성하였습니다.
    * */

    //사용자가 선택한 모양
    String input_shape;

    Button draw_btn;
    TextView text_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        draw_btn = (Button)findViewById(R.id.button);


        //btn_Click
        draw_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //input_num Parsing
                EditText str_input = (EditText)findViewById(R.id.editText);
                String str_num = (String)str_input.getText().toString();
                int num = Integer.parseInt(str_num);

                //result_draw
                text_result = (TextView)findViewById(R.id.textView2);

                //var draw
                String draw ="";

                //Triangle or Square
                if(input_shape.equals("triangle")){
                    Toast.makeText(getApplicationContext(),num+"삼각형을 그린다.가 선택되었습니다.",Toast.LENGTH_LONG).show();

                    //갯수만큼 삼각형 그리기
                    for(int i=1; i<=num; i++){
                        //Indent for문
                        for (int k = num-i; k>=1; k--){draw +="  ";}
                        //draw for문
                        for (int j = 0; j < i+i-1; j++) {draw += "*";}
                        draw+="\n";
                    }

                    //Result_setText
                    text_result.setText(draw);
                }else if(input_shape.equals("square")) {
                    Toast.makeText(getApplicationContext(), num+"사각형을 그린다.가 선택되었습니다.", Toast.LENGTH_LONG).show();


                    //갯수만큼 사각형 그리기
                    for(int i=1; i<=num; i++){
                        for(int j=1; j<=num; j++){draw +="*";}
                        draw +="\n";
                    }

                    text_result.setText(draw);
                }else{
                    Toast.makeText(getApplicationContext(),"도형을 선택해주세요.",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //RadioClick
    public void onRadioBtnClicked(View view){
        boolean checked = ((RadioButton)view).isChecked();
        switch(view.getId()){
            case R.id.radioButton:
                if(checked){
                    input_shape="triangle";
                    break;
                }
            case R.id.radioButton2:
                if(checked){
                    input_shape="square";
                    break;
                }
        }
    }


}
