//String over lower case alphabets and digit, starts with alphabet only.

import java.util.*;
class P4 {
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
        // Input symbols : Alphabets (a to z), Numbers (0 to 9)
        // No of states : 3 (1 to 3)
        // No of final states : 1
        // final states : 3

        if (str.length() == 0) {
            return false;
        }

        // Here, alphabet = 0, Numbers = 1
        int[][] transitions = {
                {3, 2}, //1
                {2, 2}, //2
                {3, 3}  //3
        };

        int currState = 1; // starting state
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                int ch = str.charAt(i) >= 'a' && str.charAt(i) <= 'z' ? 0 : 1;
                currState = transitions[currState - 1][ch];
            } else {
                return false;
            }
        }

        return currState == 3;
    }

}
