/*
* Class that reads a file names words.txt and tells the user what the longest word is.
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindLongestWord {
    // Attributes
    private String longestWord = "";
    private String fileName = "words.txt";
    private File myFile = new File(fileName);
    private Scanner fileScan;

    public FindLongestWord() {
        createFileObject();
        findLongestWord();
    }

    // Methods
    /*
    * Creates a Scanner that reads from the words.txt file.
    * If the words.txt file does not exist there is an error message.
    */
    public void createFileObject() {
        try {
            fileScan = new Scanner(myFile);
        }
        catch (FileNotFoundException e) {
            System.out.println("File does not exist.");
        }
    }

    /*
    * Reads one line at a time until there are no other lines.
    * Checks if the length of the word on a line is longer than the previous longestWord.
    * If it is the variable is changed to the newly found longestWord.
    * At the end the program writes out what the longest word is.
    */
    public void findLongestWord() {
        while (fileScan.hasNextLine()) {
            String currentWord = fileScan.nextLine();
            if (currentWord.length() > longestWord.length()) {
                longestWord = currentWord;
            }
        }
        fileScan.close();
        System.out.println("The longest word is: " + longestWord);
    }
}
