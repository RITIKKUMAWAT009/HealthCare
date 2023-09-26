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
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

EditText etUserName,loginPassword;
Button btn;
TextView textView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUserName=findViewById(R.id.loginUserName);
        loginPassword=findViewById(R.id.loginPassword);
       btn=findViewById(R.id.loginbtn);
        textView=findViewById(R.id.newUser);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=etUserName.getText().toString();
                String password=loginPassword.getText().toString();
                Database db=new Database(getApplicationContext(),"healthcare",null,1);

                if (username.length()==0||password.length()==0){
                    Toast.makeText(LoginActivity.this, "Please fill All details", Toast.LENGTH_SHORT).show();
                }else {
                            if(db.login(username,password)==1) {

                                Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();

                                SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor=sharedPreferences.edit();
                                editor.putString("username",username);
                                //to save our data with key and Value
                                editor.apply();
                                startActivity(new Intent(LoginActivity.this,HomeActivity.class));


                            }else {
                                Toast.makeText(LoginActivity.this, "Invalid Username and Password", Toast.LENGTH_SHORT).show();
                            }
                }

                }

        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });


    }
}