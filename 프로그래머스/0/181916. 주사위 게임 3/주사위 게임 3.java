import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(a, 1);
        map.put(b, map.getOrDefault(b,0) + 1);
        map.put(c, map.getOrDefault(c,0) + 1);
        map.put(d, map.getOrDefault(d,0) + 1);
        
        int size = map.size(), ret = 1;
        if(size == 1){
            ret = 1111 * a;
        }else if(size == 2){
            a = 0;
            b = 0;
            boolean isTriple = true;
            for(int k : map.keySet()){
                if(a == 0) a = k;
                else {
                    b = k;
                    if(map.get(b) == 3){
                        int tmp = a;
                        a = b;
                        b = tmp;
                    }
                }
                if(map.get(k) == 2) isTriple = false;
            }
            ret = isTriple ? (int) Math.pow(10 * a + b, 2)
                :(a + b) * Math.abs(a - b);
        }else if(size == 3){
            for(int k : map.keySet()){
                int val = map.get(k);
                if(val != 2) ret *= k;    
            }
        }else{
            ret = Math.min(Math.min(a,b), Math.min(c,d));
        }
        return ret;
    }
}