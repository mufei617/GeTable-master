package com.example.prjgetable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.navigation.findNavController;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
//import net.onefivefour.android.ebtimetracker.R;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import model.restaurant;

public class activity_home extends AppCompatActivity implements View.OnClickListener, NavigationBarView.OnItemSelectedListener {
    BottomNavigationView navigationView;
    NavController navController;
    ListView lvresturants;
    ArrayList<String> listofrestaurant = new ArrayList<>();
    DatabaseReference restaurantdatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_home);


        navigationView = findViewById(R.id.bottomNavigationView);
        //navigationView.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) this);
        initialize();
    }

    private void initialize(){
        ArrayAdapter<String> restaurantArrayAdapter = new ArrayAdapter<String>(activity_home.this, android.R.layout.simple_list_item_1,listofrestaurant);
        lvresturants = (ListView) findViewById(R.id.tvRestaurantList);
        lvresturants.setAdapter(restaurantArrayAdapter);
        restaurantdatabase = FirebaseDatabase.getInstance().getReference();

        restaurantdatabase.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                String value = snapshot.getValue(String.class);
                listofrestaurant.add(value);
                restaurantArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                restaurantArrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
    @Override
    public void onClick(View view) {
        int name = view.getId();
        switch(name){
            case R.id.tvRestaurantList:gotoresturantprofile();break;
        }

    }
    private void gotoresturantprofile()
    {
        Intent intent = new Intent(this, activity_restaurant_profile.class);
        startActivity(intent);

    }

    @Deprecated
    public void onNavigationItemReselected(MenuItem item) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.activity_profileTab:
                Toast.makeText(this, "MAHAN HASTAM", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, activity_profile.class);
                startActivity(intent);
                break;
            case R.id.activity_homeRestaurant:
                Intent intent1 = new Intent(this, activity_home.class);
                startActivity(intent1);
                break;
            case R.id.activity_reserved:

                Intent intent2 = new Intent(this, activity_reserved.class);
                startActivity(intent2);
                break;
            default:
                return false;
        }

        return true;
    }

}