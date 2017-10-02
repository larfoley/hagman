import java.util.Scanner;

public class Hangman {

    private int maxAttempts, failedAttempts;
    private String secretWord, guessedLetters;
    private char userGuess;
    private boolean twoPlayerMode, playAgain;

    Views hangmanViews;
    RandomWord randomWord;
    Scanner scanner;


    public Hangman() {
        failedAttempts = 0;
        maxAttempts = 6;
        secretWord = "";
        userGuess = ' ';
        guessedLetters = "";
        twoPlayerMode = false;
        playAgain = false;
        hangmanViews = new Views();
        randomWord = new RandomWord();
        scanner = new Scanner(System.in);
    }

    public void setSecretWord() {

        if (twoPlayerMode) {
            System.out.println("Enter a word for the other player to guess.");
            this.secretWord = scanner.next();
        } else {
            this.secretWord = randomWord.getRandomWord();
        }

        for (int i = 0; i < secretWord.length(); i++) {
            guessedLetters += "*";
        }

    }

    public void setUserGuess() {
        System.out.println(hangmanViews.generate());
        System.out.println("Enter a letter:  ");
        this.userGuess = scanner.next().charAt(0);
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public String getSecretWord() {
        return secretWord;
    }


    public String getGuessedLetters() {
        return guessedLetters;
    }

    public boolean userWantsToPlayAgain() {
        return this.playAgain;
    }


    public void start() {
        System.out.println("| |                                            \n" +
                "| |__   __ _ _ __   __ _ _ __ ___   __ _ _ __  \n" +
                "| '_ \\ / _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ \n" +
                "| | | | (_| | | | | (_| | | | | | | (_| | | | |\n" +
                "|_| |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|\n" +
                "                    __/ |                      \n" +
                "                   |___/ ");

        System.out.println("Press 1 for single player mode or 2 for two player mode");
        this.twoPlayerMode = scanner.next().charAt(0) == '2';
        this.setSecretWord();

    }

    public void processGuess() {
        System.out.println(hangmanViews.generate());
        StringBuffer strBuff = new StringBuffer();
        boolean correctGuess = false;

        for (int i = 0; i < this.secretWord.length(); i++) {
            if (this.userGuess == secretWord.charAt(i)) {
                strBuff.append(secretWord.charAt(i));
                correctGuess = true;
            } else {
                strBuff.append(this.guessedLetters.charAt(i));
            }
        }

        if (!correctGuess) {
            this.failedAttempts++;
            hangmanViews.next();

        }

        this.guessedLetters = strBuff.toString();
        System.out.println("\n\n\n" + guessedLetters + "\n");
    }

    public void gameOver() {
        if (this.guessedLetters.equals(this.secretWord)) {
            System.out.println("YOU WIN");
        } else {
            System.out.println(hangmanViews.generate());
            System.out.println("===========");
            System.out.println("GAME OVER");
            System.out.println("===========\n");
            System.out.println("the correct guess was " + secretWord + "\n");
        }

        System.out.println("To play again type 1");
        this.playAgain = scanner.next().charAt(0) == '1';

        if (this.playAgain) {
            // reset variables back to their initial values
            this.failedAttempts = 0;
            this.secretWord = "";
            userGuess = ' ';
            guessedLetters = "";
            twoPlayerMode = false;
            hangmanViews.reset();
        } else {
            System.out.println("Thanks for playing :)");
        }

    }


}
