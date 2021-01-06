import java.util.*;

public class RepeatedDNASequences187 {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length()<10) return new ArrayList<String>();
        HashSet<String> exist = new HashSet<>();
        HashSet<String> retset = new HashSet<>();
        String ss;
        for (int i=0;i<s.length()-9;i++){
            ss = s.substring(i,i+10);
            if (!exist.contains(ss)) exist.add(ss);
            else retset.add(ss);
        }
        return new ArrayList<String>(retset);
    }
    public static void main(String[] args){
        RepeatedDNASequences187 test = new RepeatedDNASequences187();
        test.findRepeatedDnaSequences("AAAAAAAAAAAAAA");
    }

}
