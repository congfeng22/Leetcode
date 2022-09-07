public class FirstBadVersion278 {
    public int firstBadVersion(int n) {
        long i=1;
        while (i<=(long) n && !isBadVersion((int) i)) i*=2;
        if (i>n) i=n;
        long l = i/2; long r = i;
        while (l<r-1){
            long mid = (l+r)/2;
            if (isBadVersion((int) mid)) r=mid;
            else l=mid;
        }
        return (int) r;
    }
    public boolean isBadVersion(int n){
        return true;
    }
}
