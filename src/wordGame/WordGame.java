package wordGame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordGame {

        public static String getRandomWord(String file) {
            List<String> words = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader("src/words.txt"))) {
                String line;
                while ((
                        line = br.readLine()) != null) {
                    words.add(line.trim().toUpperCase());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            Random random = new Random();

            return words.get(random.nextInt(words.size()));
        }

        public static boolean isWordGuess(String wordToGuess, StringBuilder guessedLetters) {
            for (char letter : wordToGuess.toCharArray()) {
                if (!guessedLetters.toString().contains(String.valueOf(letter))) {
                    return false;
                }
            }
            return true;
        }

        public static String getCurrenState(String wordToGuess, StringBuilder guessedLetters) {
            StringBuilder currentState = new StringBuilder();
            for (char letter : wordToGuess.toCharArray()) {
                if (guessedLetters.toString().contains(String.valueOf(letter))) {
                    currentState.append(letter);
                } else {
                    currentState.append('_');
                }
                currentState.append(' ');
            }
            return currentState.toString();
        }
    }

