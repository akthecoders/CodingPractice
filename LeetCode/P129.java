//Sum Root to Leaf Numbers
public class P129 {
    int sum = 0;

    class Holder {
        int num;

        Holder(int n) {
            this.num = n;
        }
    }

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        Holder curr = new Holder(0);
        helper(root, curr);
        return sum;
    }

    public void helper(TreeNode root, Holder curr) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            curr.num = curr.num * 10 + root.val;
            sum += curr.num;
            curr.num = curr.num / 10;
        }

        curr.num = curr.num * 10 + root.val;
        helper(root.left, curr);
        helper(root.right, curr);
        curr.num = curr.num / 10;
    }
}