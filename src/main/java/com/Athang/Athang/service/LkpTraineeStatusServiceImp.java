package com.Athang.Athang.service;

import com.Athang.Athang.model.Doc;
import com.Athang.Athang.model.LkpTraineeStatus;
import com.Athang.Athang.repository.LkpTraineeStatusRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LkpTraineeStatusServiceImp implements LkpTraineeStatusService{
    @Autowired
    LkpTraineeStatusRespository lkpTraineeStatusRespository;
    @Override
    public LkpTraineeStatus save(LkpTraineeStatus lkpTraineeStatus) {
        return lkpTraineeStatusRespository.save(lkpTraineeStatus);
    }

    @Override
    public List<LkpTraineeStatus> getAll() {
        return lkpTraineeStatusRespository.findAll();
    }

    @Override
    public LkpTraineeStatus update(Integer id, LkpTraineeStatus lkpTraineeStatus) {
        Optional<LkpTraineeStatus> exobj=lkpTraineeStatusRespository.findById(id);
        if(exobj.isPresent()){
            LkpTraineeStatus exdoc=exobj.get();
            exdoc.setName(lkpTraineeStatus.getName());

            return lkpTraineeStatusRespository.save(exdoc);

        }else{
            throw new IllegalArgumentException("ID " + id + " not found");

        }
    }

    @Override
    public void delete(Integer id) {
        lkpTraineeStatusRespository.deleteById(id);

    }
}
