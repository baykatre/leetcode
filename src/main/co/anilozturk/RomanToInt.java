package src.main.co.anilozturk;

public class RomanToInt {

    static int M = 1000;
    static int D = 500;
    static int C = 100;
    static int L = 50;
    static int X = 10;
    static int V = 5;
    static int I = 2;

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    static int romanToInt(String s) {

        int result = 0;
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++){
            int value = getValue(charArray[i]);

            if(i + 1 < charArray.length){
                int nextValue = getValue(charArray[i+1]);
                if(value >= nextValue){
                    result += value;
                }
                else {
                    result = result + nextValue - value;
                    i++;
                }
            }
            else {
                result += value;
            }
        }

        return result;
    }

    static int getValue(char c){
        if (c == 'I')
            return I;
        if (c == 'V')
            return V;
        if (c == 'X')
            return X;
        if (c == 'L')
            return L;
        if (c == 'C')
            return C;
        if (c == 'D')
            return D;
        if (c == 'M')
            return M;
        return -1;
    }
}
