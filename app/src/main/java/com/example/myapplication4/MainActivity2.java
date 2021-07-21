package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Car> listCar = new ArrayList<Car>();
    CarAdapter2 adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.am2_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        for (int i = 1; i < 4; i++){
            listCar.add(new Car("Car" + i, "Company" + i, 2000.00));
        }

        adapter2 = new CarAdapter2(this, listCar);
        recyclerView.setAdapter(adapter2);



    }
}