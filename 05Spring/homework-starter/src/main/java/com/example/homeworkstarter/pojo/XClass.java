package com.example.homeworkstarter.pojo;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.homeworok.xclass")
@Data
public class XClass {
    private String classNode;
    private Student student;
}
