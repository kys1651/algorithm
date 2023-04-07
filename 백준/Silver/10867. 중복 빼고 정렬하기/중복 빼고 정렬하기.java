import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(!list.contains(num)) list.add(num);
        }

        Collections.sort(list);

        for (int num : list) {
            sb.append(num + " ");
        }
        System.out.println(sb);

    }
}