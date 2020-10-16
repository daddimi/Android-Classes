package com.example.p489;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button,button2;
    SeekBar seekBar;
    TextView textView;
    ImageView imageView;
    MyAsync myAsync;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setEnabled(true);

        button2 = findViewById(R.id.button2);
        button2.setEnabled(false);

        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(100);
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);

    }

    public void ckbt1(View v) {
        myAsync = new MyAsync();
        myAsync.execute(100);

    }

    public void ckbt2(View v) {
        myAsync.cancel(true);
        myAsync.onCancelled();
    }

    class MyAsync extends AsyncTask<Integer,Integer,String > {
        @Override
        protected void onPreExecute() {
            button.setEnabled(false);
            button2.setEnabled(true);
        }

        @Override
        protected String doInBackground(Integer... integers) {
            int a = integers[0].intValue();
            int sum = 0;
            for(int i=0; i<=a; i++) {
                if(isCancelled() == true) {
                    break;
                }
                sum +=i;
                publishProgress(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "result: "+sum;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            int i = values[0].intValue();
            seekBar.setProgress(i);
            if (i<=30) {
                imageView.setImageResource(R.drawable.down);
            } else if (i<=70) {
                imageView.setImageResource(R.drawable.middle);
            }else if(i<=100) {
                imageView.setImageResource(R.drawable.up);
            }
        }

        @Override
        protected void onPostExecute(String s) {
            textView.setText(s);
            button.setEnabled(true);
            button2.setEnabled(false);
        }

        @Override
        protected void onCancelled() {
            seekBar.setProgress(0);
            textView.setText("");
            imageView.setImageResource(R.drawable.ic_launcher_background);
            button.setEnabled(true);
            button2.setEnabled(false);
        }
    }








}