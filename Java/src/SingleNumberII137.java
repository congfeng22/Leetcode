import java.util.HashMap;

public class SingleNumberII137 {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num,map.containsKey(num)?map.get(num)+1:1);
        }
        for (int key : map.keySet()){
            if (map.get(key)==1) return key;
        }
        return -1;
    }
}
