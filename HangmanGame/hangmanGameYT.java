package HangmanGame;

import java.util.List;

public class hangmanGameYT {
    public static void main(String[] args) {
        // // Guessed letters list
        // List <Character> playerGuessesList = new ArrayList<>();
        
        // // Printing Dashes
        // checkIfCompleteOrPrintState(word, playerGuessesList);
        // System.out.print("\n");
        
        // // Accepting guesses and replacing dashes for correct guesses
        // int wrongGuesses = 0;
        // while (true) {
        //     System.out.print("\n");
        //     System.out.println(" ----------");
        //     System.out.println(" |        |");

        //     if (wrongGuesses >= 1)
        //         System.out.println(" O");
            
        //     if (wrongGuesses >= 2) 
        //         System.out.print("\\ ");
            
        //     if (wrongGuesses >= 3)
        //         System.out.println("/");
            
        //     if (wrongGuesses >= 4) 
        //         System.out.println(" |");
            
        //     if(wrongGuesses >= 5)
        //         System.out.print("/ ");
            
        //     if (wrongGuesses >= 6)
        //         System.out.println("\\");
            
        //     System.out.print("\n");

        //     inputGuess(word, playerGuessesList);
        //     if (checkIfCompleteOrPrintState(word, playerGuessesList)) {
        //         break;
        //     }

        // }
    }

    private static void inputGuess(String word, List<Character> playerGuessesList) {
        System.out.print("\nEnter your guess: ");
        char letterGuessed = scanner2.next().charAt(0);
        playerGuessesList.add(letterGuessed);
    }

    private static boolean checkIfCompleteOrPrintState(String word, List<Character> playerGuesses) {
        // Replacing '-' with letters guessed by user if they are present in the word
        int correctCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                correctCount++;
            }
            else {
                System.out.print("-");
            }
        }
        
        if (correctCount == word.length()) {
            System.out.println("\nYou Win!");
            return true;
        }
        else
            return false;
    }
}
