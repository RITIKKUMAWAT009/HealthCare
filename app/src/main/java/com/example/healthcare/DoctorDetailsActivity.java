package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    String[][] doctor_details0=
            {
                    {"Name:Dr. Sarah Smith", "Hospital Address:123 Main Street, Cityville, CA", "Phone Number:(555) 555-1234", "600"},
        { "Name:Dr. John Anderson", "Hospital Address:456 Elm Avenue, Townsville, NY","Phone Number:(555) 555-5678","900" },
        {"Name:Dr. Emily Davis", "Hospital Address:789 Oak Road, Villagetown, TX","Phone Number:(555) 555-9876", "500"},
        { "Name:Dr. Michael Johnson", "Hospital Address:101 Pine Lane, Suburbia, FL","Phone Number:(555) 555-4321","800"},
        {"Name:Dr. Jennifer Wilson",  "Hospital Address:222 Maple Street,Delhi ", "Phone Number:(555) 555-8765","700" }

        };
    String[][] doctor_details1=
            {
                    {"Name:Dr. Sarah", "Hospital Address:123 Main Street, Cityville, CA", "Phone Number:(555) 555-1234", "600"},
                    { "Name:Dr.  Anderson", "Hospital Address:456 Elm Avenue, Townsville, NY","Phone Number:(555) 555-5678","900" },
                    {"Name:Dr.  Davis", "Hospital Address:789 Oak Road, Villagetown, TX","Phone Number:(555) 555-9876", "500"},
                    { "Name:Dr.  Johnson", "Hospital Address:101 Pine Lane, Suburbia, FL","Phone Number:(555) 555-4321","800"},
                    {"Name:Dr.  Wilson",  "Hospital Address:222 Maple Street,Delhi ", "Phone Number:(555) 555-8765","700" }

            };String[][] doctor_details2=
            {
                    {"Name:Dr.  Smith", "Hospital Address:123 Main Street, Cityville, CA", "Phone Number:(555) 555-1234", "600"},
                    { "Name:Dr. John ", "Hospital Address:456 Elm Avenue, Townsville, NY","Phone Number:(555) 555-5678","900" },
                    {"Name:Dr. Emily ", "Hospital Address:789 Oak Road, Villagetown, TX","Phone Number:(555) 555-9876", "500"},
                    { "Name:Dr. Michael ", "Hospital Address:101 Pine Lane, Suburbia, FL","Phone Number:(555) 555-4321","800"},
                    {"Name:Dr. Jennifer ",  "Hospital Address:222 Maple Street,Delhi ", "Phone Number:(555) 555-8765","700" }

            };String[][] doctor_details3=
            {
                    {"Name:Dr. Nilesh", "Hospital Address:123 Main Street, Cityville, CA", "Phone Number:(555) 555-1234", "600"},
                    { "Name:Dr. Soni", "Hospital Address:456 Elm Avenue, Townsville, NY","Phone Number:(555) 555-5678","900" },
                    {"Name:Dr. Dilip jain", "Hospital Address:789 Oak Road, Villagetown, TX","Phone Number:(555) 555-9876", "500"},
                    { "Name:Dr. Rathi", "Hospital Address:101 Pine Lane, Suburbia, FL","Phone Number:(555) 555-4321","800"},
                    {"Name:Dr. Khandelwal",  "Hospital Address:222 Maple Street,Delhi ", "Phone Number:(555) 555-8765","700" }

            };String[][] doctor_details4=
            {
                    {"Name:Dr.Tanisha ", "Hospital Address:123 Main Street, Cityville, CA", "Phone Number:(555) 555-1234", "600"},
                    { "Name:Dr. Mehta", "Hospital Address:456 Elm Avenue, Townsville, NY","Phone Number:(555) 555-5678","900" },
                    {"Name:Dr. Rafik", "Hospital Address:789 Oak Road, Villagetown, TX","Phone Number:(555) 555-9876", "500"},
                    { "Name:Dr.Mainsh", "Hospital Address:101 Pine Lane, Suburbia, FL","Phone Number:(555) 555-4321","800"},
                    {"Name:Dr. Anand",  "Hospital Address:222 Maple Street,Delhi ", "Phone Number:(555) 555-8765","700" }

            };

    TextView textView;
    Button btn;
    String [][] doctor_details={};
    ArrayList list;
    SimpleAdapter simpleAdapter;
    HashMap item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        textView=findViewById(R.id.tvDDtitle);
        btn =findViewById(R.id.btnCartCheckout);
        Intent it=getIntent();
        String title=it.getStringExtra("title");
        textView.setText(title);
        if (title.compareTo("Family Physicians")==0){
            doctor_details=doctor_details0;
        }else if (title.compareTo("Dietician")==0){
            doctor_details=doctor_details1;
        }else if (title.compareTo("Dentist")==0){
            doctor_details=doctor_details2;
        }else if (title.compareTo("Surgeon")==0){
            doctor_details=doctor_details3;
        }else if (title.compareTo("Cardiologist")==0){
            doctor_details=doctor_details4;
        }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctor.class));
            }
        });

        list =new ArrayList<>();
        for (int i=0;i<doctor_details.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4","Cons Fees:"+doctor_details[i][3]+"/-");
            list.add(item);
        }
    simpleAdapter=new SimpleAdapter(this,list,R.layout.multi_line,
            new String[]{"line1","line2","line3","line4"},
           new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d} );

        ListView lst=findViewById(R.id.listViewCart);
        lst.setAdapter(simpleAdapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it=new Intent(DoctorDetailsActivity.this,BookApoinment.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[position][0]);
                it.putExtra("text3",doctor_details[position][1]);
                it.putExtra("text4",doctor_details[position][2]);
                it.putExtra("text5",doctor_details[position][3]);
                startActivity(it);
            }
        });

    }
}