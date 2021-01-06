public class TwoSumII167 {
    public int[] twoSum(int[] numbers, int target) {
        int l=0; int r = numbers.length-1;
        while (numbers[l]+numbers[r]!=target){
            if (numbers[l]+numbers[r]>target) r--;
            else l++;
        }
        return new int[]{l+1,r+1};
    }

    public static void main(String[] args){
        TwoSumII167 test = new TwoSumII167();
    }
}
