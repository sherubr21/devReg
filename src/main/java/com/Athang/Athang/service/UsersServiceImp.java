package com.Athang.Athang.service;

import com.Athang.Athang.dto.LoginDto;
import com.Athang.Athang.message.LoginMesage;
import com.Athang.Athang.model.LkpUserType;
import com.Athang.Athang.model.Users;
import com.Athang.Athang.repository.LkpUserTypeRespository;
import com.Athang.Athang.repository.UsersRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImp implements UsersService{
    @Autowired
    LkpUserTypeRespository lkpUserTypeRespository;
    @Autowired
   private UsersRespository usersRespository;

    @Override
    public Users createUserWithUserType(Users user, LkpUserType userType) {
        user.setType(userType);
        return usersRespository.save(user);
    }

// @Override
    //public Users adduser(Users users) {
        //return usersRespository.save(users);
    //}


@Override
    public List<Users> getUsers() {
        return usersRespository.findAll();
    }

    @Override
    public LoginMesage loginUser(LoginDto loginDto) {
        String mes="";
        Users users1=usersRespository.findByEmail(loginDto.getEmail());
        if(users1 !=null){
            Optional<Users> users=usersRespository.findOneByEmailAndPassword(loginDto.getEmail(),loginDto.getPassword());
                if(users.isPresent()){
                    return new LoginMesage("1",true);
                }else{
                    return new LoginMesage("2", false);
                }

        }else{
            return new LoginMesage("3",false);
        }
        //
    }
/* @Override
    public Users updateUsers(Integer id, Users users) {
        Optional<Users> exuseropt=usersRespository.findById(id);
        if(exuseropt.isPresent()){
            Users exuser=exuseropt.get();
            exuser.setName(users.getName());
            exuser.setEmail(users.getEmail());
            exuser.setPassword(users.getPassword());
            exuser.setType(users.getType());

            return usersRespository.save(exuser);

        }else{
            throw new IllegalArgumentException(" ID " + id + " not found");
        }
    }

    @Override
    public void deleteUser(Integer id) {
      usersRespository.deleteById(id);
    }*/
}
