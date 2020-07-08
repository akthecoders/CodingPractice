public class SortAnArray {
    public void sort(int[] input, int start, int end) {
        if(start >= end) { return; }
        int temp = input[end];
        sort(input, start, end - 1);
        insert(input, temp, start, end - 1);
    }

    public void insert(int[] input,  int temp, int start, int end) {
        if(end > start || input[end] <= temp) {
            input[end + 1] = temp;
        }
        int tmp = input[end];
        insert(input, tmp, start, end - 1);
    }
}