import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < players.length; i++){
            map.put(players[i],i);
        }
        
        for(String call : callings){
            int x = map.get(call);
            
            String next = players[x-1];
            
            players[x-1] = call;
            map.put(call,x-1);
            
            players[x] = next;
            map.put(next,x);
        }
        return players;
    }
}