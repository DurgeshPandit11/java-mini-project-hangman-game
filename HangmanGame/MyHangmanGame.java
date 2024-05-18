package HangmanGame;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

public class MyHangmanGame {
    static Scanner scanner2 = new Scanner(System.in);
    
    public static void main(String[] args) throws FileNotFoundException {
        // Reading the words from a file
        List<String> allWords = readWordsFromFile("HangmanGame\\words.txt");

        // Hint to Guess the word
        String word = getWordAndPrintHint(allWords);

        // Word to character list
        List<Character> wordCharsList = getWordCharsList(word);

        // Initializing wordState
        List<Character> wordState = initializeWordState(word);

        // The Hangman Game
        playHangmanGame(word, wordCharsList, wordState);
    }

    private static List<String> readWordsFromFile(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        List <String> allWords = new ArrayList<>();

        //Make words upper case
        while (scanner.hasNext()) {
            allWords.add(scanner.nextLine().toUpperCase());
        }
        return allWords;
    }

    private static String getWordAndPrintHint(List<String> allWords) {
        
        Random random = new Random();
        int randomWordIndex = random.nextInt(allWords.size());
        String word = allWords.get(randomWordIndex);
        
        System.out.print("Hint: ");
        if (randomWordIndex < 15) 
            System.out.print("A Fruit");
        
        else if (randomWordIndex < 37)
            System.out.print("An Animal");
        
        else if (randomWordIndex < 50) 
            System.out.print("A Bird");
        
        else
            System.out.print("A Vegetable");
        
        System.out.println();

        return word;
    }

    private static List<Character> getWordCharsList(String word) {
        List <Character> wordCharacters = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            wordCharacters.add(word.charAt(i));
        }
        return wordCharacters;
    }

    private static List<Character> initializeWordState(String word) {
        List <Character> wordState = new ArrayList<>();
        
        for (int i = 0; i < word.length(); i++) {
            wordState.add('-');
        }
        System.out.println(wordState);
        return wordState;
    }

    private static void playHangmanGame(String word, List<Character> wordCharsList, List<Character> wordState) {
        int correctCount = 0, previousCorrectCount, wrongCount = 0;
        while (true) {
            printProportionalHangedMan(word, wrongCount);

            // Loosing Condition
            if (wrongCount >= 6)
                break;

            previousCorrectCount = correctCount;
            correctCount = setGuessAndGetCorrectCount(word, wordState, correctCount);
            wrongCount = getWrongCountAndPrintWordState(correctCount, previousCorrectCount, wrongCount, wordState);
            
            // Winning Condition
            if (wordState.equals(wordCharsList)) {
                System.out.println("You Won!");
                break;
            }
        }
    }

    private static void printProportionalHangedMan(String word, int wrongCount) {
        System.out.print("\n");
        System.out.println(" ----------");
        System.out.println(" |        |");

        if (wrongCount >= 1)
            System.out.println(" O");
        
        if (wrongCount >= 2) 
            System.out.print("\\ ");
        
        if (wrongCount >= 3)
            System.out.println("/");
        
        if (wrongCount >= 4) 
            System.out.println(" |");
        
        if(wrongCount >= 5)
            System.out.print("/ ");
        
        if (wrongCount >= 6) {
            System.out.println("\\");
            System.out.println("You Lost!");
            System.out.println("The word was: " + word);
        }
        System.out.println();
    }
    
    private static int setGuessAndGetCorrectCount(String word, List<Character> wordState, int correctCount) {
        System.out.print("Enter your guess: ");
        char playerGuess = scanner2.next().charAt(0);
   
        for (int i = 0; i < word.length(); i++) {
            if (playerGuess == word.charAt(i)) {
                wordState.set(i, word.charAt(i));
                correctCount++;
                System.out.println("Correct!");
            }
        }
        return correctCount;
    }
    
    private static int getWrongCountAndPrintWordState(int correctCount, int previousCorrectCount, int wrongCount, List<Character> wordState) {
        if (previousCorrectCount == correctCount) {
            wrongCount++;
            System.out.println("Incorrect!");
        }
        System.out.println(wordState);
        return wrongCount;
    }
    
}