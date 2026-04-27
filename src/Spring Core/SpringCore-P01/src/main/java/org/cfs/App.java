package org.cfs;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        System.out.println("-----------------------------BeanFactory Started----------------------------------------");
        //BeanFactory factory = new ClassPathXmlApplicationContext("Bean.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
        System.out.println("-----------------------------Bean File Loaded-------------------------------------------");


        System.out.println("Sending Request..");
        Car car = context.getBean(Car.class);
        car.drive();

    }
}
