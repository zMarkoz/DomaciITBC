package com.rentacar.Controller;

import com.rentacar.Dao.UserDao;
import com.rentacar.Dao.UserDaoSQL;
import com.rentacar.Model.Request.UserRequestModel.LoginUser;
import com.rentacar.Model.Request.UserRequestModel.RegisterUser;
import com.rentacar.Model.Request.UserRequestModel.UpdateUserInfo;
import com.rentacar.Model.Response.RegisterUserModel;
import com.rentacar.Model.Response.UpdateUserModel;
import com.rentacar.Model.Response.UserResponse.GetUserResponseModel;
import com.rentacar.Model.Response.UserResponse.UserLoginResponseModel;
import com.rentacar.Model.Response.UserResponse.UserRegisterResponseModel;
import com.rentacar.Model.Response.UserResponse.UserUpdateResponseModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rentacar.validation.Validation.*;

@RestController

public class UsersController {
    private static UserDao userDao = new UserDaoSQL();

///users/register - POST
//    username и email морају бити јединствени
//    email мора бити валидан
//    username мора имати барем 3 карактера
//    password мора имати барем 8 карактера, 1 број и 1 слово
//*password желимо да чувамо у бази енкриптован (на било који начин)

    @PostMapping("/users/register")
    public UserRegisterResponseModel register(@RequestBody RegisterUser user) {
        String username = user.getUsername();
        String email = user.getEmail();
        String password = user.getPassword();
        if (username.length() < 3) {
            return new UserRegisterResponseModel(false,
                    "Username must have more than 3 characters!");
        }
        if (!isPasswordValid(password)) {
            return new UserRegisterResponseModel(false,
                    "Invalid password!");
        }
        else {
            password = getSHA256(password);
        }
        if (!isEmailValid(email)) {
            return new UserRegisterResponseModel(false,
                    "Invalid Email!");
        }
        if (userDao.userNameTaken(username)) {
            return new UserRegisterResponseModel(false,
                    "This Userename is taken!");
        }
        if (userDao.emailExists(email)) {
            return new UserRegisterResponseModel(false,
                    "User already registered whit this Email!");
        }
        userDao.registerUser(new RegisterUserModel(username, email, password));
        return new UserRegisterResponseModel(true, "Registration successful!");

    }

//    2. /users/login - POST
//    Прослеђујемо или username или email

    @PostMapping("/users/login")
    public UserLoginResponseModel login(@RequestBody LoginUser user) {
        String identification = user.getIdentification();
        String password = getSHA256(user.getPassword());
        if (userDao.emailExists(identification) || userDao.userNameTaken(identification)) {
            if (password.equals(userDao.getPasswordWithApproval(identification)))
                return new UserLoginResponseModel(true, password);
        }
        return new UserLoginResponseModel(false,
                "Incorect password!");
    }

    ///users/{id} - PATCH
    //    Корисник сам мења на основу свог id-a
     //    Мењају се све прослеђене информације за корисника
    //    Не можемо мењати email и personal_number (Те ствари мења директно
     //            администратор)
    //    Водити рачуна о валидности добијених података
    //    Радити update само валидних поља
    //    Ако шифра није валидна, не радити update уопште


    @PatchMapping("/users/{id}")
    public UserUpdateResponseModel changeUserInfo(@PathVariable("id") String id,
                                                  @RequestBody UpdateUserInfo user){
        String password = getSHA256(user.getPassword());
        String newPassword = user.getNewPassword();
        if (!userDao.getPasswordWithUUID(id).equals(password)){
            return new UserUpdateResponseModel(false, "Incorrect Password");
        }
        if (!newPassword.isEmpty()) {
            if (!isPasswordValid(newPassword)) {
                return new UserUpdateResponseModel(false, "Type in valid password");
            }
            newPassword = getSHA256(newPassword);
        }
        UpdateUserModel updateUser = new UpdateUserModel(user.getUsername(), newPassword, user.getFirstName(),
                user.getLastName(), user.getPhoneNumber(), user.getImage());
        userDao.updateUser(updateUser, id);
        return new UserUpdateResponseModel(true, "Success!");
    }

//    /users/{id} - GET
//    Дохватамо све информације о кориснику

    @GetMapping("/users/{id}")
    public GetUserResponseModel getUser(@PathVariable("id") String id) {
        return userDao.getUser(id);
    }

//    /users - GET
//    Дохвата листу свих корисника
//    Кроз header се прослеђује id админа

    @GetMapping("/users")
    public List<GetUserResponseModel> getAllUsers(@RequestHeader("authorization") String id) {
        if (userDao.isAdmin(id)) {
            return userDao.getAllUsers();
        }
        return null;
    }
}