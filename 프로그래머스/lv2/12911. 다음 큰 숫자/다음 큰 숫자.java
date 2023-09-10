class Solution {
    public int solution(int n) {
        // 정수의 이진수에서 true bit의 개수를 리턴해주는 메서드
        int nCount = Integer.bitCount(n);
        int compare = n + 1;
        
        while(true){
            if(Integer.bitCount(compare)==nCount)
                break;
            compare++;
        }
        
        return compare;
    }
}