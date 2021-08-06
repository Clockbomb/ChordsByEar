package com.example.chordsbyear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Activity_Home extends AppCompatActivity {

    private Button button_Practise;
    private Button button_Learn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        button_Practise = findViewById(R.id.button_Practise);
        button_Learn = findViewById(R.id.buttonLearn);



        button_Practise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_practise();
            }
        });


        button_Learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity_Learn();
            }
        });
    }

    public void openActivity_practise (){
        Intent intent = new Intent(this, Activity_Practise.class);
        startActivity(intent);
    }

    public void openActivity_Learn (){
        Intent intent = new Intent(this, Activity_Learn.class);
        startActivity(intent);
    }

}