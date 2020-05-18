import java.util.Arrays;

//K-diff Pairs in an Array
public class P532 {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = 1, count = 0;
        while(j < nums.length){
            if( i == j){
                j++;
            }
            if(j >= nums.length) break;
            while(i < j-1 && nums[i] == nums[i+1]) i++;
            while(j < nums.length -1 && nums[j] == nums[j+1]) j++;
            int dif = Math.abs(nums[i] - nums[j]);
            if(dif == k){
                count++; i++; j++;
            }
            else if(dif < k) j++;
            else i++;
        }  
        return count;
    }  
}