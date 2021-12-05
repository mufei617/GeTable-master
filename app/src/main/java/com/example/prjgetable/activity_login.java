package com.example.prjgetable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class activity_login extends AppCompatActivity implements View.OnClickListener, ValueEventListener {

    EditText email, password;
    Button btnlogin,gotosignup;
    DatabaseReference userdatabase,userChildemail,userchildpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        initialize();

    }
    private  void initialize(){
        email = findViewById(R.id.edEmail);
        password = findViewById(R.id.edPass);
        //忘记密码没写
        gotosignup = findViewById(R.id.tvSignUp);
        btnlogin = findViewById(R.id.tvLogin);

        gotosignup.setOnClickListener(this);
        btnlogin.setOnClickListener(this);
        userdatabase = FirebaseDatabase.getInstance().getReference("user");

    }

    @Override
    public void onClick(View view) {
        int name = view.getId();
        switch(name){
            case R.id.tvSignUp:gotosignup();break;
            case R.id.tvLogin:btnlogin();break;
        }
    }

    private void btnlogin() {


        String logemail = email.getText().toString();
        String logpassword = password.getText().toString();

        if(TextUtils.isEmpty(logemail))
        {
            email.setError("plz enter email");
            return;
        }

        if(TextUtils.isEmpty(logpassword))
        {
            password.setError("plz enter password");
            return;
        }

        userChildemail = FirebaseDatabase.getInstance().getReference().child("user").child(logemail);
        userChildemail.addValueEventListener(this);
        userchildpass = FirebaseDatabase.getInstance().getReference().child("user").child(logpassword);




    }

    private void gotosignup() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {

        if(snapshot.exists()){
            Intent intent = new Intent(this, activity_home.class);
            startActivity(intent);

        }else{
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
}