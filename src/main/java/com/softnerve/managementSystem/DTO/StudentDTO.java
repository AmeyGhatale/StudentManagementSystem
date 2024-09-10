package com.softnerve.managementSystem.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {
    private Integer id;

    private String name;

    private String contactDetails;

    private String emailId;

    private String password;

    private String roles;

    private String address;

    private String pincode;
}
