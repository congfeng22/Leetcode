import java.util.HashSet;

public class HappyNumber202 {
    HashSet<Integer> nums = new HashSet<>();
    public boolean isHappy(int n) {
        nums.add(n);
        int sumsq = 0;
        while(n!=0){
            sumsq+=Math.pow(n%10,2);
            n/=10;
        }
        if (sumsq==1) return true;
        else if(nums.contains(sumsq)) return false;
        nums.add(sumsq);
        return isHappy(sumsq);
    }
}
