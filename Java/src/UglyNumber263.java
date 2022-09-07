public class UglyNumber263 {
    public boolean isUgly(int num) {
        if (num<=0) return false;
        if (num==1) return true;
        if (num%5==0) return isUgly(num/5);
        else if (num%3==0) return isUgly(num/3);
        else if (num%2==0) return isUgly(num/2);
        return false;
    }
}
