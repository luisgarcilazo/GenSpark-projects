package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig {

    @Autowired
    private Phone phone;

    @Autowired
    private Address address;
    @Bean
    public Student student(){
        Student studentTemp = new Student();
        studentTemp.setId(111);
        studentTemp.setName("Luis");
        studentTemp.setPh(ph());
        studentTemp.setAdd(address);
        return studentTemp;
    }

    @Bean
    public Phone phone1(){
        Phone phone = new Phone();
        phone.setMob("111-111-1111");
        return phone;
    }
    @Bean
    public Phone phone2(){
        Phone phone = new Phone();
        phone.setMob("222-222-2222");
        return phone;
    }
    @Bean
    public Phone phone3(){
        Phone phone = new Phone();
        phone.setMob("333-333-3333");
        return phone;
    }
    @Bean
    public List<Phone> ph(){
        List<Phone> phones = new ArrayList<>();
        phones.add(phone1());
        phones.add(phone2());
        phones.add(phone3());
        return phones;
    }
    @Bean
    public Address address(){
        Address addressTemp = new Address();
        addressTemp.setCity("Random City");
        addressTemp.setCountry("Random Country");
        addressTemp.setState("Random State");
        addressTemp.setZipcode("11111");
        return addressTemp;
    }
}
