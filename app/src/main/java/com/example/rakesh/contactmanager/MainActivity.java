package com.example.rakesh.contactmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    Button searchData;
    Button insert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper=new DatabaseHelper(MainActivity.this);

        insert= (Button) findViewById(R.id.btnaddnew);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AddNewContect.class);
                startActivity(intent);
            }
        });
        searchData= (Button) findViewById(R.id.btnSearch);
        searchData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent=new Intent(MainActivity.this,SearchData.class);
            startActivity(intent);

            }
        });

    }


}
