package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class BookApoinment extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4;
    TextView tv;
    private Button datebtn,timebtn,btnBook,btnBack;
    private DatePickerDialog datePickerDialog;
   private TimePickerDialog timePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_apoinment);

        tv=findViewById(R.id.tvApppTitile);
        ed1=findViewById(R.id.etLTBFullName);
        ed2=findViewById(R.id.etLTBAdd);
        ed3=findViewById(R.id.etLTBPinCode);
        ed4=findViewById(R.id.etLTBContactNum);

        datebtn=findViewById(R.id.btnCartDate);
        timebtn=findViewById(R.id.btnCartTime);
        btnBook=findViewById(R.id.Bookappbtn);
        btnBack=findViewById(R.id.appBackbtn);

        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);
        Intent it=getIntent();
        String title=it.getStringExtra("text1");
        String fullname=it.getStringExtra("text2");
        String address=it.getStringExtra("text3");
        String contact=it.getStringExtra("text4");
        String fees=it.getStringExtra("text5");

            tv.setText(title);
            ed1.setText(fullname);
            ed2.setText(address);
            ed3.setText(contact);
            ed4.setText("Cons Fees: "+fees+"/-");


            initDatePicker();
            datebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    datePickerDialog.show();
                }
            });
initTimePicker();
timebtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        timePickerDialog.show();
    }
});

btnBack.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(BookApoinment.this,FindDoctor.class));
    }
});

btnBook.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

    }
});

    }


    private  void initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                datebtn.setText(dayOfMonth+"/"+month+"/"+year);


            }
        };
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);int month=calendar.get(Calendar.MONTH);
        int  day=calendar.get(Calendar.DAY_OF_MONTH);

        int style= AlertDialog.THEME_HOLO_DARK;
        datePickerDialog=new DatePickerDialog(this,style,dateSetListener,year,month,day);
        datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis()+86400000);
    }

    private  void initTimePicker(){
        TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    timebtn.setText(hourOfDay+":"+minute);
            }
        };
        Calendar calendar=Calendar.getInstance();
        int hrs=calendar.get(Calendar.HOUR);int min=calendar.get(Calendar.MINUTE);
        int style= AlertDialog.THEME_HOLO_DARK;
        timePickerDialog=new TimePickerDialog(this,style,timeSetListener,hrs,min,true);
    }
}