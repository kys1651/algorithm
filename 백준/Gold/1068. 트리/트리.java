import java.util.*;
import java.io.*;

public class Main {
    static int[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nodes = new int[n];
        int rootIdx = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nodes[i] = Integer.parseInt(st.nextToken());
            if(nodes[i] == -1) rootIdx = i;
        }

        int deleteIdx = Integer.parseInt(br.readLine());
        if(rootIdx == deleteIdx){
            System.out.println(0);
        }else{
            deleteNode(deleteIdx);
            System.out.println(countLeafNode());
        }
    }

    private static int countLeafNode() {
        int count = 0;
        for (int i = 0; i < nodes.length; i++) {
            if(nodes[i] == -2) continue;

            boolean leaf = true;
            for (int j = 0; j < nodes.length; j++) {
                if(nodes[j] == i) {
                    leaf = false;
                    break;
                }
            }
            if(leaf) count++;
        }
        return count;
    }

    private static void deleteNode(int deleteIdx) {
        // 삭제해야 할 값은 -2를 넣어줌
        nodes[deleteIdx] = -2;

        // 현재 deleteIdx를 부모노드로 하는 노드 또한 전부 지워주어야한다.
        for (int i = 0; i < nodes.length; i++) {
            if(nodes[i] == deleteIdx){
                deleteNode(i);
            }
        }
    }
}
