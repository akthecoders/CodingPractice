//Relative Sort Array
public class P1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1.length == 0 && arr2.length == 0)
            return new int[] {};
        if (arr1.length == 0)
            return arr2;
        if (arr2.length == 0)
            return arr1;
        int countMap[] = new int[1001];
        for (int x : arr1) {
            countMap[x]++;
        }

        int result[] = new int[arr1.length];
        int index = 0;
        for (int x : arr2) {
            while (countMap[x] > 0) {
                result[index++] = x;
                countMap[x]--;
            }
        }
        for (int j = 0; j < countMap.length; j++) {
            while (countMap[j] > 0) {
                result[index++] = j;
                countMap[j] -= 1;
            }
        }
        return result;
    }
}