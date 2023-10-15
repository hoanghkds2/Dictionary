package repository;

import java.util.HashMap;
import model.Dictionary;

public interface IDictionaryRepository {

    void addWord(HashMap<String, Dictionary> dictionary);

    void deleteWord(HashMap<String, Dictionary> dictionary);

    void translateWord(HashMap<String, Dictionary> dictionary);

}