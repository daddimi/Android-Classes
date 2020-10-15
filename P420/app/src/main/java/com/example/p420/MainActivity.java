package com.example.p420;

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
    ArrayList<Employee> employees;
    ConstraintLayout emplayout;
    LinearLayout dialoglayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.mainlist);
        emplayout = findViewById(R.id.emplayout);
        dialoglayout = findViewById(R.id.dialoglayout);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater layoutInflater = getLayoutInflater();
                View dialogv = layoutInflater.inflate(R.layout.dialog,(ViewGroup)findViewById(R.id.dialoglayout));
                ImageView dialogimg = dialogv.findViewById(R.id.dialogimg);
                dialogimg.setImageResource(employees.get(position).getId());
                builder.setView(dialogv);
                builder.setTitle("more information");
                builder.setMessage("나이" + "  " +
                        employees.get(position).getAge() +" "+"세");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });

    }

    class EmployeeAdapter extends BaseAdapter {
        ArrayList<Employee> empdata;

        public EmployeeAdapter(ArrayList<Employee> empdata) {
            this.empdata = empdata;
        }

        @Override
        public int getCount() {
            return empdata.size();
        }

        @Override
        public Object getItem(int position) {
            return empdata.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = null;
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.employee,emplayout,true);
            ImageView empimg = view.findViewById(R.id.emp_img);
            TextView name = view.findViewById(R.id.tx_name);
            TextView phone = view.findViewById(R.id.tx_phone);
            //TextView age = view.findViewById(R.id.tx_age);
            Employee e = empdata.get(position);

            empimg.setImageResource(e.getId());
            name.setText(e.getName());
            phone.setText(e.getPhone());
            //age.setText(e.getAge());

            return view;
        }
    }

    public void setList(ArrayList<Employee> employees) {
        EmployeeAdapter employeeAdaptor = new EmployeeAdapter(employees);
        listView.setAdapter(employeeAdaptor);
    }

    public void getData() {
        employees = new ArrayList<>();
        employees.add(new Employee(R.drawable.p1,"이민호","30","010-1111-1111"));
        employees.add(new Employee(R.drawable.p2,"이종석","25","010-2222-2222"));
        employees.add(new Employee(R.drawable.p3,"김서형","40","010-3333-3333"));
        employees.add(new Employee(R.drawable.p4,"유승호","21","010-4444-4444"));
        employees.add(new Employee(R.drawable.p5,"이승기","27","010-5555-5555"));
        employees.add(new Employee(R.drawable.p6,"장나라","39","010-6666-6666"));
        employees.add(new Employee(R.drawable.p7,"박은빈","26","010-7777-7777"));
        employees.add(new Employee(R.drawable.p8,"주원","28","010-8888-8888"));
        employees.add(new Employee(R.drawable.p9,"박신혜","31","010-9999-9999"));
        employees.add(new Employee(R.drawable.p10,"이다인","22","010-1010-1010"));

        setList(employees);

    }

    public void mbt(View v) {
        getData();
    }


}