public class MoveZeroes283 {
    public void moveZeroes(int[] nums) {
        int zeroptr = 0;
        while (zeroptr<nums.length && nums[zeroptr]!=0) zeroptr++;
        for (int i=zeroptr+1;i<nums.length;i++){
            if (nums[i]!=0){
                nums[zeroptr]=nums[i];
                nums[i]=0;
                zeroptr++;
            }
        }
    }
}