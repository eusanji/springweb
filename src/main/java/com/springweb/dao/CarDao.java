package com.springweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.springweb.model.Car;
import com.springweb.util.DbUtil;

public class CarDao {

	private Connection connection;

    public CarDao(){
        connection = DbUtil.getConnection();
    }

    public void insertCar(Car car) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into Cars(manufacturer,model) values (?,?)");
        preparedStatement.setString(1, car.getManufacturer());
        preparedStatement.setInt(2, car.getModel());
        preparedStatement.execute();
    }

    public void deleteCar(int carId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from cars where carId=?");
        preparedStatement.setInt(1, carId);
        preparedStatement.executeUpdate();
    }

    public void updateCar(Car car) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update cars set manufacturer=?, model=?" +
                "where carId=?");
        preparedStatement.setString(1, car.getManufacturer());
        preparedStatement.setInt(2, car.getModel());
        preparedStatement.executeUpdate();
    }

    public List<Car> getAllCars() throws SQLException {
        List<Car> cars = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from cars");
        while (rs.next()){
            Car car = new Car();
            car.setCarId(rs.getInt("carId"));
            car.setManufacturer(rs.getString("manufacturer"));
            car.setModel(rs.getInt("model"));
            cars.add(car);
        }
        return cars;
    }

    public Car getCarById(int carId) throws SQLException {
        Car car = new Car();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from cars where carId=?");
        preparedStatement.setInt(1, carId);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()){
            car.setCarId(rs.getInt("cardId"));
            car.setManufacturer(rs.getString("manufacturer"));
            car.setModel(rs.getInt("model"));
        }
        return car;
    }

}
