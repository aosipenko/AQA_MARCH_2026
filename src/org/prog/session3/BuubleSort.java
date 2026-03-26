package org.prog.session3;

import java.util.Arrays;

public class BuubleSort {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 1, 9, 3, 7, 4, 6};

        System.out.println("Before: " + Arrays.toString(numbers));

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

        System.out.println("After:  " + Arrays.toString(numbers));
    }
}