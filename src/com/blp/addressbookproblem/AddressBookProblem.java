package com.blp.addressbookproblem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class AddressBookProblem {

         ContactDetails person = new ContactDetails();
         List<ContactDetails> contactDetailsList = new ArrayList<>();

    public void addNewContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First Name : ");
        String firstName = scanner.next();
        System.out.println("Enter Last Name : ");
        String lastName = scanner.next();
        System.out.println("Enter Address : ");
        String address = scanner.next();
        System.out.println("Enter City : ");
        String city = scanner.next();
        System.out.println("Enter State : ");
        String state = scanner.next();
        System.out.println("Enter ZipCode : ");
        int zipCode = scanner.nextInt();
        System.out.println("Enter Mobile Number : ");
        long mobileNumber = scanner.nextLong();
        System.out.println("Enter EmailId : ");
        String emailId = scanner.next();
        person = new ContactDetails(firstName, lastName, address, city, state, zipCode, mobileNumber, emailId);
        contactDetailsList.add(person);
        System.out.println(contactDetailsList);

    }
    public void editContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first name of person to edit contact");
        String firstName = scanner.next();
        if (firstName.equalsIgnoreCase(person.getFirstName())) {
            addNewContact();
        } else {
            System.out.println("The Entered First Name Is Not Match");
            editContact();
        }
    }
    public static void main(String[] args) {
        AddressBookProblem addressBookProblem = new AddressBookProblem();
        addressBookProblem.addNewContact();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Y To Edit The Contact");
        String choice = scanner.nextLine();
        if (choice.equals("y") || choice.equals("Y")) {
            addressBookProblem.editContact();
        }
    }
    }





