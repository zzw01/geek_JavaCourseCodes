package com.example.homeworkstarter.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "spring.homeworok.student")
@Data
public class Student {
    private String name;
    private Integer age;

}
