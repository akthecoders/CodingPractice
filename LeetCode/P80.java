//Remove Duplicates from Sorted Array II
public class P80 {
    public int removeDuplicates(int[] nums) {
        int p = 2;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] != nums[p-2]){
                nums[p] = nums[i];
                p++;
            }
        }
        return p;
    }
}