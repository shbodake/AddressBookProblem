package com.blp.addressbookproblem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class AddressBookProblem {

         ContactDetails person = new ContactDetails();
         List<ContactDetails> contactDetailsList = new ArrayList<>();

    public void addContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of contacts you want to enter");
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            System.out.println("Enter the contact details of person ");
            writeContact();
        }
    }
    public void writeContact() {
        ContactDetails person = new ContactDetails();
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
        String editName = scanner.next();
        boolean edited = false;
        for (int i = 0; i < contactDetailsList.size(); i++) {
            String name = contactDetailsList.get(i).getFirstName();
        if (name.equalsIgnoreCase(editName)) {
            writeContact();
            edited = true;
            break;
        }
    }
        if (!edited) {
        System.out.println("enter name is incorrect");
    }
    }
    public void deleteContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first name of person to delete contact");
        String deleteName = scanner.next();
        int i = 0;
        for ( ;i < contactDetailsList.size(); i++) {
            String name = contactDetailsList.get(i).getFirstName();
        if (name.equalsIgnoreCase(deleteName)) {
            break;
            }
        }
        if (i < contactDetailsList.size()) {
            contactDetailsList.remove(i);
            System.out.println("Contact Deleted");
            System.out.println("Remaining contacts in the book isgit");
        }else {
            System.out.println("Contact not find");
        }
    }
    public static void main(String[] args) {
        AddressBookProblem addressBookProblem = new AddressBookProblem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter \n 1 To add The contact \n 2 To edit the contact \n 3 To delete the contact \n 4 to exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addressBookProblem.addContact();
                    break;
                case 2:
                    addressBookProblem.editContact();
                    break;
                case 3:
                    addressBookProblem.deleteContact();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter the wrong input");
                    continue;
            }

        }
    }
    }





