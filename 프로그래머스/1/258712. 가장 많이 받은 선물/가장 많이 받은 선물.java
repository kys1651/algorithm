import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        HashMap<String, Integer> indexList = new HashMap<>();
        for(int i = 0;i < n; i++) indexList.put(friends[i], i);
        
        int[] giftCount = new int[n];
        int[][] graph = new int[n][n];
        
        for(int i= 0;i < gifts.length; i++){
            String[] input = gifts[i].split(" ");
            int fromIdx = indexList.get(input[0]);
            int toIdx = indexList.get(input[1]);
            giftCount[fromIdx]++;
            giftCount[toIdx]--;
            graph[fromIdx][toIdx]++;
        }
        
        int answer = 0;
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                
                if(graph[i][j] > graph[j][i]) count++;
                else if(graph[i][j] == graph[j][i] && giftCount[i] > giftCount[j]) count++;
            }
            answer = Math.max(count, answer);
        }
        
        return answer;
    }
}