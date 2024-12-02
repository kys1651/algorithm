import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        // mats 정렬
        Arrays.sort(mats);
        
        // mats의 가장 큰 값부터 체크한다.
        // park의 길이 lenX와 lenY를 기록한다.
        int lenX = park.length, lenY = park[0].length;
        for(int idx = mats.length - 1; idx >= 0; idx--){
            int len = mats[idx];
            // 각 포문은 lenX - mats[0]; lenY - mats[1]; 까지만 체크해주면 된다.
            for(int i = 0; i <= lenX - len; i++){
                for(int j = 0; j<= lenY - len; j++){
                    // 메서드를 호출 시켜 응답이 true면 바로 해당 mats[i] 값 리턴
                    if(isValid(i,j,len,park)){
                        return len;
                    }
                }
            }
        }
        // 아니면 -1을 리턴한다.
        return -1;
    }
    
    private static boolean isValid(int x, int y, int len, String[][] park){
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(!(park[x+i][y+j].equals("-1"))){
                    return false;
                }
            }
        }
        return true;
    }
}