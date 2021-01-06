import java.util.Arrays;

public class RotateArray189 {
    public void rotate(int[] nums, int k) {
        int[] ret = Arrays.copyOf(nums,nums.length);
        for (int i=0;i<nums.length;i++){
            nums[(i+k)%(nums.length)] = ret[i];
        }
    }
}
