package _5_day;

public class _204_count_primes {
    // O(nlog(logn))
    public int countPrimes(int n) {
        int res = 0;
        boolean[] notPrimes = new boolean[n];
        for (int x = 2; x < n; x++) {
            if (notPrimes[x]) continue;
            res++;
            // 如果 x 是质数，那么 2x、3x、4x.... 肯定不是质数
            for (int i = x; i < n; i += x) {
                notPrimes[i] = true;
            }
        }
        return res;
    }

    // O(n^2)
    public int countPrimes1(int n) {
        int res = 0;
        for (int x = 2; x < n; x++) {
            res += isPrime(x) ? 1 : 0;
        }
        return res;
    }

    private boolean isPrime(int x) {
        for (int i = 2; i < x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }
}
