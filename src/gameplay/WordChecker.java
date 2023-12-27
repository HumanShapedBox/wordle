package gameplay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class WordChecker {
    private final String secretWord;
    private String userWord;
    private HashMap<String, ArrayList<Character>> gameStat;
    private boolean shouldContinue;

    WordChecker(String secretWord){
        this.userWord = null;
        this.secretWord = secretWord;
        this.gameStat = basicStat();
        this.shouldContinue = true;
    }

    void setUserWord(String userWord) {
        this.userWord = userWord;
    }

    boolean shouldContinue(){
        return shouldContinue;
    }

    HashMap<String, ArrayList<Character>> getStat(){
        return gameStat;
    }

    void checkWords(){
        gameStat.get("notRightPlaceLetter").clear();
        gameStat.get("noSuchLetter").clear();
        for(int i = 0; i < secretWord.length(); i++){
            if(secretWord.charAt(i) == userWord.charAt(i))
                gameStat.get("secretWord").set(i, secretWord.charAt(i));
        }

        onlyWrongLettersLeft();

        for(int i = 0; i < userWord.length(); i++){
            if(secretWord.contains(String.valueOf(userWord.charAt(i)))){
                gameStat.get("notRightPlaceLetter").add(userWord.charAt(i));
            }else{
                gameStat.get("noSuchLetter").add(userWord.charAt(i));
            }
        }

        gameStat.put("notRightPlaceLetter", letterSet(gameStat.get("notRightPlaceLetter")));
        gameStat.put("noSuchLetter", letterSet(gameStat.get("noSuchLetter")));
    }

    String showSecret(){
        return secretWord;
    }

    boolean wordsEqual(){
        if(secretWord.equals(userWord)){
            this.shouldContinue = false;
            return true;
        }
        return false;
    }

    private void onlyWrongLettersLeft(){
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < secretWord.length(); i++){
            if(secretWord.charAt(i) != userWord.charAt(i)){
                temp.append(userWord.charAt(i));
            }
        }
        userWord = temp.toString();
    }

    private HashMap<String, ArrayList<Character>> basicStat(){
        HashMap<String,ArrayList<Character>> gameStat = new HashMap<>();
        ArrayList<Character> secretWord = new ArrayList<>();
        for(int i = 0; i != 5; i++)
            secretWord.add('*');
        ArrayList<Character> notRightPlaceLetter = new ArrayList<>();
        ArrayList<Character> noSuchLetter = new ArrayList<>();
        gameStat.put("secretWord", secretWord);
        gameStat.put("notRightPlaceLetter", notRightPlaceLetter);
        gameStat.put("noSuchLetter", noSuchLetter);
        return gameStat;
    }

    private ArrayList<Character> letterSet(ArrayList<Character> letters){
        Set<Character> set = new HashSet<>(letters);
        return new ArrayList<>(set);
    }

}
