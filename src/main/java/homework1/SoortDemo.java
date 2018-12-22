package homework1;

import java.lang.reflect.Array;
import java.util.Scanner;

public class SoortDemo {
    private static int[] inputIntegers;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int arrLength;

            System.out.println("Input array langth:");
            arrLength = sc.nextInt();

            inputIntegers = new int[arrLength];
            for (int i = 0; i < arrLength; i++) {
                inputIntegers[i] = sc.nextInt();
            }

            printArr(bubbleSort(inputIntegers));

            quickSort(0, arrLength - 1);
            printArr(inputIntegers);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int[] bubbleSort(int[] arr) {
        int buffer;
        for (int i = 0; i < arr.length; i++)
            for (int j = 1; j < arr.length - i; j++)
                if (arr[j - 1] > arr[j]) {
                    buffer = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = buffer;
                }
        return arr;
    }

    private static void quickSort(int low, int high) {
        if (low <= high)
            return;
        int i = low, j = high;
        int cur = i - (i - j) / 2;
        int temp;
        while (i < j) {
            while (i < cur && (inputIntegers[i] <= inputIntegers[cur]))
                i++;
            while (j > cur && (inputIntegers[j] >= inputIntegers[cur]))
                j--;
            if (i < j) {
                temp = inputIntegers[i];
                inputIntegers[i] = inputIntegers[j];
                inputIntegers[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        quickSort(low, cur);
        quickSort(cur + 1, high);

    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
