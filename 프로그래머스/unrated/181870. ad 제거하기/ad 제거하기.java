import java.util.stream.*;
import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        
        return Arrays.stream(strArr).filter(a -> !a.contains("ad")).toArray(String[]::new);
    }
}