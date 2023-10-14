package view;

public class Menu {
    public void displayMenu() {
        System.out.println("\nSimple English - Vietnamese Dictionary");
        System.out.println("1. Add Word");
        System.out.println("2. Delete Word");
        System.out.println("3. Translate Word");
        System.out.println("4. Exit");
    }

    public void showTranslation(String translation) {
        System.out.println("Translation: " + translation);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}

