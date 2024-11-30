class Solution {
    public int solution(int a, int b) {
        return solve(b /= GCD(a,b)) ? 1 : 2;
    }
    
    private static boolean solve(int n){
        boolean ret = true;
        while(n > 1){
            for(int i = 2; i <= n; i++){
                if( n % i == 0){
                    n /= i;
                    if( i != 2 && i != 5){
                        return false;
                    }
                    break;
                }
            }
        }
        return ret;
    }
    
    private static int GCD(int a, int b){
        if(a > b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        while(a != 0){
            int tmp = b % a;
            b = a;
            a = tmp;
        }
        return b;
    }
}