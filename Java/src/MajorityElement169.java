import java.util.HashMap;

public class MajorityElement169 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums){
            map.put(i,map.containsKey(i)?map.get(i)+1:1);
        }
        for (int i : map.keySet()){
            if (map.get(i)>nums.length/2) return i;
        }
        return -1;
    }
}
