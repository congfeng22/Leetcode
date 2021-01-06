import java.util.Arrays;

public class MaximumGap164 {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int maxgap = 0;
        for (int i=1;i<nums.length;i++){
            maxgap = Math.max(maxgap,nums[i]-nums[i-1]);
        }
        return maxgap;
    }
    public static void main(String[] args){
        MaximumGap164 test = new MaximumGap164();
        System.out.println(test.maximumGap(new int[]{3,9,6}));
    }
}
