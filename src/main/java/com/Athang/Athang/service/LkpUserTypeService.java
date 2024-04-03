package com.Athang.Athang.service;

import com.Athang.Athang.model.LkpUserType;

import java.util.List;

public interface LkpUserTypeService {
    LkpUserType saveType(LkpUserType lkpUserType);
    List<LkpUserType> getType();

    LkpUserType updateType(Integer id,LkpUserType lkpUserType);

    void deleteType(Integer id);
}
