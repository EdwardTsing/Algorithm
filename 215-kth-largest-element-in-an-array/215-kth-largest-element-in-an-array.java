import java.util.Arrays;

public class Solution {

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickSelect(nums, k,  0, nums.length - 1);
    }
    
    private int quickSelect(int[] nums, int k, int l, int r) {
        int pivot = nums[r], p = l;
        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
        }
        int temp = nums[r];
        nums[r] = nums[p];
        nums[p] = temp;
        if (k < p) {
            return quickSelect(nums, k, l, p - 1);
        } else if (k > p) {
            return quickSelect(nums, k, p + 1, r);
        } else {
            return nums[k];
        }
    }
}
