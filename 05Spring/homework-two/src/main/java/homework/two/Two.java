package homework.two;

import homework.pojo.PersonOneByXML;
import homework.pojo.PersonTwoByAnnotation;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 2、（必做）写代码实现Spring Bean的装配，方式越多越好（XML、Annotation都可以）,提
 * 交到Github。
 */
public class Two {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:homework-two.xml");
        //xml装配bean
        PersonOneByXML personOne = (PersonOneByXML)classPathXmlApplicationContext.getBean("personOne");
        System.out.println(personOne.toString());
        //注解装配bean,开启注解扫描
        PersonTwoByAnnotation personTwo = (PersonTwoByAnnotation)classPathXmlApplicationContext.getBean("personTwo");
        System.out.println(personTwo.getPersonTwo("personTwoName",456).toString());
        //
    }
}
