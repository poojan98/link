package com.example.poojan.login;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sell1 extends AppCompatActivity {
    private Button sbtn,sbtnv;
    EditText e1,e2,e3,e4;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sell);
        db=new DatabaseHelper(this);
        sbtn=(Button) findViewById(R.id.sbutton);

        e1= (EditText) findViewById(R.id.sedit1);
        e3= (EditText) findViewById(R.id.sedit3);

        e2= (EditText) findViewById(R.id.sedit2);
        sbtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String s1=e1.getText().toString();
                        String s2=e2.getText().toString();
                        String s3= e3.getText().toString();

                        db.insert2(s1,s2,s3);
                        Toast.makeText(getApplicationContext(),"Value saved",Toast.LENGTH_LONG).show();

                    }
                } );}}

