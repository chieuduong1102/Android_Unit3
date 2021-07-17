package com.example.myapplication4;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CarAdapter extends BaseAdapter {
    Activity activity;
    List<Car> dataList;
    public CarAdapter(Activity activity,List<Car> dataList){
        this.activity = activity;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return this.dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView =  activity.getLayoutInflater().inflate(R.layout.car_item, null);
        TextView nameCar = convertView.findViewById(R.id.ci_carName);
        TextView carCompany = convertView.findViewById(R.id.ci_carCompany);
        TextView price = convertView.findViewById(R.id.ci_price);

        Car car = dataList.get(position);

        nameCar.setText(car.getNameCar());
        carCompany.setText(car.getCarCompany());
        price.setText(car.getPrice().toString()+" $");

        return convertView;
    }
}
