package com.springweb.model;

public class Car {
	
	private int carId;
    private String manufacturer;
    private int model;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }
    
    @Override
    public String toString() {
        return "Car[carId=" + carId +", manufacturer='" + manufacturer + '\'' + ", model=" + model + ']';
    }

}
