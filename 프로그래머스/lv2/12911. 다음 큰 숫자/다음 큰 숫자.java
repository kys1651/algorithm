class Solution {
    public int solution(int n) {
        int answer = 0;
        int nCount = oneCount(n);
        int check = ++n;
        
        while(nCount != oneCount(check)){
            check++;
        }
        return check;
    }
    
    public int oneCount(int num){
        String binary = Integer.toBinaryString(num);
        int count = 0;
        for(int i = 0; i < binary.length(); i++){
            if(binary.charAt(i)=='1')
                count++;
        }
        return count;
    }
}