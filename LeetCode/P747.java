//Largest Number At Least Twice of Others
public class P747 {
    public int dominantIndex(int[] nums) {
        int largest = 0;
        int secondlargest = 0;
        int lI = 0;
        int index = 0;
        for (int x : nums) {
            if (largest < x) {
                secondlargest = largest;
                largest = x;
                lI = index;
            } else if (secondlargest < x && x != largest) {
                secondlargest = x;
            }
            index++;
        }

        return (secondlargest * 2) <= largest ? lI : -1;
    }
}