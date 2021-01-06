public class ShortestPalindrome214 {
    public String shortestPalindrome(String s) {
        for (int i=s.length();i>=0;i--){
            if (isP(s.substring(0,i))) {
                return (new StringBuilder(s.substring(i)).reverse().toString())+s;
            }
        }
        return "";
    }
    public boolean isP(String s){
        for (int i=0;i<s.length()/2;i++){
            if (s.charAt(i)!=s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }
}
