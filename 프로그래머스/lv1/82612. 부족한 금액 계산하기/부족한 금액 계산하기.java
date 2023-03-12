class Solution {
    public long solution(long price, long money, long count) {
        long answer = (long)Math.max(price * (count * (count+1))/2-money,0);
        return answer;
    }
}