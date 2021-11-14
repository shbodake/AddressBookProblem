package com.blp.addressbookproblem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {
    ContactDetails person = new ContactDetails();
    List<ContactDetails> contactDetailsList = new ArrayList<>();

    public void addContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of contacts you want to enter");
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {

//            checking the duplicate contact by contact name.
            System.out.println("Enter the first name of person");
            String fName = scanner.next();
            if (fName.equals(person.getFirstName())) {
                System.out.println("The entered person is already exist.");
            } else {
                System.out.println("Enter the contact details of person ");
                writeContact();
                System.out.println("contact added Successfully");
            }
        }
    }

    public void writeContact() {
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
    }
    public void editContact() {
        System.out.println("Enter the first name of person to edit contact");
        Scanner scanner = new Scanner(System.in);
        String editName = scanner.next();
        for (int i = 0; i < contactDetailsList.size(); i++) {
            String name = contactDetailsList.get(i).getFirstName();
            if (name.equalsIgnoreCase(editName)) {
                System.out.println("Enter name is exit. you can edit the details");
                while (true) {
                    System.out.println("Enter\n 1. To edit all details\n 2. To edit certain detail\n 3. for previous menu");
                    int choose = scanner.nextInt();
                    switch (choose) {
                        case 1:
                contactDetailsList.remove(i);
                            writeContact();
                            break;
                        case 2:
                            while (true) {
                                System.out.println("Enter\n 1. for First Name\n 2. for Last Name\n 3. for City\n 4. for State\n" +
                                        " 5. for Zip Code\n 6. for Phone\n 7. forEmail\n 8. for previous menu");
                                int option = scanner.nextInt();
                                switch (option) {
                                    case 1:
                                        System.out.println("Enter new First Name");
                                        String newFirstName = scanner.next();
                                        contactDetailsList.get(i).setFirstName(newFirstName);
                                        break;
                                    case 2:
                                        System.out.println("Enter new Last Name");
                                        String newLastName = scanner.next();
                                        contactDetailsList.get(i).setLastName(newLastName);
                                        break;
                                    case 3:
                                        System.out.println("Enter new City");
                                        String newCity = scanner.next();
                                        contactDetailsList.get(i).setCity(newCity);
                                        break;
                                    case 4:
                                        System.out.println("Enter new State");
                                        String newState = scanner.next();
                                        contactDetailsList.get(i).setState(newState);
                                        break;
                                    case 5:
                                        System.out.println("Enter new ZipCode");
                                        int newZip = scanner.nextInt();
                                        contactDetailsList.get(i).setZipCode(newZip);
                                        break;
                                    case 6:
                                        System.out.println("Enter new Phone Number");
                                        int newPNumber = scanner.nextInt();
                                        contactDetailsList.get(i).setMobileNo(newPNumber);
                                        break;
                                    case 7:
                                        System.out.println("Enter new Email");
                                        String newEmail = scanner.next();
                                        contactDetailsList.get(i).setEmailId(newEmail);
                                        break;
                                    case 8:
                                        return;
                                    default:
                                        System.out.println("Entered choice is incorrect!.. please enter correct choice");
                                }
                            }
                        case 3:
                            return;
                        default:
                            System.out.println("Entered choice is incorrect!.. please enter correct choice");
                    }
                }
            }else {
                System.out.println("enter name not exist");
            }
        }
    }
    public void searchByName(String name) {
        List<ContactDetails> collect = contactDetailsList.stream().filter(p -> p.getFirstName().equalsIgnoreCase(name)).collect(Collectors.toList());
        for (ContactDetails contact : collect) {
            System.out.println("Search result: " + contact);
        }
    }

    public void searchByCity(String city) {
        List<ContactDetails> collect = contactDetailsList.stream().filter(p -> p.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
        for (ContactDetails contact : collect) {
            System.out.println("Search result: " + contact);
        }
    }

    public void searchByState(String state) {
        List<ContactDetails> collect = contactDetailsList.stream().filter(p -> p.getCity().equalsIgnoreCase(state)).collect(Collectors.toList());
        for (ContactDetails contact : collect) {
            System.out.println("Search result: " + contact);
        }
    }
    public void deleteContact() {
        System.out.println("Enter the first name of person to delete contact");
        Scanner scanner = new Scanner(System.in);
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
        }else {
            System.out.println("Contact not find");
        }
    }
    public void searchByOptions() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter\n 1. By name\n 2. By city\n 3. By state\n 4. for previous menu");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    contactDetailsList.forEach(book -> searchByName(name));
                    break;
                case 2:
                    System.out.println("Enter city: ");
                    String city = scanner.nextLine();
                    contactDetailsList.forEach(book -> searchByCity(city));
                    break;
                case 3:
                    System.out.println("Enter state: ");
                    String state = scanner.nextLine();
                    contactDetailsList.forEach(book -> searchByState(state));
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Entered choice is incorrect!.. please enter correct choice");
            }
        }
    }
}

