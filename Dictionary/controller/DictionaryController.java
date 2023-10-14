package controller;

import java.util.Scanner;

import model.DictionaryModel;
import view.Menu;

public class DictionaryController {
    private DictionaryModel model;
    private Menu view;

    public DictionaryController(DictionaryModel model, Menu view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            view.displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addWord(scanner);
                    break;
                case 2:
                    deleteWord(scanner);
                    break;
                case 3:
                    translateWord(scanner);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);
    }

    private void addWord(Scanner scanner) {
        System.out.print("Enter English word: ");
        String eng = scanner.nextLine();
        System.out.print("Enter Vietnamese translation: ");
        String vi = scanner.nextLine();
        if (model.addWord(eng, vi)) {
            view.showMessage("Word added successfully.");
        } else {
            view.showMessage("Word already exists. Update the translation?");
        }
    }

    private void deleteWord(Scanner scanner) {
        System.out.print("Enter English word to delete: ");
        String eng = scanner.nextLine();
        if (model.removeWord(eng)) {
            view.showMessage("Word deleted successfully.");
        } else {
            view.showMessage("Word not found in the dictionary.");
        }
    }

    private void translateWord(Scanner scanner) {
        System.out.print("Enter English word to translate: ");
        String eng = scanner.nextLine();
        String translation = model.translate(eng);
        view.showTranslation(translation);
    }
}
