import java.util.Scanner;

public class TestArrayExceptions {

    public static void main(String[] args) {

        int sum = 0;

        System.out.println("Enter 1 to run the code with correct Array, 2 for Array with incorrect size" +
                " and 3 for Array with incorrect data type: ");
        Scanner scanner = new Scanner(System.in);

        String[][] strCorrectArray = {{"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}};

        String[][] strIncorrectSizeArray = {{"165", "35", "463", "56"},
                {"51", "46", "565", "784"}};

        String[][] strIncorrectTypeArray = {{"1653", "7", "45", "5"},
                {"521", "464", "4", "74"},
                {"561", "225", "584", "77"},
                {"984", "23", "u", "5446"}};

        String[][] testStringArray = new String[4][4];
        switch (scanner.next()) {
            case "1":
                testStringArray = strCorrectArray;
                break;
            case "2":
                testStringArray = strIncorrectSizeArray;
                break;
            case "3":
                testStringArray = strIncorrectTypeArray;
                break;
        }

        int[][] intArray = new int[4][4];

        // checks MyArraySizeException
        if ((intArray[0].length != testStringArray[0].length) || (intArray.length != testStringArray.length))
            throw new MyArraySizeException("Size should be 4x4!");

            // checks MyArrayDataException
        else if (checkString2IntCorrectness(testStringArray)) {
            for (int i = 0; i < intArray.length; i++) {
                for (int j = 0; j < intArray.length; j++) {
                    sum += Integer.valueOf(testStringArray[i][j]);
                }
            }
        }
        System.out.println("Sum of the elements is " + sum);
    }

    // Checks whether the conversion of String array to int array is possible
    public static boolean checkString2IntCorrectness(String[][] inputStrArray) {
        for (int i = 0; i < inputStrArray.length; i++) {
            for (int j = 0; j < inputStrArray[0].length; j++) {
                if (!checkEachChar(inputStrArray[i][j])) {
                    throw new MyArrayDataException("String Array should contains only numeric symbols, error in the cell " + "i = " + i + " , j = " + j);
                }
            }
        }
        return true;
    }

    // Check whether each symbol in the String cell contains not a number symbols
    public static boolean checkEachChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < 48 || str.charAt(i) > 57) {
                return false;
            }
        }
        return true;
    }
}
