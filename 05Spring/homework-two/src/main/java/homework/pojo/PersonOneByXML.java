package homework.pojo;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonOneByXML {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "PersonOneByXML{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
