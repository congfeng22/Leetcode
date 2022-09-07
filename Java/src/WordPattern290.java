import java.util.HashMap;

public class WordPattern290 {
    public boolean wordPattern(String pattern, String s) {
        String[] sentence = s.split(" ");
        if (pattern.length()!= sentence.length) return false;
        HashMap<Character,String> map = new HashMap<>();
        for (int i=0;i<pattern.length();i++){
            if (!map.containsKey(pattern.charAt(i))){
                if (map.containsValue(sentence[i])) return false;
                map.put(pattern.charAt(i),sentence[i]);
            }
            else if (!map.get(pattern.charAt(i)).equals(sentence[i])) return false;
        }
        return true;
    }
}
