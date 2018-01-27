package com.example.rakesh.contactmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.xml.transform.Result;

public class AddNewContect extends AppCompatActivity {
    EditText name,mobile_number,email;
    Button btnSave;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contect);

        databaseHelper=new DatabaseHelper(this);

        name= findViewById(R.id.etName);
        mobile_number= findViewById(R.id.etMobileNumber);
        email= findViewById(R.id.etEmail);
        btnSave=(Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            boolean result=databaseHelper.insertData(name.getText().toString(),Integer.parseInt(mobile_number.getText().toString()),
                    email.getText().toString());
            if(result)
                Toast.makeText(AddNewContect.this,"Data Inseted",Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(AddNewContect.this,"Data not Inseted",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
