import java.io.*;
import java.util.List;

public class IOFile {
    private ContactManager manager;

    public IOFile(ContactManager manager) {
        this.manager = manager;
    }

    public void writeFile(String fileName) {
        try {

            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Contact contact : manager.getContacts()) {
                bufferedWriter.write(contact.getName() + ", " + contact.getPhoneNumber() + ", " + contact.getEmail() + ", " + contact.getDateOfBirth() + ", " + contact.getGroup() + ", " + contact.getAddress() + ", " + contact.getGender() + ", " + contact.getEmail());
                bufferedWriter.newLine();
            }
            System.out.println("Wrote file successfully");
            bufferedWriter.close();
        } catch (IOException io) {
            System.out.println("Error: " + io.getMessage());
        }
    }

    public void readFile(String fileName) {

        try {
            manager.getContacts().clear();
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(", ");
                String name = parts[0];
                String phoneNumber = parts[1];
                String dateOfBirth = parts[2];
                String group = parts[3];
                String address = parts[4];
                String gender = parts[5];
                String email = parts[6];

                manager.addContact(name, phoneNumber, dateOfBirth, group, address, gender, email);
            }
            System.out.println("Read file successfully");
            bufferedReader.close();
        } catch (IOException io) {
            System.out.println("Error: " + io.getMessage());
        }
    }
}
