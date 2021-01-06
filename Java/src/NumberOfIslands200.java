public class NumberOfIslands200 {
    char[][] map;
    public int numIslands(char[][] grid) {
        map = grid;
        int ret = 0;
        for (int i=0;i<map.length;i++){
            for (int j=0;j<map[0].length;j++){
                if (map[i][j]=='1'){
                    sink(i,j);
                    ret++;
                }
            }
        }

        return ret;
    }
    public void sink(int i, int j){
        if (i<0 || i>=map.length || j<0 || j>=map[0].length || map[i][j]=='0') return;
        map[i][j]='0';
        sink(i-1,j);
        sink(i+1,j);
        sink(i,j-1);
        sink(i,j+1);
    }
}
