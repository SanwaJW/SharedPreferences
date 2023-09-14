package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText EdName;
    EditText EdAge;
    TextView tvName;
    TextView tvAge;
    Button btnSave;
    Button btnView;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EdName=findViewById(R.id.editTextName);
        EdAge=findViewById(R.id.editTextAge);
        tvName=findViewById(R.id.textViewName);
        tvAge=findViewById(R.id.textViewAge);
        btnSave=findViewById(R.id.buttonSave);
        btnView=findViewById(R.id.btnView);

        SharedPreferences sp =getSharedPreferences("com.example.sharedpreferences",MODE_PRIVATE);
        String name = sp.getString("name", "unKnow");
        tvName.setText(name);
        int age = sp.getInt("age", 0);
        String age1=String.valueOf(age);
        tvAge.setText(age1);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences=getSharedPreferences("com.example.sharedpreferences",MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("name",EdName.getText().toString());
                edit.putInt("age", Integer.parseInt(EdAge.getText().toString().trim()));
                edit.apply();
                Toast.makeText(MainActivity.this, "saved", Toast.LENGTH_SHORT).show();


            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp =getSharedPreferences("com.example.sharedpreferences",MODE_PRIVATE);
                String name = sp.getString("name", "unKnow");
                tvName.setText(name);
                int age = sp.getInt("age", 0);
                String age1=String.valueOf(age);
                tvAge.setText(age1);

            }
        });


    }
}