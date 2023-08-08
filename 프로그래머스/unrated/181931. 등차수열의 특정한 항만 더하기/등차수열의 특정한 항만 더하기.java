import java.util.stream.*;

class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = IntStream.range(0,included.length).reduce(0,(x,y)->{
            if(included[y]){
                return x += (d * y)+a;
            }
            return x;
        });
        
        return answer;
    }
}