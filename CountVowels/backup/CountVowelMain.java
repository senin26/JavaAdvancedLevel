import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CountVowelMain {


    public static void main(String[] args) {

        BufferedReader bufferedReader = null;
        String newLine;
        int countVowels = 0;

        try {

            bufferedReader = new BufferedReader(new FileReader("text.txt"));

            while (bufferedReader.readLine() != null) {
                newLine = bufferedReader.readLine();
                System.out.println(newLine);
                for (int i = 0; i < newLine.length(); i++) {
                    if (newLine.toLowerCase().charAt(i) == 'a' || newLine.toLowerCase().charAt(i) == 'e' || newLine.toLowerCase().charAt(i) == 'i' ||
                            newLine.toLowerCase().charAt(i) == 'o' ||
                            newLine.toLowerCase().charAt(i) == 'u' || newLine.toLowerCase().charAt(i) == 'u' || newLine.toLowerCase().charAt(i) == 'y') {
                        countVowels++;
                    }
                }
                System.out.println("This line contains " + countVowels + " vowels");
                countVowels = 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//bufferedReader = Files.newBufferedReader(Paths.get("C:\\Coding\\Java\\GEEKBRAINS\\JavaCoreПродвинутыйУровень\\Урок1\\CountVowels\\src\\text"),StandardCharsets.UTF_8);