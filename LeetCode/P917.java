// Reverse Only Letters
public class P917 {
    public String reverseOnlyLetters(String S) {
        char arr[] = S.toCharArray();
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            if (!Character.isLetter(arr[start])) {
                start++;
            }

            if (start < end && !Character.isLetter(arr[end])) {
                end--;
            }
            if (start < end && Character.isLetter(arr[start]) && Character.isLetter(arr[end])) {
                Character t = arr[start];
                arr[start] = arr[end];
                arr[end] = t;
                start++;
                end--;
            }
        }
        return new String(arr);
    }
}