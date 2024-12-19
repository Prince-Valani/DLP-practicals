//String over 0 and 1 where every 0 immediately followed by 11.

import java.util.*;
class P2 {
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
        // Input symbols : 0, 1
        // No of states : 4 (1 to 4)
        // No of final states : 1
        // final states : 1

        int[][] transitions = {
                //0//1
                {2, 1}, //1
                {4, 3}, //2
                {4, 1}, //3
                {4, 4}, //4
        };

        int currState = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0' || str.charAt(i) == '1') {
                int ch = str.charAt(i) == '0' ? 0 : 1;
                currState = transitions[currState - 1][ch];
            } else {
                return false;
            }
        }

        return currState == 1;
    }

}
