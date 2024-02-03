import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PigLatin {
    public void tester() {
        String[] lines = new String[8]; // Using an array to store lines from the file
        try {
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("there are " + lines.length + " lines");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(pigLatin(lines[i]));
        }
    }

    public int findFirstVowel(String sWord) {
        for (int i = 0; i < sWord.length(); i++) {
            if (sWord.substring(i, i + 1).equals("a") || sWord.substring(i, i + 1).equals("e")
                    || sWord.substring(i, i + 1).equals("i") || sWord.substring(i, i + 1).equals("o")
                    || sWord.substring(i, i + 1).equals("u")) {
                return i;
            }
        }
        return -1;
    }

    public String pigLatin(String sWord) {
        if (findFirstVowel(sWord) == -1) {
            return sWord + "ay";
        } else if (findFirstVowel(sWord) == 0) {
            return sWord + "way";
        } else if (sWord.substring(0, 2).equals("qu")) {
            return sWord.substring(2) + "quay";
        } else if (findFirstVowel(sWord) != 0) {
            return sWord.substring(findFirstVowel(sWord)) + sWord.substring(0, findFirstVowel(sWord)) + "ay";
        } else {
            return "ERROR";
        }
    }

    public static void main(String[] args) {
        PigLatin pigLatin = new PigLatin();
        pigLatin.tester();
    }
}
