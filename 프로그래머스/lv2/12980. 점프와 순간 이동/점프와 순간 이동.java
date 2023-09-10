import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        for(; n != 0; n /= 2){
            if( n % 2 != 0){
                ans++;
                n--;
            }
        }
        return ans;
    }
}