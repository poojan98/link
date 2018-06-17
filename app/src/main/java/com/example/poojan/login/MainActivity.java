package com.example.poojan.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn3;
    EditText e1,e2,e3,e4,e5;
    DatabaseHelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DatabaseHelper(this);
        btn3=(Button) findViewById(R.id.button3);
        e1= (EditText) findViewById(R.id.EditView1);
        e3= (EditText) findViewById(R.id.EditView3);
        e4= (EditText) findViewById(R.id.EditView4);
        e2= (EditText) findViewById(R.id.EditView2);
        e5= (EditText) findViewById(R.id.EditView5);
        btn3.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                String s4=e4.getText().toString();
                String s5= e5.getText().toString();
                db.insert(s1,s2,s3,s4,s5);
                Toast.makeText(getApplicationContext(),"Value saved",Toast.LENGTH_LONG).show();



                if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_LONG).show();

                }
                else{if(s2.equals(s3))

                {
                    Boolean chkusername = db.chkusername(s1);
                    if (chkusername == true) {
                        Toast.makeText(getApplicationContext(), "Username already exists", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Account Created", Toast.LENGTH_LONG).show();
                    }
                } }openactivity();


                }});}



    public void openactivity(){
        Intent intent=new Intent(MainActivity.this,login.class);
        startActivity(intent);

    }
}
