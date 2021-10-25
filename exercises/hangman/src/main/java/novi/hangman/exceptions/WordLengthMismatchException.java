package novi.hangman.exceptions;

public class WordLengthMismatchException extends RuntimeException {
    public WordLengthMismatchException(int length, int expectedLength) {
        super(String.format("The word you guessed is invalid, it is %d characters long but it should be %d", length, expectedLength));
    }
}
