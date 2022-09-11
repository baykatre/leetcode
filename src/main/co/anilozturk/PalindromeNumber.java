package src.main.co.anilozturk;

import com.sun.source.tree.BreakTree;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(34564));
        System.out.println(isPalindrome(34543));


    }

    static boolean isPalindrome(int x) {

        if(x < 0) {
            return false;
        }

        int digit = getDigit(x);
        int result = 0;
        int input = x;

        while(digit != 0){
            result += input % 10 * getFactor(digit - 1);
            input = input/10;
            digit--;
        }

        return result == x;
    }

    static int getFactor(int digit){
        return (int) Math.pow(10, digit);
    }

    static int getDigit(int number){
        if (number < 100000) {
            if (number < 100) {
                if (number < 10) {
                    return 1;
                } else {
                    return 2;
                }
            } else {
                if (number < 1000) {
                    return 3;
                } else {
                    if (number < 10000) {
                        return 4;
                    } else {
                        return 5;
                    }
                }
            }
        } else {
            if (number < 10000000) {
                if (number < 1000000) {
                    return 6;
                } else {
                    return 7;
                }
            } else {
                if (number < 100000000) {
                    return 8;
                } else {
                    if (number < 1000000000) {
                        return 9;
                    } else {
                        return 10;
                    }
                }
            }
        }
    }
}
