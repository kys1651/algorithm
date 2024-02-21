import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static HashMap<String, String> parent;
    static HashMap<String, Integer> rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            makeSet();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                union(a, b);
                String v = find(a);
                sb.append(rank.get(v)).append('\n');
            }
        }
        System.out.println(sb);
    }

    private static String find(String x) {
        // 만약 부모키가 없다면
        if (!parent.containsKey(x)) {
            parent.put(x, x);
            rank.put(x, 1);
            return x;
        }
        // 부모값이 자기 자신이면 리턴
        if (parent.get(x).equals(x)) {
            return x;
        }
        // 부모키가 있다면
        String p = find(parent.get(x));
        parent.put(x,p);
        return p;
    }

    private static void union(String a, String b) {
        a = find(a);
        b = find(b);
        if (a.equals(b)) {
            return;
        }

        // a가 더 크다면 b를 a에 연결
        if (rank.get(a) > rank.get(b)) {
            parent.put(b, a);
            rank.put(a, rank.get(a) + rank.get(b));
        } else {
            parent.put(a, b);
            rank.put(b, rank.get(a) + rank.get(b));
        }
    }

    private static void makeSet() {
        parent = new HashMap<>();
        rank = new HashMap<>();
    }
}