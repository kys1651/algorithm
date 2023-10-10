class Solution {
    public int solution(int a, int b, int c) {
        int count = 1;
        
        if(a == b && b == c){
            count++;
        }
        if(a == b || b == c || a == c){
            count++;
        }
        int result = 1;
        for(int i = 1 ; i <= count; i++){
            result *= (pow(a,i) + pow(b,i) + pow(c,i));
        }
        return result;
    }
    
    public int pow(int base, int exponent){
        if(exponent == 0) return 1;
        return base * pow(base, exponent - 1);
    }
}