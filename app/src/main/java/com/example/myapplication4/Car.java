package com.example.myapplication4;

public class Car {
    String nameCar, carCompany;
    Double price;

    public Car(String nameCar, String carCompany, Double price) {
        this.nameCar = nameCar;
        this.carCompany = carCompany;
        this.price = price;
    }

    public Car() {
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public String getCarCompany() {
        return carCompany;
    }

    public void setCarCompany(String carCompany) {
        this.carCompany = carCompany;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
