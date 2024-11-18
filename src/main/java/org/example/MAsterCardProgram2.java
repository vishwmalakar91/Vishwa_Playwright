package org.example;

public class MAsterCardProgram2 {


    public static void main(String[] args) {

        int numbers[] = {4, 56, 4, 66, 90, 30, 99, 5, 6};
        //List<int[]> listOfInt = Arrays.asList(myNumbers);

        int length = numbers.length;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] < numbers[j + 1]) {
                    // Swap numbers[j] and numbers[j + 1]
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

        for (int k = 0; k < numbers.length; k++) {
            System.out.println(numbers[k]);
        }


    }
}
