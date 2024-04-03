package com.Athang.Athang.service;

import com.Athang.Athang.model.Doc;


import java.util.List;

public interface DocService {
    Doc saveDoc(Doc doc);

    List<Doc> getDoc();

    Doc updateDoc(Integer id,Doc doc);

    void deleteDoc(Integer id);
}
