package com.piyush.MVCProject.repository;

import com.piyush.MVCProject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

//JPARepo has 2 parameters, one is the type of entity and another is type of Primary Key
// Student repo get all the curd methods to interact with database, so we don't have to modify it
public interface StudentRepository extends JpaRepository<Student, Long> {

}
