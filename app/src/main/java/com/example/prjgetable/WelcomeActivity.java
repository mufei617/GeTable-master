package com.example.prjgetable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;


public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);

        Initialize();
    }


    private void Initialize() {

        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
       int id = view.getId();
        switch (id){
            case R.id.btnSignUp: {
                Intent intent = new Intent(this, SignUpActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.btnLogin: {
                Intent intent = new Intent(this, activity_login.class);
                startActivity(intent);
            }
        }

    }


}



