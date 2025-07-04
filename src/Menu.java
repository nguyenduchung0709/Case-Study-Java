import java.util.Scanner;

public class Menu {
    private final Scanner sc;
    private final ContactManager manager;
    private final IOFile ioFile;
    private final ValidateForm validateForm;

    public Menu(Scanner sc, ContactManager manager) {
        this.sc = sc;
        this.manager = manager;
        this.ioFile = new IOFile(manager);
        this.validateForm = new ValidateForm();
    }

    void showMenu() {
        System.out.println("=====Menu=====");
        System.out.println("1. Add Contact");
        System.out.println("2. Delete Contact");
        System.out.println("3. Update Contact");
        System.out.println("4. Search Contact");
        System.out.println("5. Display All Contact");
        System.out.println("6. Read/Write File CSV");
        System.out.println("7. Exit");
        System.out.println("Enter your choice: ");
    }

    void add() {
        String name = requireInput("Enter Name: ");

        String phone;
        while (true) {
            System.out.println("Enter Phone: ");
            phone = sc.nextLine();
            if (validateForm.phone(phone)) {
                break;
            } else if (phone.isEmpty()) {
                System.out.println("This field cannot be empty");
            } else {
                System.out.println("Enter Valid Phone Number: ");
            }
        }
        String dateBorn = requireInput("Enter Date of Birth: ");
        String group = requireInput("Enter Group: ");
        String address = requireInput("Enter Address: ");
        String gender = requireInput("Enter Gender: ");
        String email;
        while (true) {
            System.out.println("Enter Email: ");
            email = sc.nextLine();
            if (validateForm.email(email)) {
                break;
            } else if (email.isEmpty()) {
                System.out.println("This field cannot be empty");
            } else {
                System.out.println("Enter Valid Email Address: ");
            }
        }
        manager.addContact(name, phone, dateBorn, group, address, gender, email);
    }

    void delete() {
        System.out.println("Enter Name or Phone to delete: ");
        String keyword = sc.nextLine();
        manager.deleteContact(keyword);
    }

    void update() {
        System.out.print("Enter phone number to edit:");
        String oldNumber = sc.nextLine();
        if (!validateForm.phone(oldNumber)) {
            System.out.println("The phone number you entered is not valid!");
            return;
        }

        boolean exists = false;
        for (Contact c : manager.getContacts()) {
            if (c.getPhoneNumber().equals(oldNumber)) {
                exists = true;
                break;
            }
        }

        if (!exists) {
            System.out.print("CANNOT FIND THE CONTACT!");
            return;
        }

        String newName = requireInput("Enter New Name: ");

        String newNumber;
        while (true) {
            System.out.println("Enter New Phone: ");
            newNumber = sc.nextLine();
            if (validateForm.phone(newNumber)) {
                break;
            } else if (newNumber.isEmpty()) {
                System.out.println("This field cannot be empty");
            } else {
                System.out.println("Enter Valid Phone Number: ");
            }
        }

        String newDateBorn = requireInput("Enter Date of Birth: ");
        String newGroup = requireInput("Enter Group: ");
        String newAddress = requireInput("Enter Address: ");
        String newGender = requireInput("Enter Gender: ");

        String newEmail;
        while (true) {
            System.out.println("Enter New Email: ");
            newEmail = sc.nextLine();
            if (validateForm.email(newEmail)) {
                break;
            } else if (newEmail.isEmpty()) {
                System.out.println("This field cannot be empty");
            } else {
                System.out.println("Enter Valid Email Address: ");
            }
        }

        manager.updateContact(oldNumber, newName, newNumber, newDateBorn, newGroup, newAddress, newGender, newEmail);
    }

    void search() {
        System.out.println("Enter the phone number or name to find: ");
        String search = sc.nextLine();
        manager.searchContact(search);
    }

    void display() {
        manager.displayContacts();
    }

    void io() {
        System.out.println("1. Read file CSV");
        System.out.println("2. Write file CSV");
        System.out.println("Choose your option!");
        String input = sc.nextLine();
        int option;
        try {
            option = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid option number!");
            return;
        }

        if (option == 1) {
            ioFile.readFile("src/contacts.csv");
        } else {
            ioFile.writeFile("src/contacts.csv");
        }
    }

    String requireInput(String message) {
        String input;
        while (true) {
            System.out.println(message);
            input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("This field cannot be empty");
        }
    }
}
