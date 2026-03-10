class Solution {

    long mod = 1000000007;

    public int countGoodNumbers(long n) {

        long even = (n + 1) / 2;
        long odd = n / 2;

        long ans = (power(5, even) * power(4, odd)) % mod;

        return (int) ans;
    }

    private long power(long x, long n) {

        long result = 1;

        while (n > 0) {

            if (n % 2 == 1) { 
                result = (result * x) % mod;
            }

            x = (x * x) % mod;
            n = n / 2;      
        }

        return result;
    }
}