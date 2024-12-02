class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int minBill = Math.min(bill[0], bill[1]);
        int maxBill = Math.max(bill[0], bill[1]);
        int minWallet = Math.min(wallet[0], wallet[1]);
        int maxWallet = Math.max(wallet[0], wallet[1]);
        while(minBill > minWallet || maxBill > maxWallet){
            if(bill[0] > bill[1]){
                minBill /= 2;
            }
            else{
                maxBill /= 2;
            }
            
            if(maxBill < minBill){
                int tmp = maxBill;
                maxBill = minBill;
                minBill = tmp;
            }
            answer++;
        }
        return answer;
    }
}