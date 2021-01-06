public class DungeonGame174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        if (row==1 && col==1) return dungeon[0][0]>0?1:1-dungeon[0][0];
        dungeon[row-1][col-1]=1-dungeon[row-1][col-1];
        if (dungeon[row-1][col-1]<=0) dungeon[row-1][col-1]=1;
        for (int i=col-2;i>=0;i--){
            dungeon[row-1][i]=dungeon[row-1][i+1]-dungeon[row-1][i];
            if (dungeon[row-1][i]<=0) dungeon[row-1][i]=1;
        }
        for (int i=row-2;i>=0;i--){
            dungeon[i][col-1]=dungeon[i+1][col-1]-dungeon[i][col-1];
            if (dungeon[i][col-1]<=0) dungeon[i][col-1]=1;
        }
        for (int i=row-2;i>=0;i--){
            for (int j=col-2;j>=0;j--){
                dungeon[i][j]=Math.min(dungeon[i+1][j],dungeon[i][j+1])-dungeon[i][j];
                if (dungeon[i][j]<=0) dungeon[i][j]=1;
            }
        }
        return dungeon[0][0];
    }
}
