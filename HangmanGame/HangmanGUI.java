package HangmanGame;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

/**
 * This class contains some example code, which you can use for your
 * HangmanGUI. 
 */
public class HangmanGUI extends JFrame {
  
  // Hint: for this class, you can make any GUI-related instance
  // variable (e.g., JButton) public, rather than private.
  
  public HangmanGUI() {
    
    // The grid of letters.
    JPanel letters = new JPanel();
    
    // GridLayouts add components along the first row,
    // then the second, and so on. If more elements are
    // added than can fit into the specified dimensions,
    // more columns are added to the layout.
    // This example is of a 2 by 13 grid.
    letters.setLayout(new GridLayout(2, 13));
    
    // Create the JButtons that will represent the letters. 
    // In this example, we are making a 2 by 13 grid with 26 buttons.
    for(int i = 0; i < 26; i++) {
      JButton letterButton = new JButton("" + (char)('A' + i));
      
      // Set some formatting details.
      letterButton.setHorizontalAlignment(SwingConstants.CENTER);
      letterButton.setVerticalAlignment(SwingConstants.CENTER);
      letterButton.setBorder(new LineBorder(Color.BLACK));
      letterButton.setFont(new Font("Arial", Font.PLAIN, 50));
      //letterButton.setBackground(Color.WHITE);
      //letterButton.setForeground(Color.BLACK);
      
      // add the button to the panel
      letters.add(letterButton);
    }
    
    // The "Hint" button, on a separate panel (for nicer spacing)
    JPanel hintPanel = new JPanel();
    hintPanel.setLayout(new FlowLayout());
    
    JButton hintButton = new JButton("Give me a hint!");
    hintButton.setFont(new Font(null, Font.ITALIC, 25));    
    hintPanel.add(hintButton);
    
     // The panel for the Guesses left.
    JPanel guessesPanel = new JPanel();
    guessesPanel.setLayout(new FlowLayout());
    
    // The label with the Guesses left
    JLabel guessesLabel = new JLabel("Guesses left: "); 
    guessesLabel.setFont(new Font(null, Font.BOLD, 20));
    
    // Initialize the guesses to the number specified by user.
    // YOU SHOULD CHANGE THIS LINE! shouldn't actually be 5!
    JLabel guesses = new JLabel("5"); 
    
    guesses.setFont(new Font(null, Font.ITALIC, 20));
    
    // Because the guessesPanel has a flowLayout, each item that is added
    // is placed to the right of the last one. 
    guessesPanel.add(guessesLabel);
    guessesPanel.add(guesses);
    
    // The panel for the Misses.
    JPanel missesPanel = new JPanel();
    missesPanel.setLayout(new FlowLayout());
    
    // The label with the Misses
    JLabel missesLabel = new JLabel("Misses: "); 
    missesLabel.setFont(new Font(null, Font.BOLD, 20));
    
    // Initialize the misses to none.
    JLabel misses = new JLabel("none");
    misses.setFont(new Font(null, Font.ITALIC, 20));
    
    missesPanel.add(missesLabel);
    missesPanel.add(misses);
       
    // The panel that contains the Guesses left, the Misses, and the hint button.
    JPanel middlePanel = new JPanel();
    middlePanel.setLayout(new GridLayout(6, 1));
  
    middlePanel.add(new JPanel()); // this is just for nicer spacing
    middlePanel.add(guessesPanel);
    middlePanel.add(missesPanel);
    middlePanel.add(new JPanel()); // this is just for nicer spacing
    middlePanel.add(hintPanel);
    middlePanel.add(new JPanel()); // this is just for nicer spacing
    
    // This is the whole game window, containing all the necessary
    // GUI components. 
    // The BorderLayout lets us specify where in the frame we want each item
    // to be positioned.
    JPanel wholePane = new JPanel();
    wholePane.setLayout(new BorderLayout());
    wholePane.add(middlePanel, "Center");
    wholePane.add(letters, "South");
    
    // THE TOP PANEL IS MISSING...
    // PUT YOUR CODE FOR THE WORD TO GUESS HERE!
    
    // Use similar formatting settings as those for letterButtons above.
    // (hint: use the Color Light Gray as the background)
    
    // Pay special attention to spaces, if there is more than one word in the
    // entity you have to guess.
    // ex. "United States" <-- 2 words, need a visible space between them.
    // (hint: use 10 spaces. i.e. String s = "          ").
    
    // Hint: don't forget to add the word panel to the "North" part
    // of wholePane.
 
    
    // set the content pane of the window to the panel
    this.setContentPane(wholePane);
    
    // Ensure that the program ends when you close the game window.
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    // display the window
    this.setTitle("Hangman!");
    this.pack();
    this.setVisible(true);
  }
  
}
