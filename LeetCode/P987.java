import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

//Vertical Order Traversal of a Binary Tree
public class P987 {
    class Data {
        int index;
        int level;
        TreeNode node;

        public Data(int index, int level, TreeNode node) {
            this.index = index;
            this.level = level;
            this.node = node;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<Data>> map = new TreeMap<>();

        int level = 0;
        Queue<Data> queue = new LinkedList<>();
        queue.offer(new Data(0, level, root));

        while (!queue.isEmpty()) {
            level++;
            Queue<Data> tempQ = new LinkedList<>();
            for (Data data : queue) {
                int index = data.index;
                TreeNode node = data.node;

                List<Data> list = map.getOrDefault(index, new ArrayList<Data>());
                list.add(data);

                if (node.left != null) {
                    Data left = new Data(index - 1, level, node.left);
                    tempQ.offer(left);
                }

                if (node.right != null) {
                    Data right = new Data(index + 1, level, node.right);
                    tempQ.offer(right);
                }

                map.put(index, list);
            }
            queue = tempQ;
        }
        List<List<Integer>> result = new ArrayList<>();
        for (List<Data> dataList : map.values()) {
            Collections.sort(dataList, (data1, data2) -> {
                if (data1.level == data2.level)
                    return data1.node.val - data2.node.val;
                return 0;
            });

            List<Integer> list = dataList.stream().map(data -> data.node.val).collect(Collectors.toList());
            result.add(list);
        }

        return result;

    }
}