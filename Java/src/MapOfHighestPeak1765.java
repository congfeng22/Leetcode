import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Queue;

public class MapOfHighestPeak1765 {
    int[][] ret;
    public boolean inbounds(int r, int c) {
        if ((r>=0) && (r<ret.length) && (c>=0) && (c<ret[0].length)) {
            return true;
        } 
        return false;
    }
    public void fill(int[][] isWater, int i, int j) {
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        Queue<List<Integer>> queue = new LinkedList<>();
        Set<List<Integer>> visited = new HashSet<>();
        queue.add(Arrays.asList(i,j));
        while (queue.size()>0) {
            List<Integer> coords = queue.remove();
            visited.add(coords);
            for (int k=0;k<4;k++){
                List<Integer> newcoords = Arrays.asList(coords.get(0)+dx[k], coords.get(1)+dy[k]);
                int r = newcoords.get(0);
                int c = newcoords.get(1);
                // System.out.println(newcoords);
                if (inbounds(r,c) && isWater[r][c] == 0 && !visited.contains(newcoords)) {
                    ret[r][c] = Math.min(ret[r][c], 1 + ret[coords.get(0)][coords.get(1)]);
                    queue.add(newcoords);

                    // System.out.println("PRINTING");

                    // for (int l=0;l<ret.length;l++){
                    //     System.out.println(Arrays.toString(ret[l]));
                    // }
                    // System.out.println("STOP PRINTING");
                }
            }
        }
        return;
    }
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        ret = new int[m][n];
        // initialize ret
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (isWater[i][j] == 0){
                    ret[i][j]=m+n-2;
                }
            }
        }
        // iterate over the waters
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (isWater[i][j] == 0){
                    continue;
                }
                fill(isWater, i,j);
            }
        }
        return ret;
    }
    public static void main(String[] args){
        MapOfHighestPeak1765 test = new MapOfHighestPeak1765();
        int t[][] = {
            {0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0},
            {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,1,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0}};

        int r[][] = test.highestPeak(t);
        for (int i=0;i<r.length;i++){
            System.out.println(Arrays.toString(r[i]));
        }
    }
}