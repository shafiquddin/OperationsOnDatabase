package com.example.android.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends AppCompatActivity {
Button btndelete;
EditText etdelete;
private dataBaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        helper=new dataBaseHelper(this);
        etdelete=(EditText)findViewById(R.id.delete);
        btndelete=(Button)findViewById(R.id.btndelete);
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.getDelete(etdelete.getText().toString());
                Toast.makeText(Delete.this, "deleted", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
