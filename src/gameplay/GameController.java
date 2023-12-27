package gameplay;

import exceptions.NoSuchWordException;
import exceptions.WrongAmountException;
import visual.GameStat;

import java.util.ArrayList;
import java.util.HashMap;

public class GameController {
    private WordChecker wordChecker;
    private final String pathForCheck;
    private GameStat gameStat;
    private final int wordLength;
    private int counter;

    public GameController(){
        SecretWord secretWord = new SecretWord();
        this.wordChecker = new WordChecker(secretWord.getSecretWord());
        this.pathForCheck = Dictionary.ENGLISHSIMPLE.getPathForCheck();
        this.wordLength = Dictionary.ENGLISHSIMPLE.getWordLength();
        this.counter = 0;
        this.gameStat = new GameStat(getStat());
    }

    public void checking(UserWord userWord){
        try{
            String s = userWord.getUserWord();
            checkWordLength(s);
            checkDictionary(s);
            wordChecker.setUserWord(s);
            if(wordChecker.wordsEqual()){
                System.out.println("Yeap!");
                showSecret();
            }else{
                wordChecker.checkWords();
                gameStat.showGameStat(getStat());
                counter++;
            }
        }catch (WrongAmountException | NoSuchWordException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getCounter() {
        return counter;
    }

    public int getWordLength() {
        return wordLength;
    }

    public boolean shouldContinue(){
        return wordChecker.shouldContinue();
    }

    public void showSecret(){
        System.out.println(wordChecker.showSecret());
    }


    private HashMap<String, ArrayList<Character>> getStat() {
        return wordChecker.getStat();
    }

    private void checkDictionary(String userWord) throws NoSuchWordException {
        Words wordsList = new Words(pathForCheck);
        if(userWord == null || userWord.isEmpty() || !wordsList.isIn(userWord))
            throw new NoSuchWordException("Need a real word");
    }

    private void checkWordLength(String userWord) throws WrongAmountException {
        if(userWord.length() != wordLength)
            throw new WrongAmountException("Need a five letter word");
    }

}
