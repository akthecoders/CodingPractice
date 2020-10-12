import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
// Revised
// Word Search II
public class P212 {
    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        String word = null;

        public TrieNode() {
        }
    }

    char[][] board = null;
    ArrayList<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;

            for (Character letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }
        this.board = board;

        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[0].length; ++col) {
                if (root.children.containsKey(board[row][col])) {
                    backtracking(row, col, root);
                }
            }
        }
        return this.result;
    }

    public void backtracking(int row, int col, TrieNode root) {
        Character letter = this.board[row][col];
        TrieNode currNode = root.children.get(letter);

        if (currNode.word != null) {
            this.result.add(currNode.word);
            currNode.word = null;
        }
        this.board[row][col] = '#';
        int[] rowOffset = { -1, 0, 1, 0 };
        int[] colOffset = { 0, 1, 0, -1 };
        for (int i = 0; i < 4; ++i) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0 || newRow >= this.board.length || newCol < 0 || newCol >= this.board[0].length) {
                continue;
            }
            if (currNode.children.containsKey(this.board[newRow][newCol])) {
                backtracking(newRow, newCol, currNode);
            }
        }
        this.board[row][col] = letter;
        if (currNode.children.isEmpty()) {
            root.children.remove(letter);
        }
    }
}