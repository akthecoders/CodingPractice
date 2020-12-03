import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShoppingPattern {
    public static void main(String[] args) {
        int numOfProducts = 6;
		List<Integer> products_from = new ArrayList<Integer>();
		List<Integer> products_to = new ArrayList<Integer>();

        products_from.add(1);
        products_from.add(2);
        products_from.add(2);
        products_from.add(3);
        products_from.add(4);
        products_from.add(5);
        
        products_to.add(2);
        products_to.add(4);
        products_to.add(5);
        products_to.add(5);
        products_to.add(5);
        products_to.add(6);
        
        System.out.println("Hello "  + getShoppingPatternsTrioMinimum(numOfProducts, products_from, products_to));
    }

    private static int getShoppingPatternsTrioMinimum(int numOfProducts,List<Integer> products_from, List<Integer> products_to) {
        int result = 0;
        Map<Integer, Set<Integer>> graph = buildGraph(numOfProducts, products_from, products_to);

        for(int i = 0; i < numOfProducts; i++) {
            for(int j = i + 1; j < numOfProducts; j++) {
                for(int k = j + 1; k < numOfProducts; k++) {
                    if(graph.get(i).contains(j) && graph.get(j).contains(k) && graph.get(k).contains(i)) {
                        int val = graph.get(i).size() + graph.get(j).size() + graph.get(k).size();
                        val = val - 6;
                        result = Math.min(result, val);
                    }
                }
            }
        }
        return result;
    }

    private static Map<Integer, Set<Integer>> buildGraph(int numOfProducts,List<Integer> products_from, List<Integer> products_to) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        
       for(int i = 0; i < numOfProducts; i++) {
           graph.put(i, new HashSet<>());
       }

       for(int i = 0; i < numOfProducts; i++) {
           graph.get(products_from.get(i)).add(products_to.get(i));
           graph.get(products_to.get(i)).add(products_from.get(i));
       }        
       return graph;
    }
}
