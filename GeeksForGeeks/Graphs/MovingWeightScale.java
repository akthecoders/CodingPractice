
public class MovingWeightScale {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 6 }; 
        int N = arr.length; 
        int steps = 10; 
        printWeightOnScale(arr, N, steps); 
    }

    static void printWeightOnScale(int[] arr, int n, int steps) {
        int wt[] = new int[steps];

        if(dfs(0, 0, wt, arr, n, steps)) {
            for (int i = 0; i < steps; i++) 
                System.out.print(wt[i] + " "); 
            System.out.println(); 
        }
        else {
            System.out.println("Not Possible");
        }
    }

    public static boolean dfs(int residue, int curSteps, int[] wt, int[] arr, int N, int steps) {
        if(curSteps >= steps) {
            return true;
        }
        for(int i = 0; i  < N; i++) {
            if(curSteps - 1 < 0 || (arr[i] > residue && arr[i] != wt[curSteps - 1])) {
                wt[curSteps] = arr[i];
                if(dfs(arr[i] - residue, curSteps + 1, wt, arr, N, steps)) {
                    return true;
                }
            }
        }
        return false;
    }
}