package com.example.android.database;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText tname, mob, Email;
    TextView edit;

    Button insert, search, deletemain, update, show;
    dataBaseHelper helper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        RecyclerView proglist=(RecyclerView)findViewById(R.id.list);
//        proglist.setLayoutManager(new LinearLayoutManager(this));
//   String lang=edit.toString();
//  String[] lang={"Hyderabad","Aurangabad","nizamabad","Ahemadabad","Daulatabad","khultabad","Abbasabad","Akbarabad","Aliabad","Faizabad","hajjiabad","hussainabad","Jahanabdad","Khorramabad","kawsarabad","Razabad","shahabad","sahibabad","Mosheerabad","Mominabad","sikanderabad","Allahabad","jalalabad"};
//        proglist.setAdapter(new ProgrammingAdapter(lang));
        helper = new dataBaseHelper(this);
        tname = (EditText) findViewById(R.id.etname);
        mob = (EditText) findViewById(R.id.etMobile);
        Email = (EditText) findViewById(R.id.etEmail);
        edit = (TextView) findViewById(R.id.edit);
        insert = findViewById(R.id.add);
//            search = findViewById(R.id.search);
        deletemain = findViewById(R.id.delete);
        update = findViewById(R.id.upgrade);
        show = findViewById(R.id.ShowDatabase);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,AddnewContact.class);
//                startActivity(intent);
                if (TextUtils.isEmpty(tname.getText())) {
                    Toast.makeText(MainActivity.this, "plz enter your name ", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(mob.getText())) {
                    Toast.makeText(MainActivity.this, "plz enter your mobile ", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(Email.getText())) {
                    Toast.makeText(MainActivity.this, "plz enter your mobile ", Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean result = helper.insertdata(tname.getText().toString(), Long.parseLong(mob.getText().toString()), Email.getText().toString());
                if (result == true) {
                    Toast.makeText(MainActivity.this, "data inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "data not inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
//            search.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(MainActivity.this, SearchData.class);
//                    startActivity(intent);
//                }
//            });
        deletemain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,Delete.class);
//                startActivity(intent);
                if (TextUtils.isEmpty(mob.getText())) {
                    Toast.makeText(MainActivity.this, "plz enter your name ", Toast.LENGTH_SHORT).show();
                    return;
                } else {

                    helper.getDelete(mob.getText().toString());
                    Toast.makeText(MainActivity.this, "deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,UpdateData.class);
//                startActivity(intent);
                if (TextUtils.isEmpty(mob.getText())) {
                    Toast.makeText(MainActivity.this, "plz enter your mobile ", Toast.LENGTH_SHORT).show();
                    return;
                }

                helper.update(mob.getText().toString(), tname.getText().toString(), Email.getText().toString());
                Toast.makeText(MainActivity.this, "Updated", Toast.LENGTH_SHORT).show();
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,StoredData.class);
//                startActivity(intent);
                Cursor res = helper.getAllData();
                if (res.getCount() == 0) {
                    // show message

                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("NAME :" + res.getString(1) + "\n");
                    buffer.append("MOBILE :" + res.getString(2) + "\n");
                    buffer.append("EMAIL :" + res.getString(3) + "\n\n");
                }
                edit.setText(buffer);
            }
        });
    }
}