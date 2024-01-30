import java.io.*;
import java.util.*;

/**
 * 제목: 17478번 재귀함수가 뭔가요? Silver5
 * @author 김용수
 * 제출 시간: 2024년 1월 29일 13:50:22
 * 메모리 : 11840KB
 * 시간 : 88ms
 * 접근 방법 : 
 * 1. 재귀조건과 종료조건을 파악하여 출력한다.
 */
class Main{
	// 메모리 절약을 위해서 text를 미리 선언함
	static String[] text = {
			"\"재귀함수가 뭔가요?\"",
			"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
			"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"",
			"\"재귀함수는 자기 자신을 호출하는 함수라네\"",
			"라고 답변하였지.",
			"____"
	};
	static StringBuilder sb = new StringBuilder();
	static int n;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		recursion(0);
		System.out.println(sb);
	}

	private static void recursion(int depth) {
		addWord(depth,text[0]);
		
		if(depth == n) {
			addWord(depth,text[4]);
			addWord(depth,text[5]);
			return;
		}
		addWord(depth,text[1]);
		addWord(depth,text[2]);
		addWord(depth,text[3]);
		
		if(depth != n) {
			recursion(depth+1);		
		}
		addWord(depth,text[5]);
	}
	private static void addWord(int depth,String word) {
		for(int i = 0; i < depth; i++) {
			sb.append(text[6]);
		}
		sb.append(word).append("\n");
	}
}
