class Solution {
    public long solution(long n) {
        long a = (long)Math.sqrt(n);
        if(Math.sqrt(n)==a)
            return (a+1)*(a+1);
        else return -1;
    }
}