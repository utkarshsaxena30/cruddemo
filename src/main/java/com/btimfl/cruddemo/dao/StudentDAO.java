package com.btimfl.cruddemo.dao;

import com.btimfl.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findByLastName(String lastName);

    List<Student> findAll();

    Student update(Student student);
}
