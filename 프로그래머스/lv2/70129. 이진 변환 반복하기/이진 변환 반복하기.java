class Solution {
    public int[] solution(String s) {
        int count = 0;
        int zero = 0;
        
        while(s.length()!=1){
            int len = s.length();
            s = s.replaceAll("0","");
            zero += len - s.length();
            count ++;
            s = Integer.toBinaryString(s.length());
        }
        return new int[]{count, zero};
    }
}