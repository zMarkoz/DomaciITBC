package com.rentacar.Controller;

import com.rentacar.Dao.UserDao;
import com.rentacar.Dao.UserDaoSQL;
import com.rentacar.Model.Request.AdminRequsetModel.AdminUpdateUserInfo;
import com.rentacar.Model.Response.AdminResponseModel.AdminUpdateResponseModel;
import com.rentacar.Model.Response.AdminUpdateUserModel;
import org.springframework.web.bind.annotation.*;

import static com.rentacar.validation.Validation.isEmailValid;


@RestController
public class AdminController {
    UserDao userDao = new UserDaoSQL();

///       admin/update/{id} - PATCH
//        Администраторско мењање корисника са id-јем из путање
//        Водити рачуна о валидности добијених података
//        Радити update само валидних поља
//        Кроз header се прослеђује id админа

    @PatchMapping("/admin/update/{id}")
    public AdminUpdateResponseModel
    changeUserInformation(@PathVariable("id") String userId,
                          @RequestHeader("authorization") String adminId,
                          @RequestBody AdminUpdateUserInfo info) {
        if (!userDao.isAdmin(adminId)) {
            return new AdminUpdateResponseModel
                    (false, "You don't have Admin authorization!");
        }

        String username = info.getUsername();
        String email = info.getEmail();

        if ((!username.isEmpty()) && username.length() < 3) {
            username = "";
        }
        if ((!email.isEmpty()) && !isEmailValid(email)) {
            email = "";
        }
        if (username.isEmpty() && email.isEmpty() && info.getFirstName().isEmpty()
                && info.getLastName().isEmpty() && info.getPersonalNumber().isEmpty()
                && info.getPhoneNumber().isEmpty() && info.getImage().isEmpty()) {
            return new AdminUpdateResponseModel(false, "Update failed!");
        }
        AdminUpdateUserModel userInfo = new AdminUpdateUserModel(username, email, info.getFirstName(),
                info.getLastName(), info.getPhoneNumber(), info.getPersonalNumber(), info.getImage());

        userDao.adminUpdateUserInfo(userInfo, userId);
        return new AdminUpdateResponseModel(true, "Update is Successful!");
    }
}

