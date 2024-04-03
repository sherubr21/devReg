package com.Athang.Athang.service;

import com.Athang.Athang.model.LkpCourse;

import java.util.List;

public interface LkpCourseService {
    LkpCourse saveCourse(LkpCourse lkpCourse);

    List<LkpCourse> getCourse();

    LkpCourse updateCourse(Integer is,LkpCourse lkpCourse);

    void deleteCourse(Integer id);
}
