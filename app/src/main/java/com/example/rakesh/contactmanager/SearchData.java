package com.example.rakesh.contactmanager;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchData extends AppCompatActivity {
    Button search;
    EditText searchText;
    TextView name,email;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_data);

        search=(Button) findViewById(R.id.btSearch);
        searchText= findViewById(R.id.etSearch);
        name= findViewById(R.id.etName);
        email= findViewById(R.id.tvEmail);
        databaseHelper=new DatabaseHelper(SearchData.this);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor cursor= databaseHelper.getData(searchText.getText().toString());
                name.setText("  ");
                email.setText("  ");

             while (cursor.moveToNext()){
                 name.setText(cursor.getString(1));
                 email.setText(cursor.getString(3));
             }

            }
        });


    }
}
