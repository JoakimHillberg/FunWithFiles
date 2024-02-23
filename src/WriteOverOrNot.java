/*
* Klass som skapar, skriver i och läser från en fil.
*/
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteOverOrNot {
    // Attributes
    private String fileName = "writeOverFile.txt";
    private File myFile;

    // Constructor
    // Kör alla klassens metoder när "new WriteOverOrNot()" körs i Main
    public WriteOverOrNot() {
        createFile();
        writeToFile();
        System.out.println("File contents:");
        readFromFile();
    }

    // Methods
    /*
    * Metod som frågar användaren om de vill lägga till något i textfilen eller skriva över det tidigare innehållet
    * Frågar därefter användaren vad de vill skriva in och lägger in det i .txt filen
    * Med en try-catch så att programmet inte kraschar om en IOException sker
    */
    public void writeToFile() {
        Scanner myScan = new Scanner(System.in);
        FileWriter myFileWriter;

        System.out.print("Write over previous contents(y/n): ");
        String response = myScan.nextLine();

        while (true) {
            if (!response.equals("y") && !response.equals("n")) {
                System.out.print("Write y for yes or n for no: ");
                response = myScan.nextLine();
            }
            else {
                try {
                    if (response.equals("y")) {
                        myFileWriter = new FileWriter(myFile, false);
                        break;
                    }
                    else {
                        myFileWriter = new FileWriter(myFile, true);
                        break;
                    }
                }
                catch (IOException e) {
                    System.out.println("IO error");
                }
            }
        }

        try {
            System.out.print("Input String to add to file: ");
            myFileWriter.write(myScan.nextLine());
            myFileWriter.close();
            System.out.println("String written to file");
        }
        catch (IOException e) {
            System.out.println("IO error");
        }
    }

    /*
    * Metod som läser allt som står i filen och skriver ut det
    * Med en try-catch så att programmet inte kraschar om en IOException sker
    */
    public void readFromFile() {
        try {
            Scanner fileScan = new Scanner(myFile);

            while (fileScan.hasNextLine()) {
                System.out.println(fileScan.nextLine());
            }
        }
        catch (IOException e) {
            System.out.println("IO error");
        }
    }

    /*
    * Metod som skapar en ny fil så länge den inte redan existerar
    * Med en try-catch så att programmet inte kraschar om en IOException sker
    */
    public void createFile() {
        myFile = new File(fileName);

        try {
            if (myFile.createNewFile()) {
                System.out.println("File has been created");
            }
            else {
                System.out.println("File already exists");
            }
        }
        catch (IOException e) {
            System.out.println("IO error");
        }
    }
}
