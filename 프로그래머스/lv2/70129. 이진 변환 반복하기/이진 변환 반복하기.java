class Solution {
    public int[] solution(String s) {
        int count = 0; // 이진 변환의 횟수
        int zero = 0; // 변환 과정에서 제거된 모든 0의 개수
        
        while(!s.equals("1")){
            int len = s.length(); // 0을 제거하기 전 s의 길이
            s = s.replaceAll("0",""); // 0을 제거함
            zero += len - s.length(); // 0을 제거 한 뒤 길이
            count ++; // 이진 변환한 횟수 증가
            s = Integer.toBinaryString(s.length()); // s의 길이를 이진수 변환
        }
        return new int[]{count, zero};
    }
}