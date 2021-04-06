package 数组;

public class Solution204_countPrimes {
    public int countPrimes(int n) {
        int[] prime=new int[n];
        for (int i = 2; i < (int)Math.sqrt(n)+1; i++) {
            if (!isPrime(i)){
                continue;
            }
            int j=i*i;
            while (j<n){
                prime[j]=1;
                j+=i;
            }
        }
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum+=prime[i];
        }
        return n-sum-2;
    }
    public boolean isPrime(int n){
        if (n<2) return false;
        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            if (n%i==0) return false;
        }
        return true;
    }
}
