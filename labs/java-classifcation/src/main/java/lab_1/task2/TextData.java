package lab_1.task2;

import lab_0.ReadFile;

import java.io.IOException;
import java.nio.file.Paths;

public class TextData {
    private String fileName;
    private String text;
    private int numberOfVowels;
    private int numberOfConsonants;
    private int numberOfLetters;
    private int numberOfSentences;
    private String longestWord;

    public TextData(String path) throws IOException {
        fileName = Paths.get(path).getFileName().toString();
        ReadFile data = new ReadFile();
        text = data.readFileIntoString(path);
    }
    public String getFilename() {
        return fileName;
    }
    public String getText() {
        return text;
    }
    public int getNumberOfVowels() {
        numberOfVowels = 0;
        String vowels = "AEIOUaeiou";

        for (int i = 0; i < text.length(); i++) {
            if (vowels.indexOf(text.charAt(i)) != -1) {
                numberOfVowels++;
            }
        }
        return numberOfVowels;
    }
    public int getNumberOfConsonants() {
        numberOfConsonants = 0;
        String vowels = "AEIOUaeiou";

        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i)) && vowels.indexOf(text.charAt(i)) == -1) {
                numberOfConsonants++;
            }
        }
        return numberOfConsonants;
    }
    public int getNumberOfLetters() {
        numberOfLetters = 0;

        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))) {
                numberOfLetters++;
            }
        }
        return numberOfLetters;
    }
    public int getNumberOfSentences() {
        numberOfSentences = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '.') {
                numberOfSentences++;
            }
        }
        return numberOfSentences;
    }
    public String getLongestWord() {
        String words[] = text.split(" ");
        int maxLength = 0;
        longestWord = "";

        for (String word : words) {
            if (word.chars().allMatch(Character::isLetter)) {
                if (word.length() > maxLength) {
                    maxLength = word.length();
                    longestWord = word;
                }
            }
        }
        return longestWord;
    }

    public static void main(String[] args) throws IOException {

        for (String path : args) {
            try {
                TextData file = new TextData(path);

                System.out.println();
                System.out.println("Filename: " + file.getFilename());
                System.out.println("Text: " + file.getText());
                System.out.println("Nr. of vowels: " + file.getNumberOfVowels());
                System.out.println("Nr. of consonants: " + file.getNumberOfConsonants());
                System.out.println("Nr. of letters: " + file.getNumberOfLetters());
                System.out.println("Nr. of sentences: " + file.getNumberOfSentences());
                System.out.println("The longest word: " + file.getLongestWord());

            } catch (IOException e) {
                System.out.println("Error reading file: " + path + " - " + e.getMessage());
            }
        }
    }
}
