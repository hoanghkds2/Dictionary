
package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class Dictionary implements Serializable{

    private String enWord;
    private String vnWord;
    private HashMap<String, Dictionary> dictionary = new HashMap();

    public String getEnWord() {
        return enWord;
    }

    public void setEnWord(String enWord) {
        this.enWord = enWord;
    }

    public String getVnWord() {
        return vnWord;
    }

    public void setVnWord(String vnWord) {
        this.vnWord = vnWord;
    }

    public HashMap<String, Dictionary> getDictionary() {
        return dictionary;
    }

    public void setDictionary(HashMap<String, Dictionary> dictionary) {
        this.dictionary = dictionary;
    }

    public HashMap<String, Dictionary> readFromFile(String filename) {
        try {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                return (HashMap<String, Dictionary>) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            return new HashMap<>();
        }
    }

    public void writeToFile(HashMap<String, Dictionary> dictionary, String filename) {
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
                oos.writeObject(dictionary);
                oos.flush();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}