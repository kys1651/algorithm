import java.util.stream.*;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if(arr1.length > arr2.length) return 1;
        else if(arr1.length == arr2.length){
            int sum1 = IntStream.of(arr1).sum();
            int sum2 = IntStream.of(arr2).sum();
            if(sum1 > sum2){
                return 1;
            }else if(sum1 == sum2){
                return 0;
            }else{
                return -1;
            }
            
        }else{
            return -1;
        }
        
    }
}