import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static String[] max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        max = new String[101];
        min = new String[101];
        init();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int idx = Integer.parseInt(br.readLine());
            if(idx == 6){
                sb.append("6 ").append(getMax(idx));
            }else{
                sb.append(getMin(idx)).append(" ").append(getMax(idx));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static String getMin(int idx) {
        if (min[idx] != null) {
            return min[idx];
        }
        for (int i = 2; i <= idx - 2; i++) {
            String front = min[i];
            if(i == 6) front = "6";
            if (front == null) {
                getMin(i);
            }
            if (min[idx - i] == null) {
                getMin(idx - i);
            }
            String value = front + min[idx - i];
            if (min[idx] == null) {
                min[idx] = value;
            } else if (compare(min[idx], value).equals(min[idx])) {
                min[idx] = value;
            }
        }
        return min[idx];
    }

    private static String getMax(int idx) {
        if (max[idx] != null) {
            return max[idx];
        }
        max[idx] = "0";
        for (int i = 2; i <= idx - 2; i++) {
            if (max[i] == null) {
                getMax(i);
            }
            if (max[idx - i] == null) {
                getMax(idx - i);
            }
            String value = max[i] + max[idx - i];
            max[idx] = compare(max[idx], value);
        }
        return max[idx];
    }

    private static String compare(String a, String b) {
        if (a.equals(b)) {
            return a;
        } else if (a.length() > b.length()) {
            return a;
        } else if (a.length() < b.length()) {
            return b;
        } else {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    if (a.charAt(i) > b.charAt(i)) {
                        return a;
                    } else {
                        return b;
                    }
                }
            }
        }
        return a;
    }

    private static void init() {
        max[2] = min[2] = "1";
        max[3] = min[3] = "7";
        max[4] = "11"; min[4] = "4";
        max[5] = "71"; min[5] = "2";
        max[6] = "111"; min[6] = "0";
        max[7] = "711"; min[7] = "8";
        min[8] = "10"; min[9] = "18";
    }
}