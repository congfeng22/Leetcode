public class GameOfLife289 {
    public void gameOfLife(int[][] board) {
        int[][] copy = new int[board.length][board[0].length];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                copy[i][j]=board[i][j];
            }
        }
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                int liveneighbor = numLiveNeighbor(copy,i,j);
                System.out.println(liveneighbor);
                if (copy[i][j]==1 && (liveneighbor<2 || liveneighbor>3)) board[i][j]=0;
                else if (copy[i][j]==0 && liveneighbor==3) board[i][j]=1;
            }
        }
    }
    public int numLiveNeighbor(int[][] board, int r, int c){
        int ret = 0;
        if (r>0){
            if (c>0 && board[r-1][c-1]==1) ret++;
            if (c<board[0].length-1 && board[r-1][c+1]==1) ret++;
            if (board[r-1][c]==1) ret++;
        }
        if (r<board.length-1){
            if (c>0 && board[r+1][c-1]==1) ret++;
            if (c<board[0].length-1 && board[r+1][c+1]==1) ret++;
            if (board[r+1][c]==1) ret++;
        }
        if (c>0 && board[r][c-1]==1) ret++;
        if (c<board[0].length-1 && board[r][c+1]==1) ret++;
        return ret;
    }
    public static void main(String[] args){
        GameOfLife289 test = new GameOfLife289();
        int[][] board = new int[][]{
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        test.gameOfLife(board);
    }
}
