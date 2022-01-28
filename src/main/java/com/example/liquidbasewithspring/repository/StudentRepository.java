package com.example.liquidbasewithspring.repository;

import com.example.liquidbasewithspring.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    @Query("SELECT s.name FROM Student s WHERE s.name LIKE %:studentName%")
    String findByName(String studentName);

}
