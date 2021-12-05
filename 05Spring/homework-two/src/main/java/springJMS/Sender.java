package springJMS;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Student;

public class Sender {
    public static void main(String[] args) {
        Student student = new Student("zhang02", "456");
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:senderjms.xml");
        SenderService senderService = (SenderService)classPathXmlApplicationContext.getBean("senderService");
        senderService.send(student);
        System.out.println("send successfully, please visit http://localhost:8161/admin to see it");
    }
}
