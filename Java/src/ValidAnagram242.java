public class ValidAnagram242 {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) return false;
        int[] freq = new int[26];
        for (int i=0;i<s.length();i++){
            freq[s.charAt(i)-97]+=1;
            freq[t.charAt(i)-97]-=1;
        }
        for (int i=0;i<26;i++){
            if (freq[i]!=0) return false;
        }
        return true;
    }
}
