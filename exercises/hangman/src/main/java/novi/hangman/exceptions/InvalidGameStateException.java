package novi.hangman.exceptions;

public class InvalidGameStateException extends RuntimeException {
    public InvalidGameStateException(String game, String stateError) {
        super(String.format("Invalid game state encountered for game %s: %s", game, stateError));
    }
}
