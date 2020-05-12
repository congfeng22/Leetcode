import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if (numRows==0) return ret;
        List<Integer> row = new ArrayList<>();
        row.add(1);
        ret.add(row);
        for (int i=1;i<numRows;i++){
            row = new ArrayList<>();
            row.add(1);
            for (int j=0;j<ret.get(i-1).size()-1;j++){
                row.add(ret.get(i-1).get(j)+ret.get(i-1).get(j+1));
            }
            row.add(1);
            ret.add(row);
        }
        return ret;
    }
}
