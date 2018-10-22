import java.io.*;

public class CountVowelMain {

    public static void main(String[] args) {

        FileInputStream fin = null;
        int countVowels = 0;

        try {

            fin = new FileInputStream("text.txt");

            int newChar = -1;

            while((newChar=fin.read())!=-1){
                if (newChar != 10){
                    if (newChar == 'a' || newChar == 'e' || newChar == 'i' ||
                            newChar == 'o' || newChar == 'u' || newChar == 'y') {
                        countVowels++;
                    }
                }
                else {
                    System.out.println("This line contains " + countVowels + " vowels");
                    countVowels = 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}