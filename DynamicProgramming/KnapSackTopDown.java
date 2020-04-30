// KnapSack Bottom Down
public class KnapSackTopDown {
    public static void main(String[] args) {
        int value[] = {1, 4, 6, 3};
        int weight[] = {2, 2, 8, 5};
        int cap = 7;
        int memory[][] = new int[value.length + 1][cap + 1];
        for(int i = 0; i < value.length + 1; i++) {
            memory[0][i] = 0;
            memory[i][0] = 0;
        }

        for(int i = 1; i < value.length + 1; i++) {
            for(int j= 1; j < cap + 1; j++) {
                if(weight[i - 1] < j ) {
                    memory[i][j] = Math.max(value[i-1] + memory[i-1][j - weight[i-1]], memory[i-1][j]);
                }
                else {
                    memory[i][j] = memory[i -  1][j];
                }
            }
        }
        
        System.out.println(memory[value.length][cap]);
    }
}