package com.example.p428;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Employee> persons;
    ConstraintLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        container = findViewById(R.id.container);

    }

    class PersonAdapter extends BaseAdapter {
        ArrayList<Employee> datas;

        public PersonAdapter(ArrayList<Employee> datas) {
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
            LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(
                    R.layout.person,
                    container,
                    true
            );
            ImageView im = view.findViewById(R.id.imgView);
            TextView tx_id = view.findViewById(R.id.tx_id);
            TextView tx_name = view.findViewById(R.id.tx_name);
            TextView tx_age = view.findViewById(R.id.tx_age);
            Employee p = datas.get(position);
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
        persons.add(new Employee(R.drawable.p10,"Lim Malsook","010-8888-8888"));
        persons.add(new Employee(R.drawable.p13,"Kim Malsook","010-7777-7777"));
        persons.add(new Person(R.drawable.p3,"Hong Malsook","010-6666-6666"));
        persons.add(new Person(R.drawable.p4,"Oh Malsook","010-5555-5555"));
        persons.add(new Person(R.drawable.p5,"Lee Malsook","010-9999-9999"));
        persons.add(new Person(R.drawable.p6,"Moon Malsook","010-4444-4444"));
        persons.add(new Person(R.drawable.p7,"Jung Malsook","010-3333-3333"));
        persons.add(new Person(R.drawable.p8,"Choi Malsook","010-2222-2222"));
        persons.add(new Person(R.drawable.p9,"Ko Malsook","010-1111-1111"));
        setList(persons);
    }

    public void ckbt(View v) {
        getData();
    }
}