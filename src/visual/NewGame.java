package visual;

import gameplay.Dictionary;
import gameplay.GameController;
import gameplay.UserWord;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 */
public class NewGame implements GameInterface{

    private final GameController gc;
    private UserWord userWord;
    private UserChoice userChoice;
    private final int tries;
    Scanner sc;

    public NewGame(){
        this.gc = new GameController();
        this.userWord = new UserWord();
        this.userChoice = new UserChoice();
        this.tries = Dictionary.ENGLISHSIMPLE.getTries();
        this.sc = new Scanner(System.in);
    }

    @Override
    public void start() {
        System.out.println("Try to guess the hidden word\n" +
                "*".repeat(gc.getWordLength()));
        int counter = gc.getCounter();
        while(counter != tries){
            System.out.println("Your word:");
            getNewWord();
            gc.checking(userWord);
            counter = gc.getCounter();
            if(!gc.shouldContinue()){
                return;
            }
        }
        System.out.println();
        System.out.println("Game over!");
        gc.showSecret();
    }

    @Override
    public void end() {
        sc.close();
        System.out.println("Bye!");
    }

    @Override
    public void info() {
        try (Scanner scanner = new Scanner(new File("src/resources/info/gameinfo.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Sorry! Didn't find it");
        }
    }

    @Override
    public void showMenu() {
        while (true){
            System.out.println();
            System.out.println("Time to choose.\n" +
                    "1 - Start game\n" +
                    "2 - Get rules\n" +
                    "3 - Exit");
                setChoiceNumber();
                switch (getChoiceNum()){
                    case 1:
                        start();
                        break;
                    case 2:
                        info();
                        break;
                    case 3:
                        end();
                        return;
                    }
        }
    }

    private void getNewWord(){
        userWord.setUserWord(sc.nextLine());
    }

    private void setChoiceNumber(){
        userChoice.setChoiceNum(sc.nextLine());
    }

    private int getChoiceNum(){
        return userChoice.getChoiceNum();
    }

}
