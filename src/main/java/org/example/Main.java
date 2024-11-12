package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static boolean isPalindrome(int number) {
        int originalNumber = number;
        int reverse = 0;

        if (number < 0) {
            number = -number;
            originalNumber = -originalNumber;
        }

        while (number > 0) {
            int lastDigit = number % 10;
            reverse = reverse * 10 + lastDigit;
            number /= 10;
        }

        return originalNumber == reverse;
    }

    public static boolean isPerfectNumber(int number) {
        if (number < 1) {
            return false;
        }

        int sum = 0;

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum == number;
    }

    public static String numberToWords(int number) {
        if (number < 0) {
            return "Invalid Value";
        }

        StringBuilder result = new StringBuilder();

        int reversedNumber = reverse(number);
        int originalDigitCount = getDigitCount(number);
        int reversedDigitCount = getDigitCount(reversedNumber);

        while (reversedNumber > 0) {
            int lastDigit = reversedNumber % 10;
            result.append(getDigitWord(lastDigit)).append(" ");
            reversedNumber /= 10;
        }

        for (int i = 0; i < originalDigitCount - reversedDigitCount; i++) {
            result.append(getDigitWord(0)).append(" ");
        }

        return result.toString().trim();
    }

    public static String getDigitWord(int digit) {
        return switch (digit) {
            case 0 -> "Zero";
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            case 4 -> "Four";
            case 5 -> "Five";
            case 6 -> "Six";
            case 7 -> "Seven";
            case 8 -> "Eight";
            case 9 -> "Nine";
            default -> "";
        };
    }

    public static int reverse(int number) {
        int reverse = 0;

        while (number > 0) {
            int lastDigit = number % 10;
            reverse = reverse * 10 + lastDigit;
            number /= 10;
        }

        return reverse;
    }

    public static int getDigitCount(int number) {
        if (number == 0) return 1;
        if (number < 0) number = -number;

        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }


}
