import java.io.*;
import java.util.*;
class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
            StringTokenizer  st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int[][] perScore = new int[n][t];
            int[] score = new int[t];
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < t; j++){
                    int val = Integer.parseInt(st.nextToken());
                    if(val == 0) score[j]++;
                    else perScore[i][j] = 1;
                }
            }
            int totalScore[] = new int[n];
            int totalSolve[] = new int[n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < t; j++){
                    totalScore[i] += (perScore[i][j] * score[j]);
                    totalSolve[i] += perScore[i][j];
                }
            }
            ArrayList<int[] > answer = new ArrayList<>();
            for(int i = 0; i < n; i++) answer.add( new int[] {i+1,totalSolve[i], totalScore[i]});
        	Collections.sort(answer, (o1,o2) -> {
                if(o1[2] == o2[2]){
                    if(o1[1] == o2[1]) return Integer.compare(o1[0],o2[0]);
                    return Integer.compare(o2[1],o1[1]);
                }
                 return Integer.compare(o2[2],o1[2]);
            });
            int rank = 0;
            int total = 0;
            for(int i = 0; i < n; i++){
                int[] people = answer.get(i);
                if(people[0] == p){
                    rank = i + 1;
                    total = people[2];
                    break;
                }
            }
            System.out.println("#" + tc + " " + total + " " + rank);
        }
	}
}