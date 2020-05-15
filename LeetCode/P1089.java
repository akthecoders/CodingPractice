//Duplicate Zeros
public class P1089 {
    public void duplicateZeros(int[] arr) {
        if (arr.length == 1)
            return;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                int end = arr.length - 1;
                while (end > i + 1) {
                    arr[end] = arr[end - 1];
                    end--;
                }
                arr[i + 1] = 0;
                i++;
            }
        }
    }
}