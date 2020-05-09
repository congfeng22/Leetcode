import java.util.ArrayList;
import java.util.List;

public class GrayCode89 {
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        if (n==0){
            ret.add(0);
            return ret;
        }
        ret.addAll(grayCode(n-1));
        for (int i=ret.size()-1;i>=0;i--){
            ret.add( ret.get(i)+(int)Math.pow(2,n-1));
        }
        return ret;
    }
}
