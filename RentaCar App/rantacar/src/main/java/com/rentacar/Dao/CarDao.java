package com.rentacar.Dao;

import com.rentacar.Connection.DbConnection;
import com.rentacar.Model.Request.CarRequstModel.AddCarRequestModel;
import com.rentacar.Model.Request.CarRequstModel.UpdateCarRequestModel;
import com.rentacar.Model.Response.CarResponseModel.GetCarResponseModel;
import com.rentacar.Model.Response.SearchCarModel;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

public interface CarDao {

    Connection conn = DbConnection.getConnection();

    List<GetCarResponseModel> getAllCars();

    List<GetCarResponseModel> searchCars(SearchCarModel searchCarModel, List<GetCarResponseModel> cars);

    List<GetCarResponseModel> getAvailableCars(LocalDate startDate, LocalDate endDate);

    boolean isCarAvailable(LocalDate startDate, LocalDate endDate, String carId);

    GetCarResponseModel getCar(String id);

    void updateCarInfo(String id, UpdateCarRequestModel carInfo);

    void delete(String id);

    void addCar(AddCarRequestModel car);

    double getPrice(String id);


}

