import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static class Point{
        int x;
        int y;
        int distance;

        public Point(int x, int y, int distance){
            this.x = x;
            this.y= y;
            this.distance = distance;
        }
    }

    static int n;
    static boolean[] visit;
    static Point[] customers;
    static Point company, house;
    static int result;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            company = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);
            house = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);

            visit = new boolean[n];
            customers = new Point[n];
            for(int i = 0; i < n; i++){
                customers[i] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);
            }

            result = Integer.MAX_VALUE;
            bruteforce(new Point(company.x, company.y, 0),0);
            sb.append("#" + tc + " " + result).append("\n");
        }
        System.out.println(sb);
    }

    private static void bruteforce(Point pos, int depth){
        if(depth == n){
            int answer = calc(pos,house);
            result = Math.min(answer,result);
            return;
        }

        for(int i = 0; i < n; i++){
            if(visit[i]) continue;

            visit[i] = true;
            int nextValue = calc(pos,customers[i]);
            bruteforce(new Point(customers[i].x, customers[i].y, nextValue),depth+1);
            visit[i] = false;
        }
    }

    private static int calc(Point current, Point next){
        int dist = current.distance;
        return dist + Math.abs(current.x - next.x) + Math.abs(current.y - next.y);
    }
}