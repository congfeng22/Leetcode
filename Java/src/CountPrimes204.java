import java.util.ArrayList;
import java.util.List;

public class CountPrimes204 {
    public int countPrimes(int n) {
        if (n<3) return 0;
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        int count = 3;
        while (count<n){
            boolean isprime = true;
            for (int p : primes){
                if (p>Math.sqrt(count)) break;
                if (count%p==0){
                    isprime=false;
                    break;
                }
            }
            if (isprime) primes.add(count);
            count++;
        }
        return primes.size();
    }
}
