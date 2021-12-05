package com.example.prjgetable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

import model.userreserve;

public class activity_reservation_time extends AppCompatActivity implements View.OnClickListener, CalendarView.OnDateChangeListener {

    CalendarView time;
    DatabaseReference userdatabase;
    Button requestTable;
    TextView seat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_reservation_time);
        initialize();
    }
    private void initialize() {
        time = (CalendarView) findViewById(R.id.reservedDate);
        requestTable = findViewById(R.id.btnRequestTable);
        seat = findViewById(R.id.edGuestNumber);

        requestTable.setOnClickListener( this);
        time.setOnDateChangeListener(this);

        userdatabase = FirebaseDatabase.getInstance().getReference("user");

    }

    @Override
    public void onClick(View view) {
        int name = view.getId();
        switch(name){
            case R.id.btnRequestTable:
                RequestTable();
                break;
            case R.id.reservedDate:
                findDate();
                break;
        }

    }

    private void findDate() {

    }

    private void RequestTable() {


    }

    @Override
    public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {

        int year = i ;
        int month = i1;
        int day = i2;
        String Seat = seat.getText().toString();
        userreserve date = new userreserve(year,month,day,Seat);


    }

}