package com.example.p474;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar,progressBar2;
    TextView textView,textView2;
    Button button,button2,button3;
    MyHandler myHandler;
    MyHandler2 myHandler2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar.setMax(50);
        //progressBar2.setMax(50);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        myHandler = new MyHandler();
        myHandler2 = new MyHandler2();

    }

    public void ckbt (View v)  {
        if(v.getId() == R.id.button) {
            MyThread t = new MyThread();
            t.start();
            button.setEnabled(false);

        } else if(v.getId() == R.id.button2) {
            Thread t = new Thread(new MyThread2());
            t.start();
            button2.setEnabled(false);

        } else if(v.getId() == R.id.button3) {
            progress();

        }
    }

    public void progress() {
        final ProgressDialog progressDialog = new ProgressDialog(this);


    }

    // Thread t = new Tread(){};
    class MyThread extends Thread {
        @Override
        public void run() {
            for(int i=1; i<=50;i++) {
                progressBar.setProgress(i);
                textView.setText(i+"");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    button.setEnabled(true);
                }
            });

        }
    };

    class MyHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            Bundle bundle = msg.getData();
            int data = bundle.getInt("tdata",0);
            textView.setText("Handler:"+data);
            progressBar.setProgress(data);
        }
    }

    class MyHandler2 extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            Bundle bundle = msg.getData();
            int data = bundle.getInt("tdata",0);
            textView2.setText("Handler2:"+data);
            progressBar2.setProgress(data);
            if(data == 49) {
                button2.setEnabled(true);
            }

        }
    }

    class MyThread2 implements Runnable {

        @Override
        public void run() {
            for(int i=1; i<=50;i++) {
                progressBar2.setProgress(i);
                textView2.setText(i+"");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message message = myHandler.obtainMessage();
                Message message2 = myHandler2.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("tdata",i);
                message.setData(bundle);
                message2.setData(bundle);
                //myHandler.sendMessage(message);
                myHandler2.sendMessage(message2);
            }


        }
    }


}