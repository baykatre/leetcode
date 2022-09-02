package src.main.co.anilozturk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class IntToRoman {

    static int M = 1000;
    static int D = 500;
    static int C = 100;
    static int L = 50;
    static int X = 10;
    static int V = 5;
    static int I = 1;

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));

        System.out.println(intToRoman(10));

    }

    static String intToRoman(int s) {

        String result = "";
        List<Character> characterList = new ArrayList<>();
        int input = s;
        int digitCount = 0;

        for(int i = 0; i < getDigit(s); i++){
            int value = input % 10;
            if(value == 0){
                digitCount++;
                input /= 10;
                continue;
            }
            char charValue = getValue(value);
            if(Character.MIN_VALUE == charValue){
                charValue = getValue((value + 1) * getFactor(digitCount));
                if(Character.MIN_VALUE != charValue) {
                    characterList.add(charValue);
                    char preSign = getValue(getFactor(digitCount));
                    characterList.add(preSign);
                }
                else {
                    for (int j = 0; j < value; j++) {
                        char c = getValue((value - j) * getFactor(digitCount));
                        if(Character.MIN_VALUE != c){
                            characterList.add(c);
                            break;
                        }
                        characterList.add(getValue(getFactor(digitCount)));
                    }
                }
            }
            else{
                characterList.add(getValue(value * getFactor(digitCount)));
            }
            digitCount++;
            input /= 10;
        }
        Collections.reverse(characterList);
        return characterList.stream().map(String::valueOf).collect(Collectors.joining());
    }

    static int getFactor(int digit){
        return (int) Math.pow(10, digit);
    }

    static char getValue(int i){
        if (i == I)
            return 'I';
        if (i == V)
            return 'V';
        if (i == X)
            return 'X';
        if (i == L)
            return 'L';
        if (i == C)
            return 'C';
        if (i == D)
            return 'D';
        if (i == M)
            return 'M';
        return Character.MIN_VALUE;
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
