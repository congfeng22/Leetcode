public class RangeSumQueryImmutable303 {
    class NumArray {
        public int[] num;
        public NumArray(int[] nums) {
            num = new int[nums.length+1];
            for (int i=0;i<nums.length;i++){
                num[i+1]=num[i]+nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return num[j+1]-num[i];
        }
    }
}
