import java.util.PriorityQueue;

public class RangeSumQueryMutable307 {
    class NumArray {
        public int[] num;
        public NumArray(int[] nums) {
            num = new int[nums.length+1];
            for (int i=0;i<nums.length;i++){
                num[i+1]=num[i]+nums[i];
            }
        }

        public void update(int i, int val) {
            int diff = val-(num[i+1]-num[i]);
            for (int j=i+1;j<num.length;j++){
                num[j]+=diff;
            }
        }

        public int sumRange(int i, int j) {
            return num[j+1]-num[i];
        }
    }
}
