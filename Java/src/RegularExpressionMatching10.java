import java.util.ArrayList;
import java.util.Arrays;

public class RegularExpressionMatching10 {
    public boolean rec(ArrayList<String> s, ArrayList<String> p){
        if (s.size()==0 ||(s.size() == 1 && "".equals(s.get(0)))){
            if (p.size()==0 || (p.size() == 1 && "".equals(p.get(0)))) return true;
            else if (p.size()>1 && p.get(p.size()-1).equals("*")){
                p.remove(p.size()-1);
                p.remove(p.size()-1);
                return rec(s,p);
            }
            else return false;
        }
        else if (p.size()==0 || (p.size() == 1 && "".equals(p.get(0)))) return false;
        if (s.get(s.size()-1).equals(p.get(p.size()-1)) || p.get(p.size()-1).equals(".")){
            s.remove(s.size()-1);
            p.remove(p.size()-1);
            return rec(s,p);
        }
        if (p.get(p.size()-1).equals("*")){
            p.remove(p.size()-1);
            String repeated = p.remove(p.size()-1);
            // Repeated == 0
            ArrayList<String> sclone =  (ArrayList<String>) s.clone();
            ArrayList<String> pclone =  (ArrayList<String>) p.clone();
            if (rec(sclone,pclone)) return true;
            // Repeated > 0, Repeated = .
            if (repeated.equals(".")){
                while (s.size()>0){
                    boolean done = false;
                    s.remove(s.size()-1);
                    ArrayList<String> sclone2 =  (ArrayList<String>) s.clone();
                    ArrayList<String> pclone2 =  (ArrayList<String>) p.clone();
                    done = done || rec(sclone2,pclone2);
                    if (done) return true;
                }
                return false;
            }
            // Repeated > 0, Repeated != .
            boolean ret = false;
            while (s.size()>0 && s.get(s.size()-1).equals(repeated)){
                s.remove(s.size()-1);
                ArrayList<String> sclone1 =  (ArrayList<String>) s.clone();
                ArrayList<String> pclone1 =  (ArrayList<String>) p.clone();
                ret = ret || rec(sclone1,pclone1);
                if (ret) return true;
            }
            return false;
        }
        return false;
    }
    public boolean isMatch(String s, String p) {
        ArrayList<String> slist = new ArrayList<>(Arrays.asList(s.split("")));
        ArrayList<String> plist = new ArrayList<>(Arrays.asList(p.split("")));
        return rec(slist,plist);
    }
    public static void main(String[] args){
        RegularExpressionMatching10 test = new RegularExpressionMatching10();
        String s = "bbacbcabbbbbcacabb";
        String p = "aa*c*b*a*.*a*a.*.";
        System.out.println(s);
        System.out.println(p);
        System.out.println(test.isMatch(s,p));
    }
}
