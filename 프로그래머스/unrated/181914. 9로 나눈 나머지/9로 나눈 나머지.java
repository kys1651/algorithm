class Solution {
    public int solution(String number) {
        return number.chars().map(n -> (n - '0')%9).sum() % 9;
    }
}