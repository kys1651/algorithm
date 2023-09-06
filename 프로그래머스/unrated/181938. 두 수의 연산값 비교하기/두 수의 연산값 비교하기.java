class Solution {
    public int solution(int a, int b) {
        int result1 = cal1(a,b);
        int result2 = cal2(a,b);
        
        return Math.max(result1,result2);
    }
    
    public int cal1(int a, int b){
        return Integer.parseInt(String.valueOf(a) + String.valueOf(b));
    }
    
    public int cal2(int a, int b){
        return 2 * a * b;
    }
}