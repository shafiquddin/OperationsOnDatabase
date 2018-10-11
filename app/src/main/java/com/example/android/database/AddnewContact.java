package com.example.android.database;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddnewContact extends AppCompatActivity {
    EditText tname, mob, Email;
    Button save;
    private dataBaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnew_contact);
        helper = new dataBaseHelper(this);
        tname = (EditText) findViewById(R.id.etname);
        mob = (EditText) findViewById(R.id.etMobile);
        Email = (EditText) findViewById(R.id.etEmail);
        save = (Button) findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result = helper.insertdata(tname.getText().toString(), Integer.parseInt(mob.getText().toString()), Email.getText().toString());
                if (result) {
                    Toast.makeText(AddnewContact.this, "data inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddnewContact.this, "data not inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
