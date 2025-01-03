import java.io.*;
import java.util.*;

public class P3_Lexical_analyzer {

    // Define C keywords
    private static final Set<String> KEYWORDS = Set.of(
            "auto", "break", "case", "char", "const", "continue", "default", "do", "double",
            "else", "enum", "extern", "float", "for", "goto", "if", "int", "long", "register",
            "return", "short", "signed", "sizeof", "static", "struct", "switch", "typedef",
            "union", "unsigned", "void", "volatile", "while"
    );

    // Define C operators
    private static final Set<String> OPERATORS = Set.of(
            "+", "-", "*", "/", "%", "++", "--", "=", "==", "!=", "<", "<=", ">", ">=",
            "&&", "||", "!", "&", "|", "^", "~", "<<", ">>", "+=", "-=", "*=", "/=", "%=",
            "&=", "|=", "^=", "<<=", ">>="
    );

    // Define C punctuations
    private static final Set<Character> PUNCTUATIONS = Set.of(
            ';', ',', '(', ')', '{', '}', '[', ']', '.'
    );

    public static void main(String[] args) throws IOException {
        // File containing C source code
        String filePath = "C:\\Users\\Destiny\\Desktop\\SEM-06\\DLP\\Practicals\\P3\\src\\cCode.c"; // Replace with your file path

        // Sets to store different tokens
        Set<String> tokens = new HashSet<>();
        Set<String> identifiers = new HashSet<>();
        Set<String> operators = new HashSet<>();
        Set<Character> punctuations = new HashSet<>();
        Set<String> keywords = new HashSet<>();

        // Read the C source code
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        boolean inMultiLineComment = false;
        while ((line = reader.readLine()) != null) {
            line = line.trim();

            // Handle multi-line comments
            if (inMultiLineComment) {
                if (line.contains("*/")) {
                    inMultiLineComment = false;
                    line = line.substring(line.indexOf("*/") + 2).trim();
                } else {
                    continue;
                }
            }

            // Remove single-line comments
            if (line.contains("//")) {
                line = line.substring(0, line.indexOf("//")).trim();
            }

            // Check for start of multi-line comment
            if (line.contains("/*")) {
                inMultiLineComment = true;
                line = line.substring(0, line.indexOf("/*")).trim();
            }

            // Tokenize the line
            String[] splitTokens = line.split("\\s+|(?=[{}()\\[\\].,;+-/*%<>=!&|^~])|(?<=[{}()\\[\\].,;+-/*%<>=!&|^~])");

            for (String token : splitTokens) {
                if (token.isEmpty()) continue;
                tokens.add(token);

                // Check for keywords
                if (KEYWORDS.contains(token)) {
                    keywords.add(token);
                } else if (OPERATORS.contains(token)) {
                    operators.add(token);
                } else if (token.length() == 1 && PUNCTUATIONS.contains(token.charAt(0))) {
                    punctuations.add(token.charAt(0));
                } else if (Character.isJavaIdentifierStart(token.charAt(0))) {
                    identifiers.add(token);
                }
            }
        }
        reader.close();

        // Print the results
        System.out.println("Tokens: " + tokens);
        System.out.println("Identifiers: " + identifiers);
        System.out.println("Operators: " + operators);
        System.out.println("Punctuations: " + punctuations);
        System.out.println("Keywords: " + keywords);
    }
}
