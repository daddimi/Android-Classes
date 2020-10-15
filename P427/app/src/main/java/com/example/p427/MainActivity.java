package com.example.p427;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Person> persons;
    LinearLayout dlayout;
    ConstraintLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        dlayout = findViewById(R.id.dlayout);
        container = findViewById(R.id.container);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater layoutInflater = getLayoutInflater();
                View dview = layoutInflater.inflate(R.layout.dialog,(ViewGroup) findViewById(R.id.dlayout));
                ImageView dimg = dview.findViewById(R.id.imageView);
                dimg.setImageResource(persons.get(position).getId());
                builder.setView(dview);
                builder.setTitle("Hi");
                builder.setMessage("NAME:" +
                        persons.get(position).getName());
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
    }


    class PersonAdapter extends BaseAdapter {
        ArrayList<Person> datas;

        public PersonAdapter(ArrayList<Person> datas) {
            this.datas = datas;
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = null;
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(
                    R.layout.person,
                    container,
                    true);
            ImageView im = view.findViewById(R.id.imageView2);
            TextView tx_name = view.findViewById(R.id.tx_name);
            TextView tx_phone = view.findViewById(R.id.tx_phone);
            Person p = datas.get(position);

            im.setImageResource(p.getId());
            tx_name.setText(p.getName());
            tx_phone.setText(p.getPhone());

            return view;
        }
    }


        public void setList(ArrayList<Person> persons) {
            PersonAdapter personAdapter = new PersonAdapter(persons);
            listView.setAdapter(personAdapter);
        }

        public void getData() {
            persons = new ArrayList<>();
            persons.add(new Person(R.drawable.p1, "Lim Malsook", "010-8888-8888"));
            persons.add(new Person(R.drawable.p2, "Kim Malsook", "010-7777-7777"));
            persons.add(new Person(R.drawable.p3, "Hong Malsook", "010-6666-6666"));
            persons.add(new Person(R.drawable.p4, "Oh Malsook", "010-5555-5555"));
            persons.add(new Person(R.drawable.p5, "Lee Malsook", "010-9999-9999"));
            persons.add(new Person(R.drawable.p6, "Moon Malsook", "010-4444-4444"));
            persons.add(new Person(R.drawable.p7, "Jung Malsook", "010-3333-3333"));
            persons.add(new Person(R.drawable.p8, "Choi Malsook", "010-2222-2222"));
            persons.add(new Person(R.drawable.p9, "Ko Malsook", "010-1111-1111"));
            setList(persons);
        }

        public void ckbt(View v) {
            getData();
        }


}