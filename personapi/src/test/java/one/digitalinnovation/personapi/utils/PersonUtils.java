package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.entity.Person;


public class PersonUtils {
    private Person testPerson = new Person();
    private PhoneUtils phoneUtils = new PhoneUtils();

    public PersonUtils(){
        testPerson.setFirstName("Pedro Victor");
        testPerson.setCpf("01395783403");
        testPerson.setId(1l);
        testPerson.setLastName("Souza");
        testPerson.setPhones(phoneUtils.getPhoneList());
    }

    public Person getTestPerson() {
        return testPerson;
    }
}
