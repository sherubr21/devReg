package com.Athang.Athang.service;

import com.Athang.Athang.model.LkpTraineeStatus;

import java.util.List;

public interface LkpTraineeStatusService {

    LkpTraineeStatus save(LkpTraineeStatus lkpTraineeStatus);

    List<LkpTraineeStatus> getAll();

    LkpTraineeStatus update(Integer id,LkpTraineeStatus lkpTraineeStatus);

    void delete(Integer id);

}
