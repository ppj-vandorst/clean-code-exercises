package novi.hangman;

import novi.hangman.exceptions.DuplicateLetterException;
import novi.hangman.exceptions.InvalidGameStateException;
import novi.hangman.exceptions.WordLengthMismatchException;

import java.util.*;

public class Game {
    private static List<String> WORDS = List.of("funny", "subway", "uptown", "beekeeper", "buffalo", "buzzard",
            "jackpot", "ivy", "strength", "zipper", "whiskey", "kiosk");

    private ImageFactory imageFactory = new ImageFactory();
    private boolean gameRunning = false;
    private String wordToGuess;
    private String guessState;
    private List<Character> guessedLetters;
    private int numberOfTurns;
    private int numberOfWrongGuesses;

    public Game() {
        this.imageFactory = new ImageFactory();
    }

    public String startNewGame() {
        this.gameRunning = true;

        this.wordToGuess = WORDS.get(new Random().nextInt(WORDS.size()));
        this.guessState = String.valueOf("*").repeat(Math.max(0, this.wordToGuess.length()));
        this.guessedLetters = new ArrayList<>();
        this.numberOfTurns = 0;
        this.numberOfWrongGuesses = 0;

        return "You started a game of Hangman, fill in a letter or a word to start guessing";
    }

    public List<String> applyGuess(String guess) {
        try {
            if (!this.gameRunning) {
                throw new InvalidGameStateException("Hangman", "Not running");
            }

            this.numberOfTurns++;
            var wrongGuessMessage = "";

            // if the guess is a letter
            if (guess.length() == 1) {
                var letter = guess.toCharArray()[0];

                // If the letter was already guessed, exit here
                if (guessedLetters.contains(letter)) {
                    throw new DuplicateLetterException(letter);
                }

                this.guessedLetters.add(letter);
                var matchingIndices = findLetterInWord(this.wordToGuess, letter);

                // if the letter is present in our word
                if (matchingIndices.size() > 0) {
                    var builder = new StringBuilder(this.guessState);
                    for (var index : matchingIndices) {
                        builder.setCharAt(index, letter);
                    }
                    this.guessState = builder.toString();
                    return List.of(String.format("Correct! The letter %s is used", guess), this.guessState);

                    // The letter is not present in our word
                } else {
                    numberOfWrongGuesses++;
                    wrongGuessMessage = String.format("Nope! The letter %s is not used", guess);
                }

            // if the guess is a word
            } else {
                if (guess.length() != wordToGuess.length()) {
                    throw new WordLengthMismatchException(guess.length(), wordToGuess.length());
                }

                // The word was guessed
                if (guess.equals(wordToGuess)) {
                    gameRunning = false;
                    return List.of(String.format("You won! You guessed the word %s in %d turns", this.wordToGuess,
                            this.numberOfTurns));
                
                // The guessed word was incorrect
                } else {
                    this.numberOfWrongGuesses++;
                    wrongGuessMessage = String.format("Nope! The word is not %s", guess);
                }
            }

            // If it's game over we stop the game
            if (this.numberOfWrongGuesses > 6) {
                wrongGuessMessage = String.format("You lost! the word was: %s", this.wordToGuess);
                gameRunning = false;
            }

            var hangmangImage = imageFactory.getImage(this.numberOfWrongGuesses);

            var wrongGuessResponse = new ArrayList<String>();
            wrongGuessResponse.addAll(hangmangImage);
            wrongGuessResponse.add(this.guessState);
            wrongGuessResponse.add(wrongGuessMessage);

            return wrongGuessResponse;
        } catch (DuplicateLetterException | WordLengthMismatchException e) {
            return List.of(e.getMessage());
        }
    }

    private List<Integer> findLetterInWord(String word, char letter) {
        var indices = new ArrayList<Integer>();

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                indices.add(i);
            }
        }

        return indices;
    }

    public boolean isGameRunning() {
        return this.gameRunning;
    }
}