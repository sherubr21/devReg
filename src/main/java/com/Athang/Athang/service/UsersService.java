package com.Athang.Athang.service;

import com.Athang.Athang.dto.LoginDto;
import com.Athang.Athang.message.LoginMesage;
import com.Athang.Athang.model.LkpUserType;
import com.Athang.Athang.model.Users;

import java.util.List;

public interface UsersService {
    Users createUserWithUserType(Users user, LkpUserType userType);
    //Users adduser(Integer utypeid,Users users);
    //LkpUserType craeteUserType(LkpUserType lkpUserType);
    List<Users> getUsers();

    LoginMesage loginUser(LoginDto loginDto);

    /*Users updateUsers(Integer id,Users users);

    void deleteUser(Integer id);*/
}
