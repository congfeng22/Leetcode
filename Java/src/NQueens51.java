import java.util.ArrayList;
import java.util.List;

public class NQueens51 {
    List<List<String>> ret = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[][] grid = new int[n][n];
        fillQueens(grid,0);
        return ret;
    }
    public boolean fillQueens(int[][] grid, int placed){
        int n = grid.length;
        if (placed>=n) {
            ret.add(convert(grid));
            return true;
        }
        boolean valid = false;
        for (int i=0;i<n;i++) {
            if (isValid(grid, placed, i)) {
                grid[placed][i] = 1;
                valid = fillQueens(grid, placed + 1) || valid;
                grid[placed][i] = 0;
            }
        }
        return valid;
    }
    public List<String> convert(int[][] grid){
        List<String> ret = new ArrayList<>();
        for (int[] row:grid){
            StringBuilder sb = new StringBuilder();
            for (int i:row){
                if (i==1) sb.append("Q");
                else sb.append(".");
            }
            ret.add(sb.toString());
        }
        return ret;
    }
    public boolean isValid(int[][] grid, int r, int c){
        int n = grid.length;
        for (int i=0;i<r;i++){
            if (grid[i][c]==1) return false;
        }
        for (int i=0;i<Math.min(r,c);i++){
            if (grid[r-i-1][c-i-1]==1) return false;
        }
        for (int i=0;i<Math.min(r,n-1-c);i++){
            if (grid[r-i-1][c+i+1]==1) return false;
        }
        return true;
    }
}
