package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LabTestBook extends AppCompatActivity {

    EditText etfullName,etAdd,etPin,etContact;
    Button btnBooking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book);
    etfullName=findViewById(R.id.etLTBFullName);
        etAdd=findViewById(R.id.etLTBAdd);
        etContact=findViewById(R.id.etLTBContactNum);
        etPin=findViewById(R.id.etLTBPin);
        btnBooking=findViewById(R.id.Bookappbtn);

        Intent intent=getIntent();
        String[] price=intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote("$"));
        String date=intent.getStringExtra("date");

    btnBooking.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
//            String username=sharedPreferences.getString("username","").toString();
//
//            Database db =new Database(getApplicationContext(),"healthcare",null,1);
//            db.addOrder(username,etfullName.getText().toString(),etAdd.getText().toString(),etContact.getText().toString(), Integer.parseInt(etPin.getText().toString()),date.toString(),Float.parseFloat(price[1].toString()),"lab");
//            db.removeCart(username,"lab");
            Toast.makeText(LabTestBook.this, "Your booking is done Successfully", Toast.LENGTH_SHORT).show();
//        startActivity(new Intent(LabTestBook.this,HomeActivity.class));
        }
    });
    }
}