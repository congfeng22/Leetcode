import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length==0) return 0;
        Map<Integer,Integer> minmax = new HashMap<>();
        Map<Integer,Integer> maxmin = new HashMap<>();
        for (Integer n:nums){
            boolean inserted = false;
            if (minmax.containsKey(n) || maxmin.containsKey(n)) continue;
            if (minmax.containsKey(n+1)){
                int max = minmax.remove(n+1);
                minmax.put(n,max);
                maxmin.replace(max,maxmin.get(max)-1);
                inserted = true;
            }
            if (maxmin.containsKey(n-1)){
                int min = maxmin.remove(n-1);
                maxmin.put(n,min);
                minmax.replace(min,minmax.get(min)+1);
                inserted = true;
            }
            if (minmax.containsKey(n) && maxmin.containsKey(n)){
                int newmin = maxmin.get(n);
                int newmax = minmax.get(n);
                minmax.remove(n);
                maxmin.remove(n);
                minmax.replace(newmin,newmax);
                maxmin.replace(newmax,newmin);
            }
            if (!inserted){
                minmax.put(n,n);
                maxmin.put(n,n);
            }
        }
        int ret = 0;
        for (Integer i:maxmin.keySet()){
            ret = Math.max(ret,i-maxmin.get(i));
        }

        System.out.println(minmax.toString());
        System.out.println(maxmin.toString());
        return ret+1;
    }
    public static void main(String[] args){
        LongestConsecutiveSequence128 test = new LongestConsecutiveSequence128();
        int[] nums = {-6,8,-5,7,-9,-1,-7,-6,-9,-7,5,7,-1,-8,-8,-2,0};
        System.out.println(test.longestConsecutive(nums));
    }
}
