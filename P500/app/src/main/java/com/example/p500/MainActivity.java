package com.example.p500;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    
    TextView tx_id,tx_pwd;
    HttpAsync httpAsync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tx_id = findViewById(R.id.tx_id);
        tx_pwd = findViewById(R.id.tx_pwd);

    }
    
    public void ck (View v) {
        String id = tx_id.getText().toString();
        String pwd = tx_pwd.getText().toString();
        String url = "http://192.168.0.3/android/login.jsp";
        url += "?id="+id+"&pwd="+pwd;
        Toast.makeText(MainActivity.this, url, Toast.LENGTH_SHORT).show();

        httpAsync = new HttpAsync();
        httpAsync.execute(url);

    }

    class HttpAsync extends AsyncTask<String,String,String> {

        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Login...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            String url = strings[0].toString();
            String result = HttpConnect.getString(url);
            return result;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

        }

        @Override
        protected void onPostExecute(String s) {
           progressDialog.dismiss();
            //Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
            String result = s.trim(); //서버에서 내려온 값에 뭔가 붙어있을 수도 있으니 trim으로 정리해준다.
            if(result.equals("1")){
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
//                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//                dialog.setTitle("Welcome");
//                dialog.setMessage("You are successfully logged in.");
//                //final Handler handler = new Handler();
//                dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        return;
//                    }
//                });
//                dialog.show();

            } else {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Failed");
                dialog.setMessage("Change id or pwd and retry.");
                //final Handler handler = new Handler();
                dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                dialog.show();

            }
        }
    }

}