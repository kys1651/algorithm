import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> wishList = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            wishList.put(want[i],number[i]);
        }
        HashMap<String, Integer> discountList = new HashMap<>();
        for(int i = 0; i < 9; i++){
            discountList.put(discount[i], discountList.getOrDefault(discount[i],0)+1);
        }
        for(int i = 0; i <= discount.length - 10; i++){
            discountList.put(discount[i+9], discountList.getOrDefault(discount[i+9],0)+1);
            if(isCan(wishList,discountList)) answer++;
            discountList.put(discount[i], discountList.get(discount[i])-1);
        }
        return answer;
    }
    private static boolean isCan(HashMap<String, Integer> wish, HashMap<String, Integer> discount){
        for(String key : wish.keySet()){
            int wishCount = wish.get(key);
            int discountCount = discount.getOrDefault(key,0);
            if(wishCount != discountCount) return false;
        }
        return true;
    }

}