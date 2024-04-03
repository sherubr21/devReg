package com.Athang.Athang.service;


import com.Athang.Athang.model.LkpUserType;
import com.Athang.Athang.repository.LkpUserTypeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LkpUserTypeServicesImp implements LkpUserTypeService {
    @Autowired
    private LkpUserTypeRespository lkpUserTypeRespository;
    @Override
    public LkpUserType saveType(LkpUserType lkpUserType) {
        return lkpUserTypeRespository.save(lkpUserType);
    }

    @Override
    public List<LkpUserType> getType() {
        return lkpUserTypeRespository.findAll();
    }

    @Override
    public LkpUserType updateType(Integer id, LkpUserType lkpUserType) {
        Optional<LkpUserType> exobj=lkpUserTypeRespository.findById(id);
        if(exobj.isPresent()){
            LkpUserType exusertyp=exobj.get();
            exusertyp.setName(lkpUserType.getName());
            return lkpUserTypeRespository.save(exusertyp);

        }else{
            throw new IllegalArgumentException("ID " + id + " not found");
        }


    }

    @Override
    public void deleteType(Integer id) {
        lkpUserTypeRespository.deleteById(id);
    }
}
