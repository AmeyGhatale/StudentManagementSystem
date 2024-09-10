package com.softnerve.managementSystem.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Data
public class UserInfo {

    @Id
    private Integer userId;

    private String name;

    private String emailId;

    private String password;

    private String roles;

    private String mobNo;

}
