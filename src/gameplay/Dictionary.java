package gameplay;

public enum Dictionary {
    ENGLISHSIMPLE("src/resources/dictionary/Eng.txt",
            "src/resources/dictionary/5-letter-words-list.txt",
            5, 6);

    private String pathForGame;
    private String pathForCheck;
    private int wordLength;
    private int tries;

    Dictionary(String pathForGame, String pathForCheck, int wordLength, int tries){
        this.pathForGame = pathForGame;
        this.pathForCheck = pathForCheck;
        this.wordLength = wordLength;
        this.tries = tries;
    }

    public String getPathForGame() {
        return pathForGame;
    }

    public String getPathForCheck() {
        return pathForCheck;
    }

    public int getWordLength() {
        return wordLength;
    }

    public int getTries() {
        return tries;
    }
}
