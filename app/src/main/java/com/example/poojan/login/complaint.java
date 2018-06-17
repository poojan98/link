package com.example.poojan.login;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class complaint extends AppCompatActivity {
    private Button cbtn,cbtnv;
    EditText e1,e2,e3,e4;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complaint);
        db=new DatabaseHelper(this);
        cbtn=(Button) findViewById(R.id.cbutton);
        cbtnv=(Button) findViewById(R.id.cbuttonview);
        e1= (EditText) findViewById(R.id.cedit1);
        e3= (EditText) findViewById(R.id.cedit3);
        e4= (EditText) findViewById(R.id.cedit4);
        e2= (EditText) findViewById(R.id.cedit2);
                cbtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String s1= e1.getText().toString();
                        String s2= e2.getText().toString();
                        String s3=e3.getText().toString();
                        String s4= e4.getText().toString();
                        db.insert1(s1,s2,s3,s4);
                        Toast.makeText(getApplicationContext(),"Value saved",Toast.LENGTH_LONG).show();

                    }
} );

    cbtnv.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Cursor res=db.cgetalldata();
            StringBuffer buffer=new StringBuffer();
            if(res.getCount()==0){
                showMessage("Error","Nothing Found");
            }
            while(res.moveToNext()){
                buffer.append("Residenece ID"+res.getString(0)+"\n");
                buffer.append("Memeber ID"+res.getString(1)+"\n");
                buffer.append("Compalain "+res.getString(2)+"\n");
                buffer.append("Severity "+res.getString(3)+"\n\n");
            }
            showMessage("Data",buffer.toString());

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

}}

