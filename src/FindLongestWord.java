/*
* klass som läser från filen words.txt och berättar för användaren vilket ord som är längst.
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
    * Skapar en Scanner som läser från words.txt filen.
    * Om words.txt filen inte finns skickas ett felmeddelande.
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
    * Läser en rad i taget tills programmet gått igenom hela filen.
    * Kollar om längden av ordet på än rad är längre än tidigare longestWord.
    * Om det är längre byts longestWord till det nya ordet.
    * I slutet skriver porgrammet ut vad det längsta ordet i filen är.
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
