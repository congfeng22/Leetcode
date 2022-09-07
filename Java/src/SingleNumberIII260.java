import java.util.HashSet;

public class SingleNumberIII260 {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums){
            if (set.contains(n)) set.remove(n);
            else set.add(n);
        }
        return set.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
