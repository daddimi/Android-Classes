package com.example.p475;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView,textView2;
    MyHandler myHandler;
    MyHandler2 myHandler2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        MyHandler
        MyHandler2
    }

    public void ckbt(View v) {
        if(v.getId() == R.id.button) {

        } else if(v.getId() == R.id.button2) {

        }
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            for(int i=0; i<=5000; i++) {
                Random random = new Random();
                int rdata = random.nextInt(200)+1;
                Message message = myHandler;
                Bundle bundle = new Bundle();
                bundle.putInt();
                message.setData(bundle);
                myHandler.sendMessage();

            }

        }
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            Bundle bundle = msg.getData();

        }
    }

}