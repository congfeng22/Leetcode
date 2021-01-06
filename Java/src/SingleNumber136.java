public class SingleNumber136 {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int num : nums) ret = ret ^ num;
        return ret;
    }
    public static void main(String[] args){
        SingleNumber136 test = new SingleNumber136();
        System.out.println(test.singleNumber(new int[]{4,1,2,1,2}));
    }
}
