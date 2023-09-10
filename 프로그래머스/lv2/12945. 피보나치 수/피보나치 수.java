class Solution {
    public int solution(int n) {
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        int unit = 1234567;
        
        for(int i = 2; i < arr.length; i++){
            arr[i] = (arr[i-1] + arr[i-2]) % unit;
        }
        return arr[n];
    }
}