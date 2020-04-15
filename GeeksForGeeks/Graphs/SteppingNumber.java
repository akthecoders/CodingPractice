
public class SteppingNumber {
    public static void main(String[] args) {
        int n = 0, m = 21;
        displaySteppingNumbers(n,m);
    }

    public static void displaySteppingNumbers(int n, int m) {
        for(int i = 0; i < 9; i++) {
            dfs(n, m , i);
        }
     }

     public static void dfs(int n, int m, int stepNum) {
        if(stepNum <= m && stepNum >= n) {
            System.out.print(stepNum + " ");
        }

        if (stepNum == 0 || stepNum > m) 
            return ; 

        int lastDigit = stepNum % 10;

        int stepNumA = stepNum*10 + (lastDigit-1); 
        int stepNumB = stepNum*10 + (lastDigit+1); 

        if(lastDigit == 0) {
            dfs(n, m, stepNumB);
        }
        else if(lastDigit == 9) {
            dfs(n, m, stepNumA);
        }
        else {
            dfs(n, m, stepNumA); 
            dfs(n, m, stepNumB); 
        }
     }
}