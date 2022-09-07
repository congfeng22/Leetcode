public class ProductOfArrayExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        ret[0]=1;
        for (int i=1;i<nums.length;i++){
            ret[i]=ret[i-1]*nums[i-1];
        }
        int temp = nums[nums.length-1];
        nums[nums.length-1]=1;
        for (int i=nums.length-2;i>=0;i--){
            int temp2 = nums[i];
            nums[i]=nums[i+1]*temp;
            temp=temp2;
        }
        for (int i=0;i<nums.length;i++){
            ret[i]*=nums[i];
        }
        return ret;
    }
}
