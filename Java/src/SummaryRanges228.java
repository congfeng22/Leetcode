import java.util.ArrayList;
import java.util.List;

public class SummaryRanges228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for (int i=0;i<nums.length;i++){
            if (i == nums.length-1){
                s.append(nums[i]);
                ret.add(s.toString());
            } else{
                if (s.length()==0){
                    s.append(nums[i]);
                    if (nums[i+1]==nums[i]+1) s.append("->");
                    else {
                        ret.add(s.toString());
                        s.setLength(0);
                    }
                }
                else if (nums[i+1]!=nums[i]+1) {
                    s.append(nums[i]);
                    ret.add(s.toString());
                    s.setLength(0);
                }
            }
        }
        return ret;
    }
}
