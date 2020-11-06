import javax.sound.sampled.Line;
import java.io.*;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.*;
import java.nio.file.*;

class Main {
    public static void main(String[] args) throws IOException {
        //call the check case function using the object for Main class
        String[] wordList = new String[] {
                "one",
                "two"
        };

        System.out.println(format("a.txt", wordList, "UpperCase"));
    }
    static String checkCase(String word) {
        if (isUpperCase(word)) return "UpperCase";
        else if (isLowerCase(word)) return "LowerCase";
        else if (isTitleCase(word)) return "TitleCase";
        else
            return "No matching case!";
    }
    public static String changeCase(String word, String format) {
        if (format.equals("UpperCase")) {
            return word.toUpperCase();
        } else if (format.equals("LowerCase")) {
            return word.toLowerCase();
        } else {
            char ch = word.charAt(0);
            return (Character.toUpperCase(ch) + word.substring(1));
        }
    }
    public static boolean isUpperCase(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isUpperCase(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public static boolean isLowerCase(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isLowerCase(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public static boolean isTitleCase(String s) {
        if (Character.isUpperCase(s.charAt(0))) {
            for (int i = 1; i < s.length(); i++) {
                if (!Character.isLowerCase(s.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else return false;
    }

    public static int format(String filePath, String[] wordsToFormat, String format) throws IOException {
        int count = 0;

        //file object from give file path
        File file = new File(filePath);

        FileReader fr = new FileReader(file);


        //Buffered file for fast I/O
        BufferedReader br = new BufferedReader(fr);

        File tempFile = new File("temp.txt");
        FileWriter fw = new FileWriter(tempFile);


        //mapping each word to be formatted into a hash map to reduce complexity()
        HashMap < String, Integer > map = new HashMap < > ();

        for (String word: wordsToFormat) {
            map.put(word, 0);
        }

        //processng file
        String str;
        while ((str = br.readLine()) != null) {
            String[] arr = str.split(" ");

            for (String word: arr) {
                if (map.containsKey(word)) {
                    count++;
                }
            }
        }

            br = new BufferedReader(new FileReader(file));
            String Line;
            while ((Line = br.readLine()) != null) {
                for(String word: wordsToFormat) {
                    Line = Line.replaceAll(word, changeCase(word, format));
                }
                fw.write(Line + "\n");
            }
        br.close();
        fw.close();
        fr.close();
        file.delete();

        tempFile.renameTo(file);
        return count;
    }
}