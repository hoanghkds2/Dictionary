
package controller;

import content.Prompt;
import repository.DictionaryRepository;
import view.Menu;
import model.Dictionary;


public class DictionaryController extends Menu {

    protected static String[] mc = {"Add Word", "Delete Word",
        "Translate", "Exit"};
    protected DictionaryRepository repo;
    protected Dictionary dictionary;

    public DictionaryController() {
        super("======== Dictionary program ========", mc);
        repo = new DictionaryRepository();
        dictionary = new Dictionary();
        dictionary.setDictionary(dictionary.readFromFile("dictionary.dat"));
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1: {
                System.out.println("------------- Add -------------");
                repo.addWord(dictionary.getDictionary());
                break;
            }
            case 2: {
                System.out.println("------------ Delete ----------------");
                repo.deleteWord(dictionary.getDictionary());
                break;
            }
            case 3: {
                System.out.println("------------- Translate ------------");
                repo.translateWord(dictionary.getDictionary());
                break;
            }
            case 4: {
                System.out.println(Prompt.promptExit);
                dictionary.writeToFile(dictionary.getDictionary(), "dictionary.dat");
                System.exit(0);
            }
            default: {
                System.out.println("No such choice!");
            }
        }
    }
}