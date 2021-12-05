package com.example.homeworkstarter.pojo;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.homeworok.school")
@Data
public class School {
    private String schoolName;
    private XClass xClass;
}
