import java.util.Arrays;

public class Candy135 {
    public int candy(int[] ratings) {
        int len = ratings.length;
        if (len==1) return 1;
        int[] candies = new int[len];
        if (ratings[0]<=ratings[1]) candies[0]=-2;
        if (ratings[0]>=ratings[1]) candies[0]=-1;
        if (ratings[len-1]<=ratings[len-2]) candies[len-1]=-2;
        if (ratings[len-1]>=ratings[len-2]) candies[len-1]=-1;
        for (int i=1;i<len-1;i++){
            if (ratings[i-1]>=ratings[i] && ratings[i]<=ratings[i+1]){
                candies[i]=-2;
            }
            if (ratings[i-1]<=ratings[i] && ratings[i]>=ratings[i+1]){
                candies[i]=-1;
            }
        }
        //System.out.println(Arrays.toString(candies));

        // Fill to the right
        int Ridx = 0;
        while (Ridx < len){
            if (candies[Ridx]==-2){
                while (Ridx+1<len && ratings[Ridx]<=ratings[Ridx+1] && candies[Ridx+1]!=-2) {
                    if (candies[Ridx+1]==-1){
                        if (ratings[Ridx] == ratings[Ridx + 1]) candies[Ridx + 1] = candies[Ridx]==-2?1:candies[Ridx];
                        else if (ratings[Ridx] < ratings[Ridx + 1]) candies[Ridx + 1] = candies[Ridx]==-2?2:candies[Ridx] + 1;
                        Ridx++;
                        break;
                    } else{
                        if (ratings[Ridx] == ratings[Ridx + 1]) candies[Ridx + 1] = candies[Ridx]==-2?1:candies[Ridx];
                        else if (ratings[Ridx] < ratings[Ridx + 1]) candies[Ridx + 1] = candies[Ridx]==-2?2:candies[Ridx] + 1;
                        Ridx++;
                    }
                }
            }
            Ridx++;
        }
        //System.out.println(Arrays.toString(candies));

        //Fill to the left
        int Lidx = len-1;
        while (Lidx >=0){
            if (candies[Lidx]==-2){
                while (Lidx-1>=0 && ratings[Lidx-1]>=ratings[Lidx] && candies[Lidx-1]!=-2) {
                    if (candies[Lidx-1]==-1){
                        if (ratings[Lidx-1] == ratings[Lidx]) candies[Lidx-1] = candies[Lidx]==-2?1:candies[Lidx];
                        else if (ratings[Lidx-1] > ratings[Lidx]) candies[Lidx-1] = candies[Lidx]==-2?2:candies[Lidx] + 1;
                        Lidx--;
                        break;
                    } else{
                        if (ratings[Lidx-1] == ratings[Lidx]) candies[Lidx-1] = Math.max(candies[Lidx-1],candies[Lidx]==-2?1:candies[Lidx]);
                        else if (ratings[Lidx-1] > ratings[Lidx]) candies[Lidx-1] = Math.max(candies[Lidx-1],candies[Lidx]==-2?2:candies[Lidx] + 1);
                        Lidx--;
                    }
                }
            }
            Lidx--;
        }
        int sum = 0;
        for (int i=0;i<len;i++){
            if (candies[i]==-1 || candies[i]==-2){
                candies[i]=1;
                sum++;
            }
            else sum += candies[i];
        }
        //System.out.println(Arrays.toString(candies));
        return sum;
    }
    public static void main(String[] args){
        Candy135 test = new Candy135();
        System.out.println(test.candy(new int[]{1,2,87,87,87,2,1}));
        System.out.println(test.candy(new int[]{1,0,2}));
        System.out.println(test.candy(new int[]{1,2,2}));
        System.out.println(test.candy(new int[]{1,2,4,4,3}));
        System.out.println(test.candy(new int[]{1,3,2,2,1}));
        System.out.println(test.candy(new int[]{1,3,4,5,2}));
    }
}
