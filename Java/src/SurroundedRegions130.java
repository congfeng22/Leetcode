import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SurroundedRegions130 {
    Set<Long> s = new HashSet<>();
    public void solve(char[][] board) {
        if (board.length==0 || board[0].length==0) return;
        // put all uncontained 0's in s
        for (int c=0;c<board[0].length;c++){
            if (board[0][c]=='O' && !s.contains((long) c)) put(board,0,c);
            if (board[board.length-1][c]=='O' && !s.contains((long) (board.length-1)*(board[0].length)+c)) put(board,board.length-1,c);
        }
        for (int r=0;r<board.length;r++){
            if (board[r][0]=='O' && !s.contains((long) r*(board[0].length))) put(board,r,0);
            if (board[r][board[0].length-1]=='O' && !s.contains((long) r*(board[0].length)+board[0].length-1)) put(board,r,board[0].length-1);
        }
        // turn all contained O's to X's
        for (int r=1;r<board.length-1;r++){
            for (int c=1;c<board[0].length-1;c++){
                if (board[r][c]=='O' && !s.contains((long) r*board[0].length+c)){
                    turn(board,r,c);
                }
            }
        }
        System.out.println(s.toString());
    }
    // check if board[r][c] is contained
    public boolean contained(char[][] board, int r, int c){
        if (r==0 || r==board.length-1 || c==0 || c==board[0].length-1){
            return board[r][c] != 'O';
        }
        if (board[r][c]=='X') return true;
        else{
            board[r][c]='d';
            boolean contain = true;
            if (board[r-1][c]!='d') {
                contain = contained(board, r - 1, c);
            }
            if (board[r+1][c]!='d') {
                contain = contain && contained(board, r + 1, c);
            }
            if (board[r][c-1]!='d') {
                contain = contain && contained(board, r, c-1);
            }
            if (board[r][c+1]!='d') {
                contain = contain && contained(board, r, c+1);
            }
            board[r][c]='O';
            return contain;
        }
    }
    // turn all connected O's to X's.
    public void turn(char[][] board, int r, int c){
        if (board[r][c]=='X') return;
        board[r][c]='X';
        turn(board,r-1,c);
        turn(board,r+1,c);
        turn(board,r,c-1);
        turn(board,r,c+1);
    }
    // put all connected O's into a set. board[r][c] is a O that is not contained
    public void put(char[][] board, int r, int c){
        if (r<0 || r>board.length-1 || c<0 || c>board[0].length-1) return;
        if (board[r][c]=='X') return;
        if (s.contains((long) r*board[0].length+c)) return;
        s.add((long) (r*board[0].length+c));
        put(board,r-1,c);
        put(board,r+1,c);
        put(board,r,c-1);
        put(board,r,c+1);
    }
    public static void main(String[] args){
        SurroundedRegions130 test = new SurroundedRegions130();
        char[][] board = {
                {'O','X','X','O','X'},
                {'X','O','O','X','O'},
                {'X','O','X','O','O'},
                {'O','X','O','X','O'},
                {'O','O','O','O','O'}
        };
        test.solve(board);
        for (char[] row:board) System.out.println(Arrays.toString(row));
    }
}
