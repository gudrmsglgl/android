package com.example.gimhyeong_geun.lab1_201003011;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.common.api.GoogleApiClient;

public class activity_Lab1_2 extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1_2);

        Button sum_btn = (Button) findViewById(R.id.button2);
        Button sub_btn = (Button) findViewById(R.id.button3);
        Button mul_btn = (Button) findViewById(R.id.button4);
        Button div_btn = (Button) findViewById(R.id.button5);

        sum_btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit1 = (EditText) findViewById(R.id.editText);
                EditText edit2 = (EditText) findViewById(R.id.editText2);

                int a = Integer.parseInt(edit1.getText().toString());
                int b = Integer.parseInt(edit2.getText().toString());

                int sum = a + b;

                String str_sum = Integer.toString(sum);

                EditText edit3 = (EditText) findViewById(R.id.editText3);
                edit3.setText(str_sum);
            }

        });

        sub_btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit1 = (EditText) findViewById(R.id.editText);
                EditText edit2 = (EditText) findViewById(R.id.editText2);

                int a = Integer.parseInt(edit1.getText().toString());
                int b = Integer.parseInt(edit2.getText().toString());

                int sub = a - b;

                String str_sum = Integer.toString(sub);

                EditText edit3 = (EditText) findViewById(R.id.editText3);
                edit3.setText(str_sum);
            }

        });

        mul_btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit1 = (EditText) findViewById(R.id.editText);
                EditText edit2 = (EditText) findViewById(R.id.editText2);

                int a = Integer.parseInt(edit1.getText().toString());
                int b = Integer.parseInt(edit2.getText().toString());

                int mul = a*b;

                String str_sum = Integer.toString(mul);

                EditText edit3 = (EditText) findViewById(R.id.editText3);
                edit3.setText(str_sum);
            }

        });

        div_btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit1 = (EditText) findViewById(R.id.editText);
                EditText edit2 = (EditText) findViewById(R.id.editText2);

                int a = Integer.parseInt(edit1.getText().toString());
                int b = Integer.parseInt(edit2.getText().toString());

                int div = a/b;

                String str_sum = Integer.toString(div);

                EditText edit3 = (EditText) findViewById(R.id.editText3);
                edit3.setText(str_sum);
            }

        });


    }

}
