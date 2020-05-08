import java.util.HashMap;

public class MinimumWindowSubstring76 {
    public String minWindow(String s, String t) {
        int l = 0; int r = 0; int minlen = s.length()+1; String minwindow = ""; int numnotin = 0; HashMap<Character,Integer> map = new HashMap<>();
        for (int i=0; i<t.length(); i++){
            if (map.containsKey(t.charAt(i))) map.put(t.charAt(i),map.get(t.charAt(i))+1);
            else {
                map.put(t.charAt(i),1);
                numnotin++;
            }
        }
        if (map.containsKey(s.charAt(0))){
            map.put(s.charAt(0),map.get(s.charAt(0))-1);
            if (map.get(s.charAt(0))==0) numnotin--;
        }
        while (true){
            // If all chars in window: update window if needed, increase l, update map
            if (numnotin == 0){
                if (r-l+1<minlen){
                    minlen = r-l+1;
                    minwindow = s.substring(l,r+1);
                }
                if (map.containsKey(s.charAt(l))){
                    map.put(s.charAt(l),map.get(s.charAt(l))+1);
                    if (map.get(s.charAt(l))==1) numnotin++;
                }
                l++;
                if (l>r) break;
            }
            // Some chars not inside window: increase r, update map
            else {
                r++;
                if (r==s.length()) break;
                if (map.containsKey(s.charAt(r))){
                    map.put(s.charAt(r),map.get(s.charAt(r))-1);
                    if (map.get(s.charAt(r))==0) numnotin--;
                }
            }
        }
        return minwindow;
    }
    public static void main(String[] args){
        MinimumWindowSubstring76 test = new MinimumWindowSubstring76();
        String s = "bacb";
        String t = "cbb";
        System.out.println(test.minWindow(s,t));
    }
}
