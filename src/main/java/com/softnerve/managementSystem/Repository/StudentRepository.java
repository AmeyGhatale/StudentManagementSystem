package com.softnerve.managementSystem.Repository;

import com.softnerve.managementSystem.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, Integer> {
}
