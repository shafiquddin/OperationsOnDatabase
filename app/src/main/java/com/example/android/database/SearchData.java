package com.example.android.database;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchData extends AppCompatActivity {
    EditText etsearch;
    Button btnSearch;
    TextView sname, email;
    private dataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_data);

        dataBaseHelper = new dataBaseHelper(this);

        etsearch = (EditText) findViewById(R.id.SSearch);
        btnSearch = (Button) findViewById(R.id.sbntsearch);
        sname = (TextView) findViewById(R.id.textname);
        email = (TextView) findViewById(R.id.textemail);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor = dataBaseHelper.getData(etsearch.getText().toString());
                sname.setText(" ");
                email.setText(" ");
                while (cursor.moveToNext()) {
                    sname.setText(cursor.getString(1));
                    email.setText(cursor.getString(3));
                }
            }
        });
    }
}
