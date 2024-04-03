package com.Athang.Athang.service;


import com.Athang.Athang.model.Doc;
import com.Athang.Athang.repository.DocRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocServiceImp implements DocService{
    @Autowired
    private DocRespository docRespository;

    @Override
    public Doc saveDoc(Doc doc) {
        return docRespository.save(doc);
    }

    @Override
    public List<Doc> getDoc() {
        return docRespository.findAll();
    }

    @Override
    public Doc updateDoc(Integer id, Doc doc) {
        Optional<Doc> exobj=docRespository.findById(id);
        if(exobj.isPresent()){
            Doc exdoc=exobj.get();
            exdoc.setName(doc.getName());
            exdoc.setUser_id(doc.getUser_id());
            exdoc.setType(doc.getType());
            exdoc.setPath(doc.getPath());
            return docRespository.save(exdoc);

        }else{
            throw new IllegalArgumentException("Doc with ID " + id + " not found");

        }
    }

    @Override
    public void deleteDoc(Integer id) {
        docRespository.deleteById(id);

    }
}
