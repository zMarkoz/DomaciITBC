package com.rentacar.Model.Request.ContractRequestModel;

import java.time.LocalDate;

public class ContractSample {
    private String userId, carId;
    private LocalDate startDate, endDate;

    public ContractSample(String userId,
                          String carId,
                          LocalDate startDate,
                          LocalDate endDate)
    {
        this.userId = userId;
        this.carId = carId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getUserId() {
        return userId;
    }

    public String getCarId() {
        return carId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
