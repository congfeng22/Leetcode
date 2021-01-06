import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[i] = 1 if first i+1-th letters is true
        boolean[] dp = new boolean[s.length()];
        HashSet<String> set = new HashSet<>(wordDict);
        dp[0]=set.contains(s.substring(0,1));
        List<Integer> trues = new ArrayList<>();
        if (dp[0]) trues.add(0);
        for (int i=1;i<dp.length;i++){
            if (set.contains(s.substring(0,i+1))){
                dp[i]=true;
                trues.add(i);
            }
            else{
                for (int idx : trues){
                    if (set.contains(s.substring(idx+1,i+1))) {
                        dp[i]=true;
                        trues.add(i);
                        break;
                    }
                }
            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[dp.length-1];
    }
    public static void main(String[] args){
        WordBreak139 test = new WordBreak139();
        List<String> worddict = new ArrayList<>();
        worddict.add("apple");
        worddict.add("pen");
        System.out.println(test.wordBreak("applepenapple",worddict));
    }
}
