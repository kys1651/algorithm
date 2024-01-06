import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[][] board;
    static int result, n;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution(0);
        System.out.println(result);
    }

    private static void solution(int depth) {
        if (depth == 5) {
            getMaxBlock(board);
            return;
        }

        int[][] originBoard = copyBoard(board);
        for (int i = 0; i < 4; i++) {
            moveBlock(i);
            solution(depth + 1);
            board = copyBoard(originBoard);
        }
    }

    private static void moveBlock(int command) {
        switch (command){
            case 0:
                upBlock();
                return;
            case 1:
                downBlock();
                return;
            case 2:
                leftBlock();
                return;
            case 3:
                rightBlock();
                return;
        }
    }

    private static void upBlock() {
        for (int i = 0; i < n; i++) {
            int block = 0;
            int idx = 0;
            for (int j = 0; j < n; j++) {
                if (board[j][i] != 0) {
                    if (block == board[j][i]) {
                        board[idx - 1][i] = block * 2;
                        block = 0;
                        board[j][i] = 0;
                    } else {
                        block = board[j][i];
                        board[j][i] = 0;
                        board[idx][i] = block;
                        idx++;
                    }
                }
            }
        }
    }

    private static void downBlock() {
        for (int i = 0; i < n; i++) {
            int block = 0;
            int idx = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (board[j][i] != 0) {
                    if (block == board[j][i]) {
                        board[idx + 1][i] = block * 2;
                        block = 0;
                        board[j][i] = 0;
                    } else {
                        block = board[j][i];
                        board[j][i] = 0;
                        board[idx][i] = block;
                        idx--;
                    }
                }
            }
        }
    }

    private static void leftBlock() {
        for (int i = 0; i < n; i++) {
            int block = 0;
            int idx = 0;
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0) {
                    if (block == board[i][j]) {
                        board[i][idx - 1] = block * 2;
                        board[i][j] = 0;
                        block = 0;
                    } else {
                        block = board[i][j];
                        board[i][j] = 0;
                        board[i][idx] = block;
                        idx++;
                    }
                }
            }
        }
    }

    private static void rightBlock() {
        for (int i = 0; i < n; i++) {
            int block = 0;
            int idx = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (board[i][j] != 0) {
                    if (block == board[i][j]) {
                        board[i][idx + 1] = block * 2;
                        block = 0;
                        board[i][j] = 0;
                    } else {
                        block = board[i][j];
                        board[i][j] = 0;
                        board[i][idx] = block;
                        idx--;
                    }
                }
            }
        }
    }

    private static void getMaxBlock(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (result < board[i][j]) {
                    result = board[i][j];
                }
            }
        }
    }

    private static int[][] copyBoard(int[][] originBoard) {
        int[][] copy = new int[originBoard.length][originBoard.length];
        for (int i = 0; i < originBoard.length; i++) {
            for (int j = 0; j < originBoard.length; j++) {
                copy[i][j] = originBoard[i][j];
            }
        }
        return copy;
    }
}