import java.util.HashMap;

public class ScrambleString87 {
    HashMap<Integer, Boolean> map = new HashMap<>();
    int n;
    public boolean isScramble(String s1, String s2) {
        char[] c1 = s1.toCharArray(); char[] c2 = s2.toCharArray();
        n = c1.length;
        return isScramble(c1,0,c1.length-1,c2,0);
    }
    public boolean isScramble(char[] s1, int a, int b, char[] s2, int c) {
        if (a == b) return s1[a]==s2[c];
        for (int i=0;i<b-a;i++){
            int key = a*n*n+(a+i)*n+c;
            if (!map.containsKey(key)) map.put(key,isScramble(s1,a,a+i,s2,c));
            if (map.get(key)) {
                key = (a + i + 1)*n*n + b*n + c + i + 1;
                if (!map.containsKey(key)) map.put(key, isScramble(s1, a + i + 1, b, s2, c + i + 1));
                if (map.get(key)) return true;
            }
            key = a*n*n+(a+i)*n+c+b-a-i;
            if (!map.containsKey(key)) map.put(key,isScramble(s1,a,a+i,s2,c+b-a-i));
            if (map.get(key)) {
                key = (a + i + 1)*n*n+b*n+ c;
                if (!map.containsKey(key)) map.put(key, isScramble(s1, a + i + 1, b, s2, c));
                if (map.get(key)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        ScrambleString87 test = new ScrambleString87();
        String s1 = "great";
        String s2 = "rgeat";
        System.out.println(test.isScramble(s1,s2));
    }
}
