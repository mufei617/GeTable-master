package com.example.prjgetable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import model.user;
import model.userreserve;

public class activity_table_selection extends AppCompatActivity implements View.OnClickListener {

    EditText
            tableNumber;
    TextView getTable1,getTable2,getTable3,getTable4,getTable5,getTable6,getTable7,
            getTable8,getTable9,getTable10,getTable11,getTable12,getTable13,getTable14;
    Button gotoSelectTime;
    DatabaseReference userdatabase;//




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_table_selection);
        initialize();

    }
    private  void initialize(){
        tableNumber = findViewById(R.id.edTableNumber);
        gotoSelectTime = findViewById(R.id.button);

        gotoSelectTime.setOnClickListener(this);
        getTable1.setOnClickListener(this);
        getTable2.setOnClickListener(this);
        getTable3.setOnClickListener(this);
        getTable4.setOnClickListener(this);
        getTable5.setOnClickListener(this);
        getTable6.setOnClickListener(this);
        getTable7.setOnClickListener(this);
        getTable8.setOnClickListener(this);
        getTable9.setOnClickListener(this);
        getTable10.setOnClickListener(this);
        getTable11.setOnClickListener(this);
        getTable12.setOnClickListener(this);
        getTable13.setOnClickListener(this);
        getTable14.setOnClickListener(this);


        userdatabase = FirebaseDatabase.getInstance().getReference("reservation");

    }


    @Override
    public void onClick(View view) {
        int name = view.getId();
        switch(name){
            case R.id.table1:
                tableNumber.setText("1");
                break;
            case R.id.table2:tableNumber.setText("2");break;
            case R.id.table3:tableNumber.setText("3");break;
            case R.id.table4:tableNumber.setText("4");break;
            case R.id.table5:tableNumber.setText("5");break;
            case R.id.table6:tableNumber.setText("6");break;
            case R.id.table7:tableNumber.setText("7");break;
            case R.id.table8:tableNumber.setText("8");break;
            case R.id.table9:tableNumber.setText("9");break;
            case R.id.table10:tableNumber.setText("10");break;
            case R.id.table11:tableNumber.setText("11");break;
            case R.id.table12:tableNumber.setText("12");break;
            case R.id.table13:tableNumber.setText("13");break;
            case R.id.table14:tableNumber.setText("14");break;
            case R.id.button:continuereserve();break;


        }
    }

    private void continuereserve() {
        String number = tableNumber.getText().toString();
//不是login用户的table，没有锁定
        userreserve userreserve = new userreserve(number);
        userdatabase.child(tableNumber.getText().toString()).setValue(userreserve);
        Toast.makeText(this, "the document with the identifer"+number+"is added！", Toast.LENGTH_SHORT).show();

    }


}