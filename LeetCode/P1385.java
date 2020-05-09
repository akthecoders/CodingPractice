//Find the Distance Value Between Two Arrays
public class P1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        boolean isElementMetDistanceCriteria = true;
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            isElementMetDistanceCriteria = true;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    isElementMetDistanceCriteria = false;
                    break;
                }

            }

            if (isElementMetDistanceCriteria) {
                count++;
            }

        }
        return count;
    }
}