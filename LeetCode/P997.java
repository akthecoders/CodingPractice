
public class P997 {
    public static void main(String[] args) {
        int N = 4;
        int[][] trust = {{1,3},{1,4},{2,3},{2,4},{4,3}}; 
        
        System.out.println(findJudge(N, trust));
    }

    public static int findJudge(int N, int[][] trust) {
        int freq[] = new int[N];
        for(int i = 0; i < trust.length; i++) {
            freq[trust[i][0] - 1]++;
            freq[trust[i][1] - 1]--;
        }
        
        for(int i = 0; i < N; i++) {
           if(freq[i] < 0 && Math.abs(freq[i]) == N - 1) {
                return i + 1;
            }
        }
        return -1;
    }
}