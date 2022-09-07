public class RangeSumQuery2DImmutable304 {
    class NumMatrix {
        int[][] mat;
        public NumMatrix(int[][] matrix) {
            if (matrix.length!=0){
                mat = new int[matrix.length+1][matrix[0].length+1];
                for (int i=1;i<matrix.length+1;i++){
                    for (int j=1;j<matrix[0].length+1;j++){
                        mat[i][j]=mat[i-1][j]+mat[i][j-1]-mat[i-1][j-1]+matrix[i-1][j-1];
                    }
                }
            }

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return mat[row2+1][col2+1]-mat[row2+1][col1]-mat[row1][col2+1]+mat[row1][col1];
        }
    }
}
