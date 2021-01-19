package itacademy._21.annotatedmethod;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Phone {
    private static final Phone instance = new Phone();
    private boolean active;
    private final Map<String, String> contactList;

    public static Phone getInstance() {
        return instance;
    }

    private Phone() {
        this.active = false;
        this.contactList = new TreeMap<>();
    }

    public boolean isActive() {
        return active;
    }

    public Map<String, String> getContactList() {
        return Collections.unmodifiableMap(contactList);
    }

    public void switchPowerButton() {
        active ^= true;
        if(active) {
            System.out.println("Turned ON");
        } else {
            System.out.println("Turned OFF");
        }
    }

    @Execute(times = 50)
    public void addNewContact(String contactName, String contactNumber) throws PhoneIsInactiveException{
        if(!active) {
            throw new PhoneIsInactiveException();
        }
        contactList.put(contactName, contactNumber);
        System.out.println("New contact has been added!");
    }

    public void removeContact(String contactName) throws PhoneIsInactiveException{
        if(!active) {
            throw new PhoneIsInactiveException();
        }
        String removed = contactList.remove(contactName);
        if(removed == null) {
            throw new ContactNotFoundException();
        }
        System.out.println("Contact removal completed!");
    }

    public void callNumberFromKeyPad(String number) {
        try {
            callNumber(number);
        } catch(PhoneIsInactiveException e) {
            System.out.println(e.getMessage());
        }
    }

    public void callNumberFromContactList(String contactName) {
        String number = contactList.get(contactName);
        if(number == null) {
            throw new ContactNotFoundException();
        }

        try {
            callNumber(number);
        } catch(PhoneIsInactiveException e) {
            System.out.println(e.getMessage());
        }
    }

    @Execute(times = 10)
    private void callNumber(String number) throws PhoneIsInactiveException {
        if(!active) {
            throw new PhoneIsInactiveException();
        } else if(number == null) {
            throw new NullPointerException("Provided number unrecognized.");
        }
        System.out.println("Calling... " + number);
    }

    public class ContactNotFoundException extends RuntimeException {
    }
    public class PhoneIsInactiveException extends Exception {
        public PhoneIsInactiveException() {
            super("Phone is turned OFF!");
        }
    }
}
