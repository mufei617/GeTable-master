package com.example.prjgetable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import model.user;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name,password,email;
    Button signin, gotologin;
    DatabaseReference userdatabase;//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_signup);
        initialize();
    }
    private  void initialize(){
        email = findViewById(R.id.edEmail);
        password = findViewById(R.id.edPass);
        name = findViewById(R.id.edFullName);

        signin = findViewById(R.id.tvSignUp);
        gotologin = findViewById(R.id.tvHaveAccount);

        signin.setOnClickListener(this);
        gotologin.setOnClickListener(this);
        userdatabase = FirebaseDatabase.getInstance().getReference("user");



    }


    @Override
    public void onClick(View view) {
        int name = view.getId();
        switch(name){
            case R.id.tvSignUp:signup();break;
            case R.id.tvHaveAccount:gotoLoginPage();break;
        }

    }

    private  void gotoLoginPage(){
        Intent intent = new Intent(this, activity_login.class);
        startActivity(intent);
    }
    private  void signup()
    {
        String Name = name.getText().toString();
        String Email = email.getText().toString();
        String Password = password.getText().toString();

        user auser = new user(Name,Password,Email);
        userdatabase.child(name.getText().toString()).setValue(auser);


        Toast.makeText(this, "the document with the identifer"+Email+"is added！", Toast.LENGTH_SHORT).show();
    }

}