import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElementII229 {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for (int i : nums){
            freq.put(i,freq.containsKey(i)?freq.get(i)+1:1);
        }
        List<Integer> ret = new ArrayList<>();
        for (int k : freq.keySet()){
            if (freq.get(k)>nums.length/3) ret.add(k);
        }
        return ret;
    }
}
