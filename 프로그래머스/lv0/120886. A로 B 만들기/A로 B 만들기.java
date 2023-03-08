import java.util.Arrays;
class Solution {
    public int solution(String before, String after) {
        char[] b = before.toCharArray();
        char[] a = after.toCharArray();
        
        Arrays.sort(b);
        Arrays.sort(a);
        
        return new String(a).equals(new String(b))?1:0;
    }
}