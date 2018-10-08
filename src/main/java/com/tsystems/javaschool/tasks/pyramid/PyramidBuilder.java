package com.tsystems.javaschool.tasks.pyramid;

import java.util.List;

public class PyramidBuilder {

    /**
     * Builds a pyramid with sorted values (with minumum value at the top line and maximum at the bottom,
     * from left to right). All vacant positions in the array are zeros.
     *
     * @param inputNumbers to be used in the pyramid
     * @return 2d array with pyramid inside
     * @throws {@link CannotBuildPyramidException} if the pyramid cannot be build with given input
     */
    public int[][] buildPyramid(List<Integer> inputNumbers) {
        // TODO : Implement your solution here

        Integer[] numbersArray = new Integer[inputNumbers.size()];
        numbersArray = inputNumbers.toArray(numbersArray);

        // bubble sorting of the array
        int correctedNumbers;
        do
        {
            for (int k = 0; k < (numbersArray.length - 1); k++) {
                if (numbersArray[k] < numbersArray[k + 1]) {
                    int tempSmall = numbersArray[k];
                    int tempBig = numbersArray[k + 1];
                    numbersArray[k + 1] = tempSmall;
                    numbersArray[k] = tempBig;
                }
            }
            int k;
            for (k = 0; k < (numbersArray.length - 1); k++) {
                if (numbersArray[k] < numbersArray[k + 1]) {
                    break;
                }
            }
            correctedNumbers = k;
        } while (correctedNumbers < (numbersArray.length - 1));

       /*get the boolean to mark whether it's possible to build a pyramid - boolean pyramidPossible,
        the amount of cells on the bottom - int pyramidWidth
       and number of rows - int pyramidHeight*/
        boolean pyramidPossible = false;
        int remainder = numbersArray.length;
        int pyramidWidth = 0;
        int pyramidHeight = 0;
        for (int i = 0; i < numbersArray.length ; i++) {
            remainder = remainder - i;
            if (remainder == 0) {
                pyramidPossible = true;
                pyramidWidth = 2*i - 1;
                pyramidHeight = i;
                break;
            }
        }

        // get the pyramid
        int[][] pyramid = new int[pyramidHeight][pyramidWidth];
        try {
            if (!pyramidPossible)
                throw new CannotBuildPyramidException();
            int index = 0;
            int jStart = (pyramidWidth - 1);
            int jFinish = 0;
            for (int i = (pyramidHeight - 1); i >= 0; i--) {
                for (int j = jStart; j >= jFinish; j -= 2) {
                    pyramid[i][j] = numbersArray[index];
                    index++;
                    if (index == (numbersArray.length - 1))
                        break;
                }
                jStart--;
                jFinish++;
            }
        } catch (CannotBuildPyramidException e) {
            System.out.println("The pyramid cannot be built for such input array");
        }
        return pyramid;
    }

}
