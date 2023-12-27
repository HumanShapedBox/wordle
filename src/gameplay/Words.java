package gameplay;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

class Words {
    private final List<String> wordsForGame;

    Words(String path){
        try {
            this.wordsForGame = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String getRandomWord(){
        return wordsForGame.get(new Random().nextInt(wordsForGame.size()));
    }


    boolean isIn(String word){
        return wordsForGame.contains(word.toUpperCase());
    }
}
