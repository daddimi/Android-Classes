package com.example.p275;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sp = getSharedPreferences("st", Activity.MODE_PRIVATE);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("[TEST]","onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("[TEST]","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoreState();
        Log.d("[TEST]","onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("[TEST]","onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveState();
        Log.d("[TEST]","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("[TEST]","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("[TEST]","onDestroy");
    }

    public void restoreState() {
        sp = getSharedPreferences("st",Activity.MODE_PRIVATE);
        if(sp != null && sp.contains("date")) {
            String result = sp.getString("date","");
            Toast.makeText(this,"Not Allowd",Toast.LENGTH_SHORT).show();
        }
    }

    public void saveState() {

        SharedPreferences.Editor editor = sp.edit();
        Date d = new Date();
        editor.putString("data",d.toString());
        editor.
    }




}
























