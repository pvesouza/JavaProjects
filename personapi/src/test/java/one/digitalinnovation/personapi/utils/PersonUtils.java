package one.digitalinnovation.personapi.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.entity.Person;

@Data
@Builder
public class PersonUtils {
    private static Person testPerson = new Person();
    private static PhoneUtils phoneUtils = new PhoneUtils();

    public PersonUtils(){
        testPerson.setFirstName("Pedro Victor");
        testPerson.setCpf("01395783403");
        testPerson.setId(1l);
        testPerson.setLastName("Souza");
        testPerson.setPhones(phoneUtils.getPhoneList());
    }

    public static Person getTestPerson() {
        return testPerson;
    }
}
