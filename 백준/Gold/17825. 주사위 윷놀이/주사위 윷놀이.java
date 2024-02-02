import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 입력 받는 주사위에서 나올 수
	static int[] dice = new int[10];
	// 각 말의 위치
	static int[] pos = new int[4];
	// 점수의 최댓값
	static int result;
	// 특수한 칸에 위치시 체크한다.
	static int[] path = {
			// 일반 0 ~ 21
			0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, -1,
			// 파란 경로 22 ~ 26
			10, 13, 16, 19, 25,
			// 파란 경로 27 ~ 30
			20, 22, 24, 25,
			// 파란 경로 31 ~ 35
			30, 28, 27, 26, 25,
			// 25이후 경로 36 ~ 40
			25, 30, 35, 40, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 10; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		// 게임 시작
		gamePlay(0, 0);
		
		System.out.println(result);
	}

	// 게임 플레이
	private static void gamePlay(int depth, int count) {
		// 10턴을 마쳤다면 종료
		if (depth == 10) {
			result = Math.max(result, count);
			return;
		}

		// 플레이어의 수 0 ~ 3
		for (int i = 0; i < 4; i++) {
			// 현재 플레이어 인덱스 받아오기
			int originIdx = pos[i];

			// 말이 도착지점이면 넘어감
			if (path[originIdx] == -1)
				continue;


			// 도착지점이 아니라면 diceCount만큼 움직인 위치를 받아온다.
			int nextIdx = getNextPosition(i, dice[depth]);
			// 다음 위치 점수
			int nextScore = path[nextIdx];
			
			// -1이라면 도착지점으로 바로 들어가는 경우
			if (nextScore == -1) {
				// 도착지점에 넣어준 뒤 재귀 호출
				pos[i] = nextIdx;
				// 점수를 더하지 않고 보낸다.
				gamePlay(depth + 1, count);
			} else if (isCheck(nextIdx)) {
				// 도착지점 아닌 경우엔 다른 사람이 현재 있는지 확인
				pos[i] = nextIdx;
				// 점수를 더 해준 뒤 보낸다.
				gamePlay(depth + 1, count + nextScore);
			}
			// 기존 인덱스로 상태를 복구
			pos[i] = originIdx;
		}
	}

	// 갈 수 있는지 확인하기
	private static boolean isCheck(int nextIdx) {
		for (int i = 0; i < 4; i++) {
			int idx = pos[i];

			// 40인 경우는 무조건 안된다.
			if (path[idx] == 40 && path[nextIdx] == 40) {
				return false;
			}
			// 인덱스가 같다면 같은 위치
			if (idx == nextIdx) {
				return false;
			}
		}

		return true;
	}

	// 다음 위치 반환 받기
	private static int getNextPosition(int player, int diceCount) {
		int current = pos[player];
		int nextPosition = current + diceCount;
		// 일반 경로일 경우 위치
		if (current < 21) {
			// 만약 현재 위치가 21보다 작은데 nextPosition이 넘는다면 바로 최종 목적지이다.
			if (nextPosition >= 21) {
				return 21;
			}
		} else if (current < 26) {
			// 26보다 작은 위치에서 26을 넘는다면 25의 위치로 변환시킴
			if (nextPosition >= 26) {
				return 36 + (nextPosition - 26);
			}
		} else if (current < 30) {
			// 30보다 작은 위치에서 다음 위치가 30이 넘는다면 위치를 변환시킴
			if (nextPosition >= 30) {
				return 36 + (nextPosition - 30);
			}
		} else if (current < 35) {
			// 35보다 작은 위치에서 35가 넘는다면 위치를 변환시킨다.
			if (nextPosition >= 35) {
				return 36 + (nextPosition - 35);
			}
		} else if (current < 40) {
			// 40보다 적은 위치에서 40이 넘는다면 도착점
			if (nextPosition >= 40) {
				return 40;
			}
		}
		
		// 만약 다음 값이 파란 경로인 [5] = 10,[10] = 20,[15] = 30라면
		// 각 시작점으로 위치를 아예 옮겨줌
		if (nextPosition == 5)
			return 22;
		else if (nextPosition == 10)
			return 27;
		else if (nextPosition == 15)
			return 31;
		else
			return nextPosition;
	}
}