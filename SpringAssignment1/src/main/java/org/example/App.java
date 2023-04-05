package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");

        //CONSTRUCTOR INJECTION STUDENT
        Student obj1 = (Student) context.getBean("Student1");
        System.out.println("MADE USING CONSTRUCTOR INJECTION: " + obj1.toString());

        //SETTER INJECTION STUDENT
        Student obj2 = (Student) context.getBean("Student2");
        System.out.println("MADE USING SETTER INJECTION: " + obj2.toString());
    }
}
