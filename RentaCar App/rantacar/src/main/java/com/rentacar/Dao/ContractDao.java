package com.rentacar.Dao;

import com.rentacar.Connection.DbConnection;
import com.rentacar.Model.Request.ContractRequestModel.SignedContract;
import com.rentacar.Model.Response.ContractResponseModel.ContractResponseModel;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

public interface ContractDao {
    Connection conn = DbConnection.getConnection();

    List<LocalDate> getCarOccupiedDates(String carId);

    List<ContractResponseModel> getAllContracts();

    List<ContractResponseModel> getAllPendingContracts();

    List<ContractResponseModel> getContractHistory(String userId);

    void deleteContract(String contractId);

    void updateContractApproval(String contractId, Boolean approval);

    boolean userHasPendingContract(String userId);

    void addContractToDB(SignedContract contract);
}
