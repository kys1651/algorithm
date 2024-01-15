import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        int[] tree = new int[(int)Math.pow(2, k) - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < tree.length; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        int len = tree.length;
        int parent = len;
        while (parent != 0) {
            int child = (parent - 1) / 2;
            int gap = (parent - child) * 2;
            for(int i = child; i < len; i += gap){
                sb.append(tree[i] + " ");
            }
            parent = child;
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
