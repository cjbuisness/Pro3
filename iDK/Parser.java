package iDK;

import java.util.StringTokenizer;

/**
 * Class is parses, and identifies reserved words and identifiers, utilizing both BSTs
 * Tokenizes for better handling durng compilation
 */
public class Parser {
    private final BinarySearchTrees<String> reservedWordsBST;
    private final BinarySearchTrees<String> identifiersBST;

    public Parser(BinarySearchTrees<String> reservedWordsBST, BinarySearchTrees<String> identifiersBST) {
        this.reservedWordsBST = reservedWordsBST;
        this.identifiersBST = identifiersBST;
	//initializes parser with reserved words, and identifiers, BSTs
    }

    public void parseJavaProgram(JavaProgramToBeTested javaProgram) {
        StringTokenizer tokenizer = new StringTokenizer(javaProgram.getContent(), " \t\n\r\f(){}[];,.+-*/%=<>!&|^~", true);
	//parses, identifies, and tokenizes reserved words and identifiers
	//" \t\n\r\f(){}[];,.+-*/%=<>!&|^~" represent delimiters; tokens are separated based on thes characters

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();

            if (reservedWordsBST.contains(token)) {
                System.out.println("Reserved Word: " + token);
		//checks if token is a reserved word
            }
            else if (Character.isLetter(token.charAt(0))) {
                identifiersBST.add(token);
                System.out.println("Identifier: " + token);
		//checks if token begins with a letter (an identifier), adds the identfer to BST, and prints
            }
        }
    }
}
