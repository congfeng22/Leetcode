import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathSumII113 {
        List<List<Integer>> ret = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            add(root,sum,"");
            return ret;
        }
        public void add(TreeNode root, int sum, String path){
            if (root==null) return;
            if (root.left==null && root.right==null){
                if (sum==root.val){
                    path += root.val;
                    List<Integer> adding = new ArrayList<>();
                    for (String i:path.split(" ")){
                        adding.add(Integer.parseInt(i));
                    }
                    ret.add(adding);
                    return;
                }
                else return;
            }
            path += root.val+" ";
            add(root.left,sum-root.val,path);
            add(root.right,sum-root.val,path);
        }
}
