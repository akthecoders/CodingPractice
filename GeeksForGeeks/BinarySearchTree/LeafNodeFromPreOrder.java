import java.util.Stack;

/**
 * LeafNodeFromPreOrder
 */
public class LeafNodeFromPreOrder {

    public static void main(String[] args) {
        int preorder[] = { 890, 325, 290, 530, 965 };
        int n = preorder.length;

        leafNode(preorder, n);
    }

    public static void leafNode(int [] pre, int n) {
        int i = 0, j = 0;
        Stack<Integer> st= new Stack<>();
        for(i = 0, j = 1; j < n; i++, j++) {
            boolean found = false;
            if(pre[i] > pre[j]) {
                st.push(pre[i]);
            }
            else {
                while(!st.isEmpty())
                if(pre[j] > st.peek()) {
                    st.pop();
                    found = true;
                }
                else {
                    break;
                }
            }
            if(found) {
                System.out.print(pre[i] + " ");
            }
        }

        System.out.println(pre[n-1]);
    }
}