package com.example.chordsbyear;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class Activity_Practise extends AppCompatActivity {

    private Button button_MChoice;
    private SwitchCompat switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_practise);


        switch1= findViewById(R.id.switch1);


        button_MChoice = findViewById(R.id.buttonMChoice);
        button_MChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_MChoice();
            }
        });





    }

    public void openActivity_MChoice (){
        Intent intent = new Intent(this, Activity_MChoice.class);
        intent.putExtra("switch1", switch1.isChecked());
        startActivity(intent);
    }

}