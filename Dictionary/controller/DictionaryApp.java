package controller;

import model.DictionaryModel;
import view.Menu;

public class DictionaryApp {
    public static void main(String[] args) {
        DictionaryModel model = new DictionaryModel();
        Menu view = new Menu();
        DictionaryController controller = new DictionaryController(model, view);
        controller.run();
    }
}