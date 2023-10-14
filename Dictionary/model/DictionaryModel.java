package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class DictionaryModel {
    private HashMap<String, String> dictionary = new HashMap<>();

    public DictionaryModel() {
        loadData();
    }

    public boolean addWord(String eng, String vi) {
        dictionary.put(eng, vi);
        updateDatabase();
        return false;
    }

    public boolean removeWord(String eng) {
        if (dictionary.containsKey(eng)) {
            dictionary.remove(eng);
            updateDatabase();
            return true;
        }
        return false;
    }

    public String translate(String eng) {
        return dictionary.getOrDefault(eng, "Not Found");
    }

    private void loadData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("dictionary.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    dictionary.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            // File not found, dictionary starts empty
        }
    }

    private void updateDatabase() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("dictionary.txt"))) {
            for (String eng : dictionary.keySet()) {
                writer.println(eng + ":" + dictionary.get(eng));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}