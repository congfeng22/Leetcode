import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber179 {
    public String largestNumber(int[] nums) {
        Integer[] nums2 = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(nums2, (a, b) -> {
            String x = a.toString()+b.toString();
            String y = b.toString()+a.toString();
            return x.compareTo(y);
        });
        StringBuilder ret = new StringBuilder();
        if (nums2[nums2.length-1]==0) return "0";
        for (int i=nums2.length-1;i>=0;i--){
            ret.append(nums2[i]);
        }
        return ret.toString();
    }
    public static void main(String[] args){
        LargestNumber179 test = new LargestNumber179();
        int[] s = new int[]{3,30,334,33,315};
        // increasing order shld be 30 315 3 33 334
        Arrays.sort(s);
        System.out.println(Arrays.toString(s));
        System.out.println(test.largestNumber(s));
    }
}
