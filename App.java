public class App {
    public static void main(String[] args) {

        Hangman hangman = new Hangman();

        do {
            hangman.start();

            do {
                hangman.setUserGuess();
                hangman.processGuess();
            } while (   (hangman.getFailedAttempts() < hangman.getMaxAttempts()) &&
                        !hangman.getGuessedLetters().equals(hangman.getSecretWord())    );

            hangman.gameOver();

        } while (hangman.userWantsToPlayAgain());


    }
}
