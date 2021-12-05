package com.example.homeworkstarter;

import com.example.homeworkstarter.pojo.School;
import com.example.homeworkstarter.pojo.Student;
import com.example.homeworkstarter.pojo.XClass;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.homeworkstarter")
@EnableConfigurationProperties({Student.class,XClass.class,School.class})
@ConditionalOnProperty(prefix = "spring.shardingsphere", name = "enabled", havingValue = "true", matchIfMissing = true)
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
@RequiredArgsConstructor
public class HomeWorkAutoConfiguration {
    private Student student;


}
