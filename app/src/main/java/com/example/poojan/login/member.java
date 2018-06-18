package com.example.poojan.login;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class member extends AppCompatActivity {

    private Button mbtn,mbtnv,mbtnd;
    EditText e1,e2,e3,e4;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member);
        db=new DatabaseHelper(this);
        mbtn=(Button) findViewById(R.id.mbutton);
        mbtnv=(Button) findViewById(R.id.cbuttonview);
        e1= (EditText) findViewById(R.id.medit1);
        e3= (EditText) findViewById(R.id.medit3);
        e4= (EditText) findViewById(R.id.medit4);
        e2= (EditText) findViewById(R.id.medit2);
        final String s1=e1.getText().toString();
        mbtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String s1=e1.getText().toString();
                        String s2=e2.getText().toString();
                        String s3=e3.getText().toString();
                        String s4=e4.getText().toString();
                        db.insert3(s1,s2,s3,s4);
                        Toast.makeText(getApplicationContext(),"Value saved",Toast.LENGTH_LONG).show();

                    }
                } );

        mbtnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res=db.cgetalldata();
                StringBuffer buffer=new StringBuffer();
                if(res.getCount()==0){
                    showMessage("Error","Nothing Found");
                }
                while(res.moveToNext()){
                    buffer.append("Member ID"+res.getString(0)+"\n");
                    buffer.append("House ID"+res.getString(1)+"\n");
                    buffer.append("Name "+res.getString(2)+"\n");
                    buffer.append("Member Type "+res.getString(3)+"\n\n");
                }
                showMessage("Data",buffer.toString());

            }
        });
        mbtnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer deletedRows=db.deleteData(s1);
                if(deletedRows>0){
                    Toast.makeText(member.this,"Data not deleted",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(member.this,"Data deleted",Toast.LENGTH_SHORT).show();
                }

            }

        });

    }
    public void showMessage(String title,String Message)
    {
        AlertDialog.Builder  builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }


}