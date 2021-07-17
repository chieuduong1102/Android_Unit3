package com.example.myapplication4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listViewCar;
    List<Car> listCar = new ArrayList<Car>();
    ImageView imgView;
    CarAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewCar = findViewById(R.id.am_listView);
        imgView = findViewById(R.id.ci_imgView);
        for (int i = 1; i < 4; i++){
            listCar.add(new Car("Car" + i, "Company" + i, (double) Math.round((Math.random() * 1000000 + 500000)*100)/100));
        }

        adapter = new CarAdapter(this, listCar);
        listViewCar.setAdapter(adapter);
        registerForContextMenu(listViewCar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case  R.id.menu_addNew:
                showCarDialog(null);
                break;
            case R.id.menu_exit:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuContext = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int positon = menuContext.position;
        switch (item.getItemId()){
            case R.id.menu_c_edit:
                showCarDialog(positon);
                break;
            case R.id.menu_c_remove:
                listCar.remove(positon);
                adapter.notifyDataSetChanged();
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void showCarDialog(Integer postion) {
        View viewEditCar = getLayoutInflater().inflate(R.layout.dialog_car_edit, null);
        EditText carName = viewEditCar.findViewById(R.id.dce_carName);
        EditText carCompany = viewEditCar.findViewById(R.id.dce_carCompany);
        EditText price = viewEditCar.findViewById(R.id.dce_price);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Add New Car");
        builder.setView(viewEditCar);
        if(postion != null) {
            carName.setText(listCar.get(postion).getNameCar());
            carCompany.setText(listCar.get(postion).getCarCompany());
            price.setText(listCar.get(postion).getPrice().toString());
        }
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(postion!=null){
                    String txtCarName = carName.getText().toString();
                    String txtCarCompany = carCompany.getText().toString();
                    Double douPrice = (double) Math.round(Double.parseDouble(price.getText().toString())) * 100 / 10000;

                    listCar.get(postion).setNameCar(txtCarName);
                    listCar.get(postion).setCarCompany(txtCarName);
                    Double douPrice1 = (double) Math.round(Double.parseDouble(price.getText().toString())) * 100 / 10000;
                    listCar.get(postion).setPrice(douPrice1);
                    adapter.notifyDataSetChanged();
                } else {
                    String txtCarName = carName.getText().toString();
                    String txtCarCompany = carCompany.getText().toString();
                    Double douPrice2 = (double) Math.round(Double.parseDouble(price.getText().toString())) * 100 / 10000;
                    listCar.add(new Car(txtCarName, txtCarCompany, douPrice2));
                    adapter.notifyDataSetChanged();
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
}