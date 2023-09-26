package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText etUserName,registerPassword,confirmPassword, etEmail ;
    Button btn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        etUserName=findViewById(R.id.etLTBFullName);
        etEmail=findViewById(R.id.etLTBAdd);
        registerPassword=findViewById(R.id.etLTBPinCode);
        confirmPassword=findViewById(R.id.etLTBContactNum);
        btn=findViewById(R.id.Bookappbtn);
        textView=findViewById(R.id.existingUswer);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=etUserName.getText().toString();
                String email=etEmail.getText().toString();
                String registerPass=registerPassword.getText().toString();
                String confirmPass=confirmPassword.getText().toString();
                Database db=new Database(getApplicationContext(),"healthcare",null,1);

                if (username.length()==0|| email.length()==0||registerPass.length()==0||confirmPass.length()==0){
                    Toast.makeText(RegisterActivity.this, "Please fill All details", Toast.LENGTH_SHORT).show();
                }
                else {
                    
                    if (registerPass.compareTo(confirmPass)==0){
                            if (registerPass.length()>8){
                                db.register(username,email,registerPass);
                                Toast.makeText(RegisterActivity.this, "Record Inserted", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));

                            }else {
                                Toast.makeText(RegisterActivity.this, "Password At least 8 Character Long", Toast.LENGTH_SHORT).show();
                            }
                    }else
                    {
                        Toast.makeText(RegisterActivity.this, "Password and Confirm Password didn't match", Toast.LENGTH_SHORT).show();
                    }
                    
                }


            }
        });


    }
}