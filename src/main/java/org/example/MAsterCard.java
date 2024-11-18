package org.example;

import java.util.ArrayList;
import java.util.List;

public class MAsterCard {

    // Online Java Compiler
// Use this editor to write, compile and run your Java code online

    public static List<Integer> primeNumbers(int lowerLimit, int upperLimit) {
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = lowerLimit; i <= upperLimit; i++) {
            if (i != 1) {
                boolean isPrime = true;
                {
                    isPrime = true;
                    for (int j = 2; j < i; j++) {
                        if (i % j == 0) {
                            isPrime = false;
                            break;
                        } else {
                            isPrime = true;
                        }
                    }
                    if (isPrime) {
                        primeNumbers.add(i);
                    }
                }

            }
        }
        return primeNumbers;
    }

    public static void main(String[] args) {
        //primeNumbers(1,100);
        System.out.println(primeNumbers(1, 100));
    }
}
