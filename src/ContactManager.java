import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    private final List<Contact> contacts = new ArrayList<>();

    public List<Contact> getContacts() {
        return contacts;
    }

    public void addContact(String name, String phone, String dateOfBirth, String group, String address, String gender, String email) {
        Contact contact = new Contact();
        contact.setName(name);
        contact.setPhoneNumber(phone);
        contact.setDateOfBirth(dateOfBirth);
        contact.setGroup(group);
        contact.setAddress(address);
        contact.setGender(gender);
        contact.setEmail(email);
        System.out.println("Contact added!!");
        contacts.add(contact);
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found");
            return;
        }
        for (Contact allContacts : contacts) {
            System.out.println(allContacts);
        }
    }

    public void deleteContact(String keyword) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(keyword) || contact.getPhoneNumber().equals(keyword)) {
                contacts.remove(contact);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found");
        }

    }

    public void searchContact(String keyword) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(keyword.toLowerCase()) || contact.getPhoneNumber().contains(keyword)) {
                System.out.println(contact);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found");
        }
    }

    public void updateContact(String oldPhoneNumber, String newName, String newPhone, String newDateOfBirth, String newGroup, String newAddress, String newGender, String newEmail) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(oldPhoneNumber)) {
                contact.setName(newName);
                contact.setPhoneNumber(newPhone);
                contact.setDateOfBirth(newDateOfBirth);
                contact.setAddress(newAddress);
                contact.setGender(newGender);
                contact.setEmail(newEmail);
                System.out.println("Contact updated");
                return;
            }
        }
    }


}
