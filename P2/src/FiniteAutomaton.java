import java.util.*;

public class FiniteAutomaton {
    private Map<Integer, Map<Character, Set<Integer>>> transitionTable; // State transitions
    private int initialState;
    private Set<Integer> acceptingStates;

    public FiniteAutomaton(Map<Integer, Map<Character, Set<Integer>>> transitionTable, int initialState, Set<Integer> acceptingStates) {
        this.transitionTable = transitionTable;
        this.initialState = initialState;
        this.acceptingStates = acceptingStates;
    }

    public boolean isAccepted(String input) {
        Set<Integer> currentStates = new HashSet<>();
        currentStates.add(initialState);  // Start from the initial state

        for (char symbol : input.toCharArray()) {
            Set<Integer> nextStates = new HashSet<>();

            for (int state : currentStates) {
                if (transitionTable.containsKey(state) && transitionTable.get(state).containsKey(symbol)) {
                    nextStates.addAll(transitionTable.get(state).get(symbol)); // Get next possible states
                }
            }

            if (nextStates.isEmpty()) {
                return false; // No valid transition, reject
            }

            currentStates = nextStates; // Move to next states
        }

        // Check if any final state is an accepting state
        for (int state : currentStates) {
            if (acceptingStates.contains(state)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define an NFA where the language consists of strings ending with "01"
        Map<Integer, Map<Character, Set<Integer>>> transitionTable = new HashMap<>();

        // Defining transitions (NFA/DFA format)
        transitionTable.put(0, new HashMap<>());
        transitionTable.get(0).put('0', new HashSet<>(Arrays.asList(1)));
        transitionTable.get(0).put('1', new HashSet<>(Arrays.asList(0)));

        transitionTable.put(1, new HashMap<>());
        transitionTable.get(1).put('0', new HashSet<>(Arrays.asList(1)));
        transitionTable.get(1).put('1', new HashSet<>(Arrays.asList(2)));

        transitionTable.put(2, new HashMap<>());
        transitionTable.get(2).put('0', new HashSet<>(Arrays.asList(1)));
        transitionTable.get(2).put('1', new HashSet<>(Arrays.asList(0)));

        int initialState = 0;
        Set<Integer> acceptingStates = new HashSet<>(Collections.singletonList(2)); // Accept if final state is 2

        FiniteAutomaton fa = new FiniteAutomaton(transitionTable, initialState, acceptingStates);

        System.out.print("Enter a binary string: ");
        String input = scanner.next();

        if (fa.isAccepted(input)) {
            System.out.println("Accepted");
        } else {
            System.out.println("Rejected");
        }

        scanner.close();
    }
}
