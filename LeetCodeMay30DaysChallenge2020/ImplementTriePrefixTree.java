public class ImplementTriePrefixTree {
    class Node{
        char c;
        Node[] arr;
        boolean b;
        
        Node(char c){
            this.c = c;
            this.arr = new Node[26];
        }
    }
    
    Node root;

    /** Initialize your data structure here. */
    public ImplementTriePrefixTree() {
        this.root = new Node('\0');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for(char c : word.toCharArray()){
            Node temp = node.arr[c - 'a'];
            if(temp == null){
                temp = new Node(c);
                node.arr[c - 'a'] = temp;
            }
            node = temp;
        }
        node.b = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = root;
        for(char c : word.toCharArray()){
            Node temp = node.arr[c - 'a'];
            if(temp == null){
                return false;
            }
            node = temp;
        }
        return node.b;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = root;
        for(char c : prefix.toCharArray()){
            Node temp = node.arr[c - 'a'];
            if(temp == null){
                return false;
            }
            node = temp;
        }
        return true;
    }
}