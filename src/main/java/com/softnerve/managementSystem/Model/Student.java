package com.softnerve.managementSystem.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    @Id
    private Integer id;

    private String name;

    private String contactDetails;

    private String emailId;

    private String password;

    private String roles;

    private String address;

    private String pincode;
}