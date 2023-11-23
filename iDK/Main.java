package iDK;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Class initializes BST for reserved words & identifiers, reads program files, populates BSTs, and prints in-order traversals
 *
 * Note that the filepath utilized is custom to my machine, and will need to be updated to the specific machine utilized
 */
public class Main {
    public static void main(String[] args) {
        // Initialize BSTs for reserved words and identifiers
        BinarySearchTrees<String> reservedWordsBST = new BinarySearchTrees<>();
        BinarySearchTrees<String> identifiersBST = new BinarySearchTrees<>();

        // Read the Java program file
        JavaProgramToBeTested javaProgram = readJavaProgram("C:\\Users\\Default.DESKTOP-JMBKVIA\\Desktop\\Palindrome.java");
	//reads java program file form my custom flepath

        // Initialize and populate the BST for reserved words
        initializeReservedWords(reservedWordsBST);
	//initializes and populates BST for reserved words

        parseIdentifiers(javaProgram.getContent(), identifiersBST);
	//parses identifiers and populates BST for identifiers

        printInOrderTraversal("In-order traversal of Reserved Words BST:", reservedWordsBST);
        printInOrderTraversal("\nIn-order traversal of Identifiers BST:", identifiersBST);
	//prints in-order traversal of all BSTs
    }

    private static void initializeReservedWords(BinarySearchTrees<String> reservedWordsBST) {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Default.DESKTOP-JMBKVIA\\Desktop\\reservedWords.txt", StandardCharsets.UTF_8))) {
            reader.lines().map(String::trim).forEach(reservedWordsBST::add);
        } catch (IOException e) {
            e.printStackTrace();
	//initializes BST for reserved words, readng from file
        }
    }

    private static JavaProgramToBeTested readJavaProgram(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8))) {
            reader.lines().forEach(line -> contentBuilder.append(line).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JavaProgramToBeTested(contentBuilder.toString());
	//reads content of file from flepath, returns instance of JavaProgramToBeTested
    }

    private static void parseIdentifiers(String javaProgramContent, BinarySearchTrees<String> identifiersBST) {
        String[] words = javaProgramContent.split("\\W+");
        for (String word : words) {
            if (Character.isLetter(word.charAt(0))) {
                identifiersBST.add(word);
	//parses identifiers, and populates BST for identifiers
            }
        }
    }

    private static void printInOrderTraversal(String message, BinarySearchTrees<String> bst) {
        System.out.println(message);
        bst.inOrderTraversal();
	//prints BST in-order traversal & "message"
    }
}
