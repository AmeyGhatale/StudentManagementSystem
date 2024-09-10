package com.softnerve.managementSystem.Service;

import com.softnerve.managementSystem.DTO.StudentDTO;
import com.softnerve.managementSystem.Model.Student;
import com.softnerve.managementSystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements UserDetailsService {

    @Autowired
    private static  StudentRepository repository;

    @Autowired
    private PasswordEncoder encoder;


    @Override
    public  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Student> studentOptional = repository.findAll().stream()
                .filter(student -> student.getEmailId().equals(username))
                .findFirst();


        // Converting userDetail to UserDetails
        return studentOptional.map(StudentDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Integer id) {
        return repository.findById(id).get();
    }

    public Student addStudent(StudentDTO studentDTO) {

        Student student = Student.builder()
                .name(studentDTO.getName())
                .roles("ROLE_USER")
                .address(studentDTO.getAddress())
                .emailId(studentDTO.getEmailId())
                .contactDetails(studentDTO.getContactDetails())
                .pincode(studentDTO.getPincode())
                .id(studentDTO.getId())
                .password(studentDTO.getPassword())
                .build();
        student.setPassword(encoder.encode(student.getPassword()));

        return repository.save(student);
    }

    public Student updateStudent(Integer id, Student studentDetails) {
        return repository.findById(id).map(student -> {
            student.setName(studentDetails.getName());
            student.setContactDetails(studentDetails.getContactDetails());
            student.setAddress(studentDetails.getAddress());
            student.setPincode(studentDetails.getPincode());
            return repository.save(student);
        }).orElse(null);
    }

    public void deleteStudent(Integer id) {
        repository.deleteById(id);
    }




}
