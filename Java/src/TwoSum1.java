import java.util.Arrays;
import java.util.HashMap;

public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }
            map.put(target-nums[i],i);
        }
        return null;
    }
    public static void main(String[] args){
        TwoSum1 test = new TwoSum1();
        int[] a = {2,7,11,15};
        System.out.println(Arrays.toString(test.twoSum(a,9)));
    }
}
