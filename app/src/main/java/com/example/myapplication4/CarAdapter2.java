package com.example.myapplication4;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarAdapter2 extends RecyclerView.Adapter<CarAdapter2.CarHolder> {
        Activity activity;
        List<Car> listData;

        public CarAdapter2(Activity activity, List<Car> listData){
            this.activity = activity;
            this.listData = listData;
        }


    @Override
    public CarAdapter2.CarHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = activity.getLayoutInflater().inflate(R.layout.car_item, null);
        TextView nameCar = view.findViewById(R.id.ci_carName);
        TextView carCompany = view.findViewById(R.id.ci_carCompany);
        TextView price = view.findViewById(R.id.ci_price);
        CarHolder holder = new CarHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CarAdapter2.CarHolder holder, int position) {
        Car car = listData.get(position);

        holder.nameCar.setText(car.getNameCar());
        holder.carCompany.setText(car.getCarCompany());
        holder.price.setText(car.getPrice().toString());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }


    class CarHolder extends RecyclerView.ViewHolder{
        TextView nameCar;
        TextView carCompany;
        TextView price;

        public CarHolder(View itemView, TextView nameCar, TextView carCompany, TextView price) {
            super(itemView);
            this.nameCar = nameCar;
            this.carCompany = carCompany;
            this.price = price;
        }

        public CarHolder(View itemView){
                super(itemView);
            }
    }
}
