package springJMS;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Receiver {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:receiverjms.xml");
    }
}
