import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;

        // Input
        int[] use = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            use[i] = Integer.parseInt(st.nextToken());
        }// Input End

        Set<Integer> plug = new HashSet<>();
        for (int i = 0; i < K; i++) {
            // 사용중이라면 넘어간다.
            if (plug.contains(use[i])) {
                continue;
            }

            // 멀티탭이 비어있다면 꽂아준다.
            if (plug.size() < N) {
                plug.add(use[i]);
                continue;
            }

            // 꽂혀 있지 않다면 교체 가능한지 확인한다.
            // 앞으로도 사용 하는 전자 제품인지 확인
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < K; j++) {
                if (plug.contains(use[j]) && !list.contains(use[j])) {
                    list.add(use[j]);
                }
            }

            // 전부 다 사용한다면 가장 마지막에 사용하는 전자 제품 제거
            if (list.size() == N) {
                plug.remove(list.get(N - 1));
            }else{
                // 사용할 일 없는 전자 제품이라면 제거 해준다.
                for (int num : plug) {
                    if (!list.contains(num)) {
                        plug.remove(num);
                        break;
                    }
                }
            }
            answer++;
            plug.add(use[i]);
        }
        System.out.println(answer);
    }
}