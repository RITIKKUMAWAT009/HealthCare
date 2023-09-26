package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {


    private String[][] packages={
            {"Package 1: Full Body Checkup","",""," 999"},
            {"Package 2: Blood Glucose Fasting","",""," 299"},
            {"Package 3: COVID-19 Antibody - IgG","",""," 899"},
            {"Package 4: Thyroid Check","",""," 699"},
            {"Package 5: Immunity Check","",""," 300"}
    };
    private  String[] package_details={
            "Blood Glucose Fasting\n"+
                    "Complete Hemogram\n"
            +"HbAic\n"+
                    "Iron Studies\n"+
                    "Kidney Function Test\n"+
                    "LDH Lactate dehydrogenase,Serum\n"+
                    "Lipid Profile\n" +
                    "Liver Function\n",
            "Blood Glucose Fasting\n",
                    "COVID-19 Antibody\n",
                    "Thyroid Profile-total",
                    "Complete Hemogram\n"
                    +"HbAic\n"+
                    "Iron Studies\n"+"Kidney Function Test\n"+
                    "LDH Lactate dehydrogenase,Serum\n"+
                    "Lipid Profile\n" +"Liver Function\n"
    };

HashMap<String,String>item;
ArrayList list;
SimpleAdapter simpleAdapter;
    Button backbtn,goToCartbtnl;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        goToCartbtnl=findViewById(R.id.btnCartBack);
        backbtn=findViewById(R.id.btnCartCheckout);
        listView=findViewById(R.id.listViewCart);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this,HomeActivity.class));
            }
        });

list=new ArrayList();
for (int i=0;i<packages.length;i++){
    item=new HashMap<String,String>();
    item.put("line1",packages[i][0]);
    item.put("line2",packages[i][1]);
    item.put("line3",packages[i][2]);
    item.put("line4","Total Cost "+packages[i][3]+" /-");
    list.add(item);

}
simpleAdapter=new SimpleAdapter(this,list,R.layout.multi_line,
        new String[]{"line1","line2","line3","line4"},
        new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d});
listView.setAdapter(simpleAdapter);


listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent it=new Intent(LabTestActivity.this,LabTestDetailActivity.class);
        it.putExtra("text1",packages[position][0]);
        it.putExtra("text2",package_details[position]);
        it.putExtra("text3",packages[position][3]);
        startActivity(it);

    }
});
goToCartbtnl.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       startActivity(new Intent(LabTestActivity.this, CartLabActivity.class));
    }
});

    }
}