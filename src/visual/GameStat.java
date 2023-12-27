package visual;

import java.util.ArrayList;
import java.util.HashMap;

public class GameStat {

    private HashMap<String, ArrayList<Character>> gameStat;

    public GameStat(HashMap<String, ArrayList<Character>> gameStat){
        this.gameStat = gameStat;
    }

    public void showGameStat(HashMap<String, ArrayList<Character>> data){
        refreshStat(data);
        for (Character letter: gameStat.get("secretWord")) {
            System.out.printf("%s ", letter);
        }
        System.out.println();

        System.out.print("Letters on the wrong place: ");
        if(gameStat.get("notRightPlaceLetter").isEmpty()){
            System.out.println("-");
        }else {
            for (Character letter: gameStat.get("notRightPlaceLetter")) {
                System.out.printf("%s ", letter);
            }
        }

        System.out.print("There are no such letters in the secret word: ");
        if(gameStat.get("noSuchLetter").isEmpty()){
            System.out.println("-");
        }else {
            for (Character letter: gameStat.get("noSuchLetter")) {
                System.out.printf("%s ", letter);
            }
        }
        System.out.println();
    }

    void refreshStat(HashMap<String, ArrayList<Character>> data){
        this.gameStat = data;
    }

}
