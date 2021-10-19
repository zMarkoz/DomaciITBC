package com.rentacar.Controller;

import com.rentacar.Dao.*;
import com.rentacar.Model.Request.CarRequstModel.AddCarRequestModel;
import com.rentacar.Model.Request.CarRequstModel.UpdateCarRequestModel;
import com.rentacar.Model.Response.CarResponseModel.GetCarResponseModel;
import com.rentacar.Model.Response.SearchCarModel;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController

public class CarsController {
    private CarDao carDao = new CarDaoSQL();
    private UserDao userDao = new UserDaoSQL();
    private ContractDao contractDao = new ContractDaoSQL();
///cars - GET
//    Враћа све аутомобиле
    @GetMapping("/cars")
    public List<GetCarResponseModel> getAllCars() {
        return carDao.getAllCars();
    }

//    /cars/search - GET
//    Query параметри:
//    year - int - Више или једнако
//    make - string - Да ли садржи неки текст
//    model - string
//    automatic - boolean
//    price - double - Мање или једнако прослеђеној вредности
//    power - int - Мање или једнако
//    doors - int
    @GetMapping("/cars/search")
    public List<GetCarResponseModel> searchCars(@RequestParam(required = false) String make,
                                                @RequestParam(required = false) String model,
                                                @RequestParam(required = false) Integer year,
                                                @RequestParam(required = false) Boolean automatic,
                                                @RequestParam(required = false) Double price,
                                                @RequestParam(required = false) Integer power,
                                                @RequestParam(required = false) Integer doors) {
        return carDao.searchCars(new SearchCarModel
                        (make,
                        model,
                        year,
                        power,
                        doors,
                        price,
                        automatic),

                carDao.getAllCars());
    }
//    /cars/{carId} - GET
//    Дохвата информације о једном аутомобилу


    @GetMapping("/cars/{carId}")
    public GetCarResponseModel getCar(@PathVariable("carId") String id)
    {
        return carDao.getCar(id);
    }

//    /cars/{carId} - PATCH
//    Мења аутомобил (Ово може да ради само администратор)
//    Кроз header се прослеђује id админа

    @PatchMapping("/cars/{carId}")

    public void updateCar(@PathVariable("carId") String carId,
                          @RequestHeader("authorization") String adminId,
                          @RequestBody UpdateCarRequestModel carInfo) {


        if (!userDao.isAdmin(adminId)) {
            return;
        }
        carDao.updateCarInfo(carId, carInfo);

    }

///cars/{carId} - DELETE
//    Брише аутомобил са датим id - (Само админ)
//    Кроз header се прослеђује id админа
    @DeleteMapping("/cars/{carId}")

    public void deleteCar(@PathVariable("carId") String carId,
                          @RequestHeader("authorization") String adminId) {
        if (!userDao.isAdmin(adminId)) {
            return;
        }
        carDao.delete(carId);
    }
//    /cars - POST
//    Додаје нови аутомобил - (Само админ)
//    Кроз header се прослеђује id админа

    @PostMapping("/cars")
    public void addCar(@RequestHeader("authorization") String adminId,
                       @RequestBody AddCarRequestModel car) {
        if (!userDao.isAdmin(adminId)) {
            return;
        }
        carDao.addCar(car);
    }

//    /cars/available? - GET
//    Дохвата све доступне аутомобиле
//    startDate и endDate се прослеђују као query параметри

    @GetMapping("/cars/available")
    public List<GetCarResponseModel> availableCars(@RequestParam String startDate,
                                                   @RequestParam String endDate) {
        LocalDate startDateLocal = LocalDate.parse(startDate);
        LocalDate endDateLocal = LocalDate.parse(endDate);
        return carDao.getAvailableCars(startDateLocal, endDateLocal);
    }

//    /cars/available/search? - GET
//    Дохвата све доступне аутомобиле
//    startDate и endDate се прослеђују као query параметри (обавезни)

    @GetMapping("/cars/available/search")
    public List<GetCarResponseModel> searchCars(@RequestParam String startDate,
                                                @RequestParam String endDate,
                                                @RequestParam(required = false) String make,
                                                @RequestParam(required = false) String model,
                                                @RequestParam(required = false) Integer year,
                                                @RequestParam(required = false) Boolean automatic,
                                                @RequestParam(required = false) Double price,
                                                @RequestParam(required = false) Integer power,
                                                @RequestParam(required = false) Integer doors) {
        LocalDate startDateLocal = LocalDate.parse(startDate);
        LocalDate endDateLocal = LocalDate.parse(endDate);
        return carDao.searchCars(new SearchCarModel(make, model, year, power, doors, price, automatic),
                carDao.getAvailableCars(startDateLocal, endDateLocal));

    }

//    /cars/{carId}/calendar - GET
//    Враћа листу свих датума који нису доступни за одређени аутомобил
//    Ову информацију имамо у уговорима
//    Чак и ако нису одобрени уговори, те датуме сматрамо заузетим

    @GetMapping("/cars/{carId}/calendar")
    public List<LocalDate> getCarOccupied(@PathVariable("carId") String id) {
        return contractDao.getCarOccupiedDates(id);
    }

}