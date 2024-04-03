package com.Athang.Athang.service;

import com.Athang.Athang.model.LkpCourse;
import com.Athang.Athang.model.LkpDoc;
import com.Athang.Athang.repository.LkpDocRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LkpDocServiceImp implements LkpDocService{
    @Autowired
    private LkpDocRespository lkpDocRespository;
    @Override
    public LkpDoc saveLkpDoc(LkpDoc lkpDoc) {
        return lkpDocRespository.save(lkpDoc);
    }

    @Override
    public List<LkpDoc> getLkpDoc() {
        return lkpDocRespository.findAll();
    }

    @Override
    public LkpDoc upDateLkpDoc(Integer id, LkpDoc lkpDoc) {
        Optional<LkpDoc> lkpObj=lkpDocRespository.findById(id);
        if(lkpObj.isPresent()){
            LkpDoc lkp=lkpObj.get();
            lkp.setName(lkpDoc.getName());

            return lkpDocRespository.save(lkp);

        }else{

            throw new IllegalArgumentException("Doc type with ID " + id + " not found");

        }
    }

    @Override
    public void deleteLkpdoc(Integer id) {
        lkpDocRespository.deleteById(id);

    }
}
