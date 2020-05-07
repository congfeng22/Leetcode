import java.util.*;

public class SudokuSolver37 {
    public void solveSudoku(char[][] board) {
        solvable(board);
    }
    public boolean isValid(char[][] board, int r, int c){
        for (int i=0;i<9;i++){
            if (i!=r && board[i][c]==board[r][c]) return false;
        }
        for (int j=0;j<9;j++){
            if (j != c && board[r][j]==board[r][c]) return false;
        }
        for (int i=(r/3)*3;i<(r/3)*3+3;i++){
            for (int j=(c/3)*3;j<(c/3)*3+3;j++){
                if (!(i==r && j == c) && board[i][j]==board[r][c]) return false;
            }
        }
        return true;
    }
    public boolean solvable(char[][] board) {
        for (int r=0;r<9;r++){
            for (int c=0;c<9;c++){
                if (board[r][c] != '.') continue;
                boolean checkopts = false;
                for (int i=1;i<10;i++){
                    board[r][c] = (char) (i+48);
                    if (isValid(board,r,c) && solvable(board)) {
                        checkopts = true;
                        break;
                    }
                }
                if (!checkopts) {
                    board[r][c] = '.';
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        SudokuSolver37 test = new SudokuSolver37();
        char t[][] = {
                {'.','.','9','7','4','8','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'.','2','.','1','.','9','.','.','.'},
                {'.','.','7','.','.','.','2','4','.'},
                {'.','6','4','.','1','.','5','9','.'},
                {'.','9','8','.','.','.','3','.','.'},
                {'.','.','.','8','.','3','.','2','.'},
                {'.','.','.','.','.','.','.','.','6'},
                {'.','.','.','2','7','5','9','.','.'}};
        char s[][] = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        test.solveSudoku(t);
    }
}