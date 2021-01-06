import java.util.HashMap;

public class IsomorphicStrings205 {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        int idx = 0;
        int[] s1 = new int[s.length()];
        char c;
        for (int i=0;i<s.length();i++){
            c = s.charAt(i);
            if (!map1.containsKey(c)){
                idx++;
                map1.put(c,idx);
            }
            s1[i] = map1.get(c);
        }
        idx=0;
        for (int i=0;i<t.length();i++){
            c = t.charAt(i);
            if (!map2.containsKey(c)){
                idx++;
                map2.put(c,idx);
            }
            if (s1[i]!=map2.get(c)) return false;
        }
        return true;
    }
}
