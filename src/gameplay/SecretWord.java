package gameplay;

class SecretWord {

    private final String secretWord;

    SecretWord(){
        Words wordsList = new Words(Dictionary.ENGLISHSIMPLE.getPathForGame());
        this.secretWord = wordsList.getRandomWord();
    }
//
//    public SecretWord(String path) {
//        Words wordsList = new Words(path);
//        this.secretWord = wordsList.getRandomWord();
//    }

    String getSecretWord() {
        return secretWord;
    }
}
