import java.util.Scanner;

class P1 {
    public static boolean isValid(String str) {
        if (str.length() < 1) {
            return false;
        }
        if (str.length() == 1) {
            return str.charAt(0) == 'a';
        }

//        int noOfInputSymbols = 2;
//        char inp1 = 'a';
//        char inp2 = 'b';
//        int noOfStates = 4; (1 to 4)
//        int noOfFinalStates = 1;
//        int finalStates = 2;

        //here a = 0, b = 1;
        int[][] transitions = {
                //a//b
                {2, 3}, //1
                {1, 4}, //2
                {4, 1}, //3
                {3, 2}, //4
        };

        int currState = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'b') {
                int ch = str.charAt(i) == 'a' ? 0 : 1;
                currState = transitions[currState - 1][ch];
            } else {
                return false;
            }
        }

        return currState == 2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your string : ");
        String str = in.nextLine();
        if (isValid(str)) {
            System.out.println("String accepted");
        } else {
            System.out.println("String rejected");
        }
    }
}