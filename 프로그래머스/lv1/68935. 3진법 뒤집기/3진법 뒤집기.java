class Solution {
    public int solution(int n) {
        String str = "";
        
        while(n > 0){
            str = (n%3) + str;
            n /= 3;
        }
        str = new StringBuilder(str).reverse().toString();
        int answer = Integer.parseInt(str,3);
        
        System.out.println(answer);
        
        return answer;
    }
}