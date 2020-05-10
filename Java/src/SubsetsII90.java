import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubsetsII90 {
    HashMap<Integer,Integer> map = new HashMap<>();
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ret.add(new ArrayList<>());
        for (int i:nums){
            map.putIfAbsent(i,0);
            map.put(i,map.get(i)+1);
        }
        helper(map);
        return ret;
    }
    public void helper (HashMap<Integer,Integer> map){
        for (int i:map.keySet()){
            int n = ret.size();
            for (int j=1;j<=map.get(i);j++){
                for (int k=0;k<n;k++){
                    List<Integer> adding = new ArrayList<>();
                    for (int l:ret.get(k)){
                        adding.add(l);
                    }
                    for (int l=0;l<j;l++){
                        adding.add(i);
                    }
                    ret.add(adding);
                }
            }
        }
    }
    public static void main(String[] args){
        SubsetsII90 test = new SubsetsII90();
        int[] t = {1,2,2};
        List<List<Integer>> output = test.subsetsWithDup(t);
        for (List<Integer> i:output){
            System.out.println(i.toString());
        }
    }
}
