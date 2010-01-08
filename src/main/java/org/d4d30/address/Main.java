package org.d4d30.address;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        Address address = new Address();
        address.setFirstName("pinky");
        address.setLastName("jones");
        address.setLine1("123 main st");
        address.setLine2("suite abc");
        address.setCity("somewhere");
        address.setState("IA");
        address.setZip("90120");

        AddressRepository repository = (AddressRepository) context.getBean("addressRepository");
        repository.add(address);
    }
}