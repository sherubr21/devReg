package com.Athang.Athang.service;

import com.Athang.Athang.model.LkpCourse;
import com.Athang.Athang.repository.LkpCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class LkpCourseServiceImp implements LkpCourseService{
    @Autowired
    private LkpCourseRepository lkpCourseRepository;
    @Override
    public LkpCourse saveCourse(LkpCourse lkpCourse) {

        return lkpCourseRepository.save(lkpCourse);
    }

    @Override
    public List<LkpCourse> getCourse() {
        return lkpCourseRepository.findAll();
    }

    @Override
    public LkpCourse updateCourse(Integer id, LkpCourse lkpCourse) {
        Optional<LkpCourse> lkpObj=lkpCourseRepository.findById(id);
        if(lkpObj.isPresent()){
            LkpCourse lkp=lkpObj.get();
            lkp.setName(lkpCourse.getName());
            lkp.setSponserby(lkpCourse.getSponserby());
            return lkpCourseRepository.save(lkp);

        }else{

            throw new IllegalArgumentException("Course with ID " + id + " not found");

        }
    }

    @Override
    public void deleteCourse(Integer id) {
           lkpCourseRepository.deleteById(id);
    }
}
