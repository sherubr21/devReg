package com.Athang.Athang.service;

import com.Athang.Athang.model.LkpDoc;

import java.util.List;

public interface LkpDocService {
    LkpDoc saveLkpDoc(LkpDoc lkpDoc);
    List<LkpDoc> getLkpDoc();

    LkpDoc upDateLkpDoc(Integer id,LkpDoc lkpDoc);

    void deleteLkpdoc(Integer id);
}
