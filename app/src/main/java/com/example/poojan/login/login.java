package com.example.poojan.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {
    private Button btn2;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        btn2 = (Button) findViewById(R.id.button2);
        btn1 = (Button) findViewById(R.id.button1);
        btn2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        openactivity1();


                    }
                });
        btn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        openactivity2();

                    }
                });
    }
        public void openactivity1 () {
            Intent intent = new Intent(login.this, MainActivity.class);
            startActivity(intent);
        }
    public void openactivity2 () {
        Intent intent = new Intent(login.this, main1.class);
        startActivity(intent);
    }

}
