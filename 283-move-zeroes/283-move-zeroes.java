class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] == 0) {
                fast++;
            } else {
                 if (slow != fast) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                
            }
                slow++;
                     fast++;
            }
           
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
        
    }
}
//tc: O()