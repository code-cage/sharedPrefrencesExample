package com.example.sandeep.sharedprfrencesexample;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText etTxt;
    TextView tvResult;
    Button btnSave;
    Button btnGet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveToPrefs();
            }
        });

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFromPrefs();
            }
        });

    }


    private void saveToPrefs(){

        SharedPreferences sp=getSharedPreferences("my_pref",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();

        String text=etTxt.getText().toString();
        editor.putString("text",text);
        editor.commit();

    }


    private void getFromPrefs(){

        SharedPreferences sp=getSharedPreferences("my_pref",MODE_PRIVATE);
        String text=sp.getString("text","not found");
        tvResult.setText(text);

    }


    private void init() {

        etTxt=findViewById(R.id.et_txt);
        tvResult=findViewById(R.id.tvResult);
        btnSave=findViewById(R.id.btn_save);
        btnGet=findViewById(R.id.btn_get);
    }
}
