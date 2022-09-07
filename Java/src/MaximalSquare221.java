import java.util.Arrays;

public class MaximalSquare221 {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length; int cols = matrix[0].length; int ret = 0; int sqlen;
        int[] dprow = new int[cols];
        for (int i=0;i<cols;i++){
            if (matrix[0][i]=='1'){
                dprow[i]=1;
                ret = 1;
            }
        }
        int topleft;
        for (int i=1;i<rows;i++){
            topleft = dprow[0];
            if (matrix[i][0]=='1'){
                dprow[0]=1;
                ret = Math.max(1,ret);
            }
            else dprow[0]=0;
            for (int j=1;j<cols;j++){
                int temp = dprow[j];
                if (matrix[i][j]=='1'){
                    dprow[j] = Math.min(dprow[j-1],Math.min(dprow[j],topleft))+1;
                    ret = Math.max(dprow[j],ret);
                }
                else {
                    dprow[j] = 0;
                }
                topleft = temp;
            }
        }
        return ret*ret;
    }
    public static void main(String[] args){
        MaximalSquare221 test = new MaximalSquare221();
        char[][] arr = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(test.maximalSquare(arr));
    }
}
