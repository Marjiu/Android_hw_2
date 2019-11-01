package com.example.android_hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText hight;
        final EditText weight;
        final TextView bmi;
        final Button cal;
        hight = (EditText)findViewById(R.id.editText);
        weight=(EditText)findViewById(R.id.editText2);
        cal=(Button)findViewById(R.id.button);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!("".equals(hight.getText().toString()) || "".equals(weight.getText().toString()))) {                                      //判斷條件 身高 跟 體重 都有輸入值才執行
                    float numH = Float.parseFloat(hight.getEditableText().toString());                                                           // 取得 身高輸入值
                    float numW = Float.parseFloat(weight.getEditableText().toString());                                                          // 取得 體重輸入值
                    float score;                                                                                                              // BMI值 計算結果
                    numH=numH/100;                                                                                                            // 計算BMI
                    score = numW / (numH * numH);                                                                                             // 計算BMI
                    TextView result = (TextView) findViewById(R.id.textView3);                                                                 // 取得 顯示結果 物件
                    NumberFormat nf = NumberFormat.getInstance();                                                                               // 數字格式
                    nf.setMaximumFractionDigits(2);                                                                                           // 限制小數第二位
                    result.setText("BMI:"+nf.format(score));
                }
            }
        });
    }
}
