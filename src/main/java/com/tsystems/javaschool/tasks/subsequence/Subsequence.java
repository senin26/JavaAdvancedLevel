package com.tsystems.javaschool.tasks.subsequence;

import java.util.List;

public class Subsequence {

    /**
     * Checks if it is possible to get a sequence which is equal to the first
     * one by removing some elements from the second one.
     *
     * @param x first sequence
     * @param y second sequence
     * @return <code>true</code> if possible, otherwise <code>false</code>
     */
    @SuppressWarnings("rawtypes")
    public boolean find(List x, List y) {
        // TODO: Implement the logic here
        boolean possible = false;
        int indexObjX = 0;
        for (Object eachElement : y) {
            if (x.get(indexObjX).equals(eachElement)) {
                indexObjX++;
                if (indexObjX == x.size()) {
                    possible = true;
                    break;
                }
            }
        }
        return possible;
    }
}
