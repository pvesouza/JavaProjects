package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.entity.Phone;
import one.digitalinnovation.personapi.enums.PhoneType;

import java.util.ArrayList;
import java.util.List;

public class PhoneUtils {

    private List<Phone> listPhone;

    public PhoneUtils(){
        listPhone = new ArrayList<>();
        Phone p1 = new Phone();
        p1.setId(1l);
        p1.setNumber("(83)99629-3341");
        p1.setType(PhoneType.MOBILE);

        Phone p2 = new Phone();
        p2.setId(2l);
        p2.setNumber("(83)3028-2037");
        p2.setType(PhoneType.HOME);

        listPhone.add(p1);
        listPhone.add(p2);
    }

    public List<Phone> getPhoneList() {
        return listPhone;
    }
}
