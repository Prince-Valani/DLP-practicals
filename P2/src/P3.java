//String over a, b, c should starts and ends with same symbols.

import java.util.*;
class P3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your string : ");
        String str = in.nextLine();
        if (isValid(str)) {
            System.out.println("accepted");
        } else {
            System.out.println("rejected");
        }
    }

    public static boolean isValid(String str) {
        // Input symbols : a, b, c
        // No of states : 7 (0 to 6)
        // No of final states : 3
        // final states : 0, 1, 2, 3

        // Here, a = 0, b = 1, c = 2

        if (str.length() == 0) {
            return true;
        }

        int[][] transitions = {
                //0//1//2
                {1, 2, 3}, //0
                {1, 4, 4}, //1
                {5, 2, 5}, //2
                {6, 6, 3}, //3
                {1, 4, 4}, //4
                {5, 2, 5}, //5
                {6, 6, 3}, //6
        };

        int currState = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'b' || str.charAt(i) == 'c') {
                int ch;
                if (str.charAt(i) == 'a'){
                    ch = 0;
                } else if (str.charAt(i) == 'b') {
                    ch = 1;
                } else {
                    ch = 2;
                }
                currState = transitions[currState][ch];
            } else {
                return false;
            }
        }

        return currState == 1 || currState == 2 || currState == 3;
    }

}
