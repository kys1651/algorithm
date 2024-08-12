import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

class Point {
    String value;
    TreeMap<String, Point> map;

    public Point(String value) {
        this.value = value;
        map = new TreeMap<>();
    }

    public void add(int cur, int limit, String[] keyword) {
        if (cur > limit) return;
        Point point = map.getOrDefault(keyword[cur], new Point(keyword[cur]));
        point.add(cur + 1, limit, keyword);
        map.put(keyword[cur], point);
    }

    public void print(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++) sb.append("--");
        sb.append(value).append('\n');
        for(Point p : map.values()) p.print(sb, count + 1);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeMap<String, Point> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int c = Integer.parseInt(input[0]);
            Point point = map.getOrDefault(input[1], new Point(input[1]));
            point.add(2, c, input);
            map.put(input[1], point);
        }

        StringBuilder sb = new StringBuilder();
        for(Point p : map.values()) {
            p.print(sb,0);
        }
        System.out.println(sb);
    }
}