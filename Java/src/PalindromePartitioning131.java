import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning131 {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        if (s.length()==0){
            List<String> add = new ArrayList<>();
            ret.add(add);
            return ret;
        }
        if (s.length()==1){
            List<String> add = new ArrayList<>();
            add.add(s);
            ret.add(add);
            return ret;
        }
        // i to n-1 index of s is a palindrome, 0 to i-1 index create a list
        for (int i=0;i<s.length();i++){
            if (isPalindrome(s.substring(i))){
                for (List<String> l:partition(s.substring(0,i))){
                    l.add(s.substring(i));
                    ret.add(l);
                }
            }
        }
        return ret;
    }
    public boolean isPalindrome(String s){
        if (s.length()==0 || s.length() == 1) return true;
        return (s.charAt(0) == s.charAt(s.length()-1)) && isPalindrome(s.substring(1,s.length()-1));
    }
    public static void main(String[] args){
        PalindromePartitioning131 test = new PalindromePartitioning131();
        System.out.println(test.partition("aab"));
    }
}
