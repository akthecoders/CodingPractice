//Verify Preorder Serialization of a Binary Tree
public class P331 {
    public boolean isValidSerialization(String preorder) {
        int count = 1;
        String nodes[] = preorder.split(",");
        for (String node : nodes) {
            count--;
            if (count < 0) {
                return false;
            }
            if (!node.equals("#")) {
                count += 2;
            }
        }
        return count == 0;
    }
}