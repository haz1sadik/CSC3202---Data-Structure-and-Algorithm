package Assignment4;

import java.util.List;
class BST {
    String word;
    int count;
    BST left, right;

    public BST(String word) {
        this.word = word;
        this.count = 1;
    }

    private BST root;

    public void addWord(String word) {
        root = addWordRecursive(root, word);
    }

    private BST addWordRecursive(BST BST, String word) {
        if (BST == null) {
            return new BST(word);
        }

        int comparison = word.compareTo(BST.word);

        if (comparison < 0) {
            BST.left = addWordRecursive(BST.left, word);
        } else if (comparison > 0) {
            BST.right = addWordRecursive(BST.right, word);
        } else {
            BST.count++;
        }

        return BST;
    }

    public void getWordsAlphabetical(List<BST> BSTS) {
        inorderTraverse(root, BSTS);
    }

    private void inorderTraverse(BST BST, List<BST> BSTS) {
        if (BST != null) {
            inorderTraverse(BST.left, BSTS);
            BSTS.add(BST);
            inorderTraverse(BST.right, BSTS);
        }
    }
}

