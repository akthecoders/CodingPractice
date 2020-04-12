
/**
 * P1365
 */
public class P1365 {

    public static void main(String[] args) {
        int input[] = {8,1,2,2,3};
        int[] output = smallerNumbersThanCurrent(input);
        for (int i : output) {
            System.out.print(i + " ");
        }
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int auxArray[] = new int[100];
        int maxNum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(maxNum < nums[i]) {
                maxNum = nums[i];
            }
            auxArray[nums[i]]++;
        }
        for(int i = 1; i < maxNum + 1; i++) {
            auxArray[i] = auxArray[i] + auxArray[i-1];
        }
        int[] output = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            output[i] = auxArray[nums[i] - 1];
        }
        return output;
    }
}