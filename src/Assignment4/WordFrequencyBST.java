package Assignment4;

import java.util.*;

class WordFrequencyBST {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BST bst = new BST("");

        System.out.print("Enter your text: ");
        String text = scanner.nextLine().toLowerCase();

        System.out.print("Order (1 : Increasing | 2 : Decreasing): ");
        int order = scanner.nextInt();

        // Split text into words and add to BST
        String[] words = text.split("\\W+");
        for (String word : words) {
            if (!word.isEmpty()) {
                bst.addWord(word);
            }
        }

        // Get words in alphabetical order
        List<BST> nodesInAlphabetical = new ArrayList<>();
        bst.getWordsAlphabetical(nodesInAlphabetical);


        if (order == 2) {
            System.out.println("\n    In Decreasing Order");
            System.out.println("--------------------------");
            System.out.printf("| %-10s | %-9s |\n", "Word", "Frequency");
            System.out.println("--------------------------");
            for (BST BST : nodesInAlphabetical) {
                System.out.printf("| %-10s | %-9s |\n", BST.word, BST.count);
            }
            System.out.println("--------------------------");
        } else if (order == 1) {
            System.out.println("\n    In Increasing Order");
            System.out.println("--------------------------");
            System.out.printf("| %-10s | %-9s |\n", "Word", "Frequency");
            System.out.println("--------------------------");
            for (int i = nodesInAlphabetical.size() - 1; i >= 0; i--) {
                BST BST = nodesInAlphabetical.get(i);
                System.out.printf("| %-10s | %-9s |\n", BST.word, BST.count);
            }
            System.out.println("--------------------------");

        } else {
            System.out.println("Invalid order");
        }
    }
}
