package com.blp.addressbookproblem;

public class AddressBookProblem {
    private class Contact {
        String firstName, lastName, address, city, state, emailId;
        int zipCode;
        long mobileNumber;
    }

    public void printContact() {
        Contact person = new Contact();
        person.firstName = "Sayali";
        person.lastName = "Bodake";
        person.address = "Sai Paradise Apartment";
        person.city = "Nasik";
        person.state = "Maharashtra";
        person.zipCode = 422003;
        person.mobileNumber = 9850521236L;
        person.emailId = "sayalibodake28@gmail.com";
        System.out.println("Contact Details");
        System.out.println("Name         : " + person.firstName + " " + person.lastName + "\n"
                + "Address      : " + person.address + "\n"
                + "City         : " + person.city + "\n"
                + "State        : " + person.state + "\n"
                + "ZipCode      : " + person.zipCode + "\n"
                + "MobileNumber : " + person.mobileNumber + "\n"
                + "EmailId      : " + person.emailId + "\n");
    }

    public static void main(String[] args) {
        AddressBookProblem addressBook = new AddressBookProblem();
        addressBook.printContact();
    }
}




