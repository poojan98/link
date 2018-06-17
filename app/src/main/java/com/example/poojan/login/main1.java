package com.example.poojan.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class main1 extends AppCompatActivity {
    private Button button1,button2,button3,button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    method1();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                method2();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                method3();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                method4();
            }
        });

    }
    public void method1(){
        Intent intent=new Intent(main1.this,housetype.class);
        startActivity(intent);
    }
    public void method2(){
        Intent intent=new Intent(main1.this,member.class);
        startActivity(intent);
    }
    public void method3(){
        Intent intent=new Intent(main1.this,sell1.class);
        startActivity(intent);
    }
    public void method4(){
        Intent intent=new Intent(main1.this,complaint.class);
        startActivity(intent);
    }
}
