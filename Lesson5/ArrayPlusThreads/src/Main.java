import java.lang.Math;
import java.util.Arrays;
import java.util.List;

public class Main extends Thread {

    static final int size = 10_000_000;
    static final int h = size / 2;

    public static void main(String[] args) {

        float[] arr = new float[size];


        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Time elapsed on filling the array with 1's is " + elapsedTime);


        startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            // System.out.println(arr[i]);
        }
        elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Time elapsed on filling the array with the formula is " + elapsedTime);


        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        fillArrayWithThreads(arr);
    }

    public static void fillArrayWithThreads(float[] initArray) {

        long startSplit = System.currentTimeMillis();
        float[] firstPartArray = new float[h];
        float[] secondPartArray = new float[h];
        System.arraycopy(initArray, 0, firstPartArray, 0, initArray.length / 2);
        System.arraycopy(initArray, h, secondPartArray, 0, initArray.length / 2);
        long splitTime = System.currentTimeMillis() - startSplit;
        System.out.println("Time of the split of initial array = " + splitTime);


        Thread thread1 = new Thread(() -> {
            long startThread1 = System.currentTimeMillis();
            for (int i = 0; i < h; i++) {
                firstPartArray[i] = (float) (firstPartArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            long finishThread1 = System.currentTimeMillis() - startThread1;
            System.out.println("Thread #1 time = " + finishThread1);
        });

        Thread thread2 = new Thread(() -> {
            long startThread2 = System.currentTimeMillis();
            //int i;
            for (int i = h; i < size; i++) { //  (int k = 0; k < h; k++)
                secondPartArray[i - h] = (float) (secondPartArray[i - h] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            long finishThread2 = System.currentTimeMillis() - startThread2;
            System.out.println("Thread #2 time = " + finishThread2);
        });

        try {
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long startMerge = System.currentTimeMillis();
        float[] targetArray = new float[initArray.length];
        System.arraycopy(firstPartArray, 0, targetArray, 0, initArray.length / 2);
        System.arraycopy(secondPartArray, 0, targetArray, h, initArray.length / 2);
        long finishMerge = System.currentTimeMillis() - startMerge;
        System.out.println("Time of merge = " + finishMerge);

        long elapsedTime = System.currentTimeMillis() - startSplit;
        System.out.println("Total elapsed time on filling the array with the formula and 2 threads is " + elapsedTime);
    }
}
