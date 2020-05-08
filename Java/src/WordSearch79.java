public class WordSearch79 {
    public boolean exist2(char[][] board, String word, int index){
        if (index == word.length()) return true;
        for (int r=0;r<board.length;r++){
            for (int c=0;c<board[0].length;c++){
                if (index==0 && board[r][c] == word.charAt(0)){
                    char temp = board[r][c];
                    board[r][c] = '*';
                    if (exist2(board,word,index+1)) return true;
                    board[r][c] = temp;
                }
                else if (board[r][c] == '*'){
                    boolean ret = false;
                    if (r!=0 && board[r-1][c]==word.charAt(index)){
                        char temp = board[r-1][c];
                        board[r][c] = '.';
                        board[r-1][c] = '*';
                        ret = ret || exist2(board,word,index+1);
                        board[r][c] = '*';
                        board[r-1][c] = temp;
                        if (ret) return ret;
                    }
                    if (c!=0 && board[r][c-1]==word.charAt(index)){
                        char temp = board[r][c-1];
                        board[r][c] = '.';
                        board[r][c-1] = '*';
                        ret = ret || exist2(board,word,index+1);
                        board[r][c] = '*';
                        board[r][c-1] = temp;
                        if (ret) return ret;
                    }
                    if (r!=board.length-1 && board[r+1][c]==word.charAt(index)){
                        char temp = board[r+1][c];
                        board[r][c] = '.';
                        board[r+1][c] = '*';
                        ret = ret || exist2(board,word,index+1);
                        board[r][c] = '*';
                        board[r+1][c] = temp;
                        if (ret) return ret;
                    }
                    if (c!=board[0].length-1 && board[r][c+1]==word.charAt(index)){
                        char temp = board[r][c+1];
                        board[r][c] = '.';
                        board[r][c+1] = '*';
                        ret = ret || exist2(board,word,index+1);
                        board[r][c] = '*';
                        board[r][c+1] = temp;
                        if (ret) return ret;
                    }
                }
            }
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        return exist2(board,word,0);
    }
    public static void main(String[] args){
        WordSearch79 test = new WordSearch79();
        char board[][] = {
                {'C','C','C'},
                {'A','A','A'},
                {'B','C','D'}
        };
        String word = "CCAC";
        System.out.println(test.exist(board,word));
    }
}