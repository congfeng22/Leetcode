public class SearchA2DMatrixII240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r=0; int c=matrix[0].length-1;
        while (r>=0 && r<matrix.length && c>=0 && c<matrix[0].length){
            if (matrix[r][c]<target) r++;
            else if (matrix[r][c]>target )c--;
            else return true;
        }
        return false;
    }
    public static void main(String[] args){
        SearchA2DMatrixII240 test = new SearchA2DMatrixII240();
        int[][] matrix = new int[][]{
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
        System.out.println(test.searchMatrix(matrix,5));
    }
}
