package com.rentacar.Controller;

import com.rentacar.Dao.*;
import com.rentacar.Model.Request.ContractRequestModel.ContractApproved;
import com.rentacar.Model.Request.ContractRequestModel.SignedContract;
import com.rentacar.Model.Response.ContractResponseModel.ContractResponseModel;
import com.rentacar.Model.Response.ContractResponseModel.ContractSampleResponseModel;
import com.rentacar.Model.Response.ContractResponseModel.SignedContractResponseModel;
import com.rentacar.Model.Request.ContractRequestModel.ContractSample;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;


@RestController
public class ContractsController {
    private static ContractDao contractDao = new ContractDaoSQL();
    private static CarDao carDao = new CarDaoSQL();
    private static UserDao userDao = new UserDaoSQL();


    private static double getContractPrice(LocalDate startDate, LocalDate endDate, String carId) {
        double price = carDao.getPrice(carId);
        int days = (int) DAYS.between(startDate, endDate) + 1;
        return price * days;
    }

//    /contracts/sample - POST
//    Враћа нацрт уговора који клијент може да потпише и пошаље на одобравање

    @PostMapping("/contracts/sample")
    public ContractSampleResponseModel getContractSample(
            @RequestBody ContractSample conSample) {
        double contractPrice = getContractPrice(conSample.getStartDate(),
                conSample.getEndDate(), conSample.getCarId());

        return new ContractSampleResponseModel(conSample.getUserId(), conSample.getCarId(),
                conSample.getStartDate(), conSample.getEndDate(), contractPrice, false);
    }

//    /contracts - POST
//    Додаје нови уговор (Клијент)
//    Ово је нека врста резервације датума за клијента
//    Након овога, администратор или одбија или одобрава
//    Одбијање уговора значи брисање из базе (описано касније)
//    Клијент може да има највише један уговор на чекању

    @PostMapping("/contracts")
    public SignedContractResponseModel postSingedContract
            (@RequestBody SignedContract contract) {
        if (contractDao.userHasPendingContract(contract.getUserId())) {
            return new SignedContractResponseModel(false, "This user already waiting on contract");
        }
        if (!carDao.isCarAvailable(contract.getStartDate(), contract.getEndDate(), contract.getCarId())) {
            return new SignedContractResponseModel(false, "Not available in this range of time");
        }
        contractDao.addContractToDB(contract);
        return new SignedContractResponseModel(true, "Your contract have been successful created, waiting for approval!");
    }

//    /contracts - GET
//    Администратори могу да виде све уговоре
//    Кроз header се прослеђује id админа

    @GetMapping("/contracts")
    public List<ContractResponseModel> getAllcontracts(@RequestHeader("authorization") String adminId) {
        if (!userDao.isAdmin(adminId)) {
            return null;
        }
        return contractDao.getAllContracts();
    }

//    /contracts/pending - GET
//    Администратори могу да виде све неразрешене уговоре
//    Кроз header се прослеђује id админа
//    Враћа исто као пример изнад, али само уговоре који имају approved постављено на false

    @GetMapping("/contracts/pending")
    public List<ContractResponseModel> getAllPendingContracts
            (@RequestHeader("authorization") String adminId) {
        if (!userDao.isAdmin(adminId)) {
            return null;
        }
        return contractDao.getAllPendingContracts();
    }

//    /contracts/{contractId}/approval - POST
//    Администратор одобрава или одбија уговор
//    Ако га одбије - уговор се брише из базе
//    Ако га одобри - Уговор добија approved = true
//    Кроз header се прослеђује id админа



    @PostMapping("/contracts/{contractId}/approval")
    public void approveContract(@RequestHeader("authorization") String adminId,
                                @PathVariable("contractId") String contractId,
                                @RequestBody ContractApproved adminApproval) {

        if (!userDao.isAdmin(adminId)) {
            return;
        }
        if (adminApproval.isApproved()) {
            contractDao.updateContractApproval(contractId, true);
        } else
            contractDao.deleteContract(contractId);
    }

//    /contracts/{userId}/history - GET
//
//    Дохвата се историја уговора за клијента са датим id

    @GetMapping("/contracts/{userId}/history")
    public List<ContractResponseModel> getContractHistory(@PathVariable("userId") String id) {
        return contractDao.getContractHistory(id);
    }
}

