package com.Athang.Athang.controller;


import com.Athang.Athang.model.Doc;
import com.Athang.Athang.service.DocService;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doc")
@CrossOrigin
public class DocController {
    @Autowired
    private DocService docService;
    @PostMapping

    public Doc add(@RequestBody Doc doc){
        return docService.saveDoc(doc);

    }
     @GetMapping("/getall")
    public List<Doc> getDoc(){
        return docService.getDoc();
    }
    @PutMapping("/update/{id}")

    public ResponseEntity<Doc> update(@PathVariable Integer id,@RequestBody Doc doc){
        Doc updDoc=docService.updateDoc(id,doc);
        if(updDoc !=null){
           return ResponseEntity.ok(updDoc);
        }else{
            return ResponseEntity.notFound().build();
        }


    }
     @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        docService.deleteDoc(id);
    }

}
