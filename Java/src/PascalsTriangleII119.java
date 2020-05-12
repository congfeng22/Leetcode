import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>();
        if (rowIndex==0){
            ret.add(1);
            return ret;
        }
        ret = getRow(rowIndex-1);
        for (int i=1;i<ret.size();i++){
            int temp = ret.get(i-1);
            ret.set(i,ret.get(i)+temp);
        }
        ret.add(1);
        return ret;
    }
}
