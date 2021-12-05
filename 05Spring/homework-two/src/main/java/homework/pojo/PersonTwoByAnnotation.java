package homework.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component("personTwo")
@Data
public class PersonTwoByAnnotation {
    private String name;
    private int age;
    public PersonTwoByAnnotation getPersonTwo(String name,int age){
        this.name = name;
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "PersonTwoByAnnotation{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
