public class FiveStarSeller {
    public static void main(String[] args) {
        int [][] ratings = {{4,4}, {1,2}, {3, 6}};
        System.out.println(fiveStar(ratings, 77));
    }
    public static int fiveStar(int[][] ratings, int target) {
        int n = ratings.length;
        double threshold = n * target / 100.0;
        double percent = 0.00;
        for(int i = 0; i < n; i++) {
            double a = ratings[i][0];
            double b = ratings[i][1];
            double rate = a / b;
            percent += rate;
        }

        int maxIndex = 0, res = 0;
        double diff;
        double maxDiff = Double.MIN_VALUE;

        while(percent < threshold) {

            for(int i = 0; i < n; i++) {
                double a = ratings[i][0];
                double b = ratings[i][1];
                double rate = a / b;
                if(rate == 1) continue;

                double x = a + 1;
                double y = b + 1;
                double updated = x / y;

                diff = updated - rate;
                if(diff > maxDiff) {
                    maxDiff = diff;
                    maxIndex = i;
                }

            }
            percent += maxDiff;
            maxDiff = Double.MIN_VALUE;
            ratings[maxIndex][0]++;
            ratings[maxIndex][1]++;
            res++;
        }
        return  res;
    }
}
