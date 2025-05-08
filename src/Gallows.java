import wordGame.WordGame;
import java.util.Scanner;
import static asciiArt.AsciiArt.AsciiArt;



public class Gallows {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer;

        System.out.println("Сыграем в игру?Введите 'да' или 'нет': ");
        answer = scanner.nextLine().trim().toLowerCase();
        if (answer.equals("да")) {
            System.out.println("Угадай животное");
            GameManage.playGame(scanner);
        } else {
            System.out.println("До свидания");
        }
        scanner.close();
    }

    class GameManage {

        public static void playGame(Scanner scanner) {

            String wordToGuess = WordGame.getRandomWord("src/words.txt");
            StringBuilder guessedLetters = new StringBuilder();
            int attempts = 6;


            while (attempts > 0) {
                System.out.println("Слово " + WordGame.getCurrenState(wordToGuess, guessedLetters));
                System.out.println("Осталось попыток " + attempts);
                System.out.println("Введите букву ");
                String input = scanner.nextLine().toUpperCase();

                if (guessedLetters.toString().contains(input)) {
                    System.out.println("Вы уже угадали  эту букву");
                    continue;
                }
                guessedLetters.append(input);

                if (wordToGuess.contains(input)) {
                    System.out.println("Правильно");
                } else {
                    attempts--;
                    System.out.println("He правильно");
                    System.out.println(AsciiArt[attempts]);

                }

                if (WordGame.isWordGuess(wordToGuess, guessedLetters)) {
                    System.out.println("Вы угадали слово=" + wordToGuess);
                    break;
                }
                if (attempts <= 0) {
                    System.out.println("Вы проиграли!Слово=" + wordToGuess);
                }
            }

            Scanner user = new Scanner(System.in);
            String answer;

            System.out.println("Сыграем еще раз??Введите 'да/нет' ");
            answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("да")) {
                GameManage.playGame(scanner);
            }
        }

    }
}

