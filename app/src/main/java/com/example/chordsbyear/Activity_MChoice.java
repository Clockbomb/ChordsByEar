package com.example.chordsbyear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Activity_MChoice extends AppCompatActivity {

    private TextView questionNumberTV;
    private Button option1btn, option2btn, option3btn, option4btn, playAudiobtn;
    Random random;
    private ArrayList<QuestionModel> questionModelArrayList;
    int currentScore=0, questionAttempted =1, currentPos, numberQuestions, intArrayCounter=0;
    Integer[] intArray;
    final Handler handler = new Handler();
    private SoundPool soundPool;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        if(getIntent().getExtras().getBoolean("switch1"))
            Log.d("YOLO","True");



        setContentView(R.layout.activity_mchoice);

        questionNumberTV = findViewById(R.id.QuestionAttempted);
        option1btn = findViewById(R.id.Option1);
        option2btn = findViewById(R.id.Option2);
        option3btn = findViewById(R.id.Option3);
        option4btn = findViewById(R.id.Option4);
        playAudiobtn = findViewById(R.id.audioButton);
        questionModelArrayList = new ArrayList<>();
        random = new Random();
        String[] optionsArray = {"C major","A minor","G major", "E minor","D major",
                "B minor", "A major", "F# minor", "E major", "C# minor","B major", "G# minor",
                "G♭ major", "E♭ minor", "D♭ major", "B♭ minor", "A♭ major", "F minor", "E♭ major",
                "C minor", "B♭ major", "G minor", "F major", "D minor"};

        AudioAttributes audioAttributes =  new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        soundPool = new SoundPool.Builder()
                .setMaxStreams(1)
                .setAudioAttributes(audioAttributes)
                .build();

        getQuestion(questionModelArrayList);
        numberQuestions = questionModelArrayList.size();
        intArray = new Integer[numberQuestions];


        //Fill and shuffle array of integers
        for (int i = 0; i < numberQuestions; i++) {
            intArray[i] = i;
        }
        shuffleArray(intArray);
        //Log.d("CREATOR", Arrays.toString(intArray));

        currentPos= intArray[intArrayCounter];
        setDatatoViews(currentPos);

       //Audio button
       playAudiobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (questionModelArrayList.get(currentPos).getAnswer()){
                    case "A minor":
                        soundPool.play(questionModelArrayList.get(currentPos).getSound(),1,1,0,0,1);
                        break;
                    case "C major":
                        soundPool.play(questionModelArrayList.get(currentPos).getSound(),1,1,0,0,1);
                        break;
                    case "G major":
                        soundPool.play(questionModelArrayList.get(currentPos).getSound(),1,1,0,0,1);
                        break;
                    case "D major":
                        soundPool.play(questionModelArrayList.get(currentPos).getSound(),1,1,0,0,1);
                        break;
                }


            }
        });




        option1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questionModelArrayList.get(currentPos).getAnswer().equals(option1btn.getText())){
                    currentScore++;
                    option1btn.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                }else {
                    option1btn.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                }
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                questionAttempted++;
                if(questionAttempted-1 == numberQuestions){
                    Log.d("CREATOR", "I am in if condition");
                    showBottomSheet();
                }else{
                    intArrayCounter++;
                    currentPos = intArray[intArrayCounter];

                    //Delay to display correct/incorrect answer
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            option1btn.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
                            setDatatoViews(currentPos);
                            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                        }
                    }, 1000);

                }
            }

        });

        option2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questionModelArrayList.get(currentPos).getAnswer().equals(option2btn.getText())){
                    currentScore++;
                    option2btn.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                }else {
                    option2btn.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                }
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                questionAttempted++;
                if(questionAttempted-1 == numberQuestions){
                    Log.d("CREATOR", "I am in if condition");
                    showBottomSheet();
                }else{
                    intArrayCounter++;
                    currentPos = intArray[intArrayCounter];

                    //Delay to display correct/incorrect answer
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            option2btn.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
                            setDatatoViews(currentPos);
                            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                        }
                    }, 1000);

                }
            }

        });

        option3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questionModelArrayList.get(currentPos).getAnswer().equals(option3btn.getText())){
                    currentScore++;
                    option3btn.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                }else {
                    option3btn.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                }
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                questionAttempted++;
                if(questionAttempted-1 == numberQuestions){
                    Log.d("CREATOR", "I am in if condition");
                    showBottomSheet();
                }else{
                    intArrayCounter++;
                    currentPos = intArray[intArrayCounter];

                    //Delay to display correct/incorrect answer
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            option3btn.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
                            setDatatoViews(currentPos);
                            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                        }
                    }, 1000);

                }
            }

        });

        option4btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questionModelArrayList.get(currentPos).getAnswer().equals(option4btn.getText())){
                    currentScore++;
                    option4btn.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                }else {
                    option4btn.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                }
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                questionAttempted++;
                if(questionAttempted-1 == numberQuestions){
                    Log.d("CREATOR", "I am in if condition");
                    showBottomSheet();
                }else{
                    intArrayCounter++;
                    currentPos = intArray[intArrayCounter];

                    //Delay to display correct/incorrect answer
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            option4btn.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
                            setDatatoViews(currentPos);
                            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                        }
                    }, 1000);

                }
            }

        });

    }


    private void showBottomSheet (){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Activity_MChoice.this);
        View bottomSheetTV = LayoutInflater.from(getApplicationContext()).inflate(R.layout.result_bottom_sheet, (LinearLayout)findViewById(R.id.linearLayot));

        TextView scoreTV = bottomSheetTV.findViewById(R.id.scoreTV);
        Button restartBtn = bottomSheetTV.findViewById(R.id.restartButton);
        Button exitBtn = bottomSheetTV.findViewById(R.id.exitTomain);

        scoreTV.setText("Final Score: " + currentScore + "/" + numberQuestions);
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetTV);
        bottomSheetDialog.show();


        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setFocusable(false);
                shuffleArray(intArray);
                Log.d("CREATOR", Arrays.toString(intArray));
                intArrayCounter = 0;
                currentPos = intArray[intArrayCounter];
                questionAttempted = 1;
                currentScore = 0;
                setDatatoViews(currentPos);

                option1btn.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
                option2btn.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
                option3btn.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
                option4btn.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);

                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                bottomSheetDialog.dismiss();
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity_Home();
            }
        });


    }

    private void setDatatoViews(int currentPos) {

        questionNumberTV.setText("Question: " + questionAttempted +"/" + numberQuestions);
        option1btn.setText(questionModelArrayList.get(currentPos).getOption1());
        option2btn.setText(questionModelArrayList.get(currentPos).getOption2());
        option3btn.setText(questionModelArrayList.get(currentPos).getOption3());
        option4btn.setText(questionModelArrayList.get(currentPos).getOption4());

    }

    private void getQuestion(ArrayList<QuestionModel> questionModelArrayList){
        questionModelArrayList.add( new QuestionModel(
                "A minor", "G major","D major", "C major", "A minor", soundPool.load(this, R.raw.aminor, 1)));
        questionModelArrayList.add( new QuestionModel(
                "G major", "D major","A minor", "C major", "C major", soundPool.load(this, R.raw.cmajor, 1)));
        questionModelArrayList.add( new QuestionModel(
                "G major", "C major","A minor", "D major", "G major", soundPool.load(this, R.raw.gmajor, 1)));
        questionModelArrayList.add( new QuestionModel(
                "C major", "G major","A minor", "D major", "D major", soundPool.load(this, R.raw.dmajor, 1)));
        if(getIntent().getExtras().getBoolean("switch1"))
            questionModelArrayList.add( new QuestionModel(
                    "C major", "G major","A minor", "F# minor", "F# minor", soundPool.load(this, R.raw.fsminor, 1)));


    }

    private static String capFirstLetter(String string){
        string = string.substring(0, 1).toUpperCase() + string.substring(1);
        return string;
    }


    private void shuffleArray(Integer[] intArray) {

        List<Integer> intList =  Arrays.asList(intArray);

        Collections.shuffle(intList);

        intList.toArray(intArray);
    }


    private void openActivity_Home(){
        Intent intent = new Intent(this, Activity_Home.class);
        startActivity(intent);
    }

}