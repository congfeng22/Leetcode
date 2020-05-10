import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses93 {
    List<String> ret = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        return helper(s,4);
    }
    public List<String> helper(String s, int n){
        if (s.equals("")) return new ArrayList<>();
        if (n==1){
            if (s.length()<4 && Integer.parseInt(s)<256 && !(s.length()!=1 && s.charAt(0)=='0')){
                List<String> add = new ArrayList<>();
                add.add(s);
                return add;
            } else return new ArrayList<>();
        }
        List<String> add2 = new ArrayList<>();
        String first = s.substring(0,1);
        for (String i: helper(s.substring(1),n-1)){
            add2.add(first+"."+i);
        }
        if (s.charAt(0)=='0') return add2;
        if (s.length()==1) return add2;
        first = s.substring(0,2);
        for (String i: helper(s.substring(2),n-1)){
            add2.add(first+"."+i);
        }
        if (s.length()==2) return add2;
        first = s.substring(0,3);
        if (Integer.parseInt(first)<256) {
            for (String i: helper(s.substring(3),n-1)){
                add2.add(first+"."+i);
            }
        }
        return add2;
    }
    public static void main(String[] args){
        RestoreIPAddresses93 test = new RestoreIPAddresses93();
        String input = "9245587303";
        System.out.println(test.helper(input,1).toString());
    }
}
