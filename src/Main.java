import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu(sc, manager);
        String input;
        int choice = -1;
        do {
            menu.showMenu();
            input = sc.nextLine();
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter 1 to 7");
                continue;
            }
            switch (choice) {
                case 1:
                    menu.add();
                    break;
                case 2:
                    menu.delete();
                    break;
                case 3:
                    menu.update();
                    break;
                case 4:
                    menu.search();
                    break;
                case 5:
                    menu.display();
                    break;
                case 6:
                    menu.io();
                    break;
                case 7:
                    System.out.println("Exiting..");
                    break;
                default:
                    System.out.println("Invalid Choice!!");
            }
        } while (choice != 7);
        sc.close();
    }
}
