import java.util.*;
import java.io.*;

public class Main {
    static String[][] map;
    static char[] command;
    static Item[] items;
    static HashMap<String, Monster> monsters;
    static HashMap<String, String> itemName;
    static int N, M, startX, startY, gameCount, bossX, bossY;
    static String resultText = "Press any key to continue.";
    static Player player;
    // 상,하,좌,우
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N][M];
        int mCount = 0, aCount = 0;
        // 맵 입력
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = input[j];
                if (map[i][j].equals("@")) {
                    startX = i;
                    startY = j;
                    map[i][j] = ".";
                } else if (map[i][j].equals("&")) {
                    mCount++;
                } else if (map[i][j].equals("M")) {
                    bossX = i;
                    bossY = j;
                    map[i][j] = "&";
                    mCount++;
                } else if (map[i][j].equals("B")) {
                    aCount++;
                }
            }
        } // 맵 입력 종료

        // 명령어 입력
        command = br.readLine().toCharArray();

        // 몬스터 입력
        monsters = new HashMap<>();
        for (int i = 0; i < mCount; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            String name = st.nextToken();
            int attack = Integer.parseInt(st.nextToken());
            int defense = Integer.parseInt(st.nextToken());
            int hp = Integer.parseInt(st.nextToken());
            int exp = Integer.parseInt(st.nextToken());
            map[x][y] = name;
            monsters.put(name, new Monster(name, attack, defense, hp, exp));
        } // 몬스터 입력 종료

        // 장비 입력
        items = new Item[aCount];
        itemName = new HashMap<>();
        for (int i = 0; i < aCount; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            String name = st.nextToken();

            items[i] = new Item(name);
            // 숫자로 저장
            map[x][y] = String.valueOf(i);
            itemName.put(map[x][y], name);
            String value = st.nextToken();
            if (name.equals("O")) {
                items[i].special = value;
            } else {
                items[i].value = Integer.parseInt(value);
            }
        } // 장비 입력 종료

        player = new Player(startX, startY);
        gamePlay(player);
        printResult();
    }

    private static void print() {
        System.out.println(player.x + " " + player.y + " " + command[gameCount]);
        String mark = map[player.x][player.x];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j].equals("Boss")) {
                    System.out.print('M');
                } else if (monsters.containsKey(map[i][j])) {
                    System.out.print('&');
                } else if (itemName.containsKey(map[i][j])) {
                    System.out.print('B');
                } else if (i == player.x && j == player.y) {
                    System.out.print('@');
                } else {
                    System.out.print(map[i][j]);
                }
            }
            System.out.println();
            map[player.x][player.x] = mark;
        }
    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        // 게임 끝난 시점 그리드
        if (!resultText.contains("KILLED")) {
            map[player.x][player.y] = "@";
        }
        if (resultText.contains("WIN!") || resultText.contains("KILLED")) {
            gameCount++;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == bossX && j == bossY && !resultText.contains("WIN!")) {
                    map[i][j] = "M";
                } else if (monsters.containsKey(map[i][j])) {
                    map[i][j] = "&";
                } else if (itemName.containsKey(map[i][j])) {
                    map[i][j] = "B";
                }
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        sb.append("Passed Turns : ").append(gameCount).append('\n');
        sb.append("LV : ").append(player.level).append('\n');
        sb.append("HP : ").append(player.hp).append('/').append(player.maxHp).append('\n');
        sb.append("ATT : ").append(player.attack).append('+').append(player.weapon.value).append('\n');
        sb.append("DEF : ").append(player.defense).append('+').append(player.amor.value).append('\n');
        sb.append("EXP : ").append(player.exp).append('/').append(player.level * 5).append('\n');
        sb.append(resultText);

        System.out.println(sb);
    }

    private static void getDeadText(String text) {
        StringBuilder sb = new StringBuilder();
        sb.append("YOU HAVE BEEN KILLED BY ").append(text).append("..");
        resultText = sb.toString();
    }

    private static void gamePlay(Player p) {
        for (; gameCount < command.length; gameCount++) {
            int d = getDir(command[gameCount]);
            int nX = p.x + dirX[d];
            int nY = p.y + dirY[d];

            // 못움직이는 상황: 벽이거나 배열범위 밖
            if (!isIn(nX, nY) || map[nX][nY].equals("#")) {
                if (map[p.x][p.y].equals("^")) {
                    if (p.thorn(p.x, p.y)) {
                        getDeadText("SPIKE TRAP");
                        return;
                    }
                }
                continue;
            }

            if (map[nX][nY].equals(".")) {
                p.x = nX;
                p.y = nY;
            }
            // 가시일 경우
            else if (map[nX][nY].equals("^")) {
                if (p.thorn(nX, nY)) {
                    getDeadText("SPIKE TRAP");
                    return;
                }
            }
            // 몬스터라면
            else if (monsters.containsKey(map[nX][nY])) {
                // 몬스터를 잡고 끝냄
                Monster monster = monsters.get(map[nX][nY]);
                if (p.battle(monster, nX, nY)) {
                    // 보스면 종료
                    if (p.x == nX && p.y == nY && p.x == bossX && p.y == bossY) {
                        resultText = "YOU WIN!";
                        return;
                    }
                }
                // 못잡고 끝냄
                else {
                    getDeadText(map[nX][nY]);
                    return;
                }
            }
            // 악세사리일 경우
            else {
                int acIdx = Integer.parseInt(map[nX][nY]);
                p.addItem(items[acIdx]);
                map[nX][nY] = ".";
                p.x = nX;
                p.y = nY;
            }
        }
    }

    private static int getDir(char d) {
        switch (d) {
            case 'U':
                return 0;
            case 'D':
                return 1;
            case 'L':
                return 2;
            default:
                return 3;
        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    // 몬스터 클래스
    static class Monster {
        String name;
        int attack;
        int defense;
        int hp;
        int maxHp;
        int exp;

        public Monster(String name, int attack, int defense, int hp, int exp) {
            this.name = name;
            this.attack = attack;
            this.defense = defense;
            this.maxHp = this.hp = hp;
            this.exp = exp;
        }
    }

    // 장비 클래스
    static class Item {
        String name;
        int value;
        String special;

        public Item(String name) {
            this.name = name;
        }
    }

    static class Player {
        int x;
        int y;
        int maxHp;
        int hp;
        int attack;
        int defense;
        int level;
        int exp;

        Item weapon;
        Item amor;
        HashMap<String, Item> ac;
        int itemCount;

        public Player(int x, int y) {
            ac = new HashMap<>();
            this.maxHp = this.hp = 20;
            this.attack = 2;
            this.defense = 2;
            this.level = 1;
            this.x = x;
            this.y = y;
            weapon = new Item("");
            weapon.value = 0;
            amor = new Item("");
            amor.value = 0;
        }

        public void addItem(Item item) {
            if (item.name.equals("W")) {
                weapon = item;
            } else if (item.name.equals("A")) {
                amor = item;
            } else {
                // 장신구를 착용하지 않았을 경우
                if (itemCount < 4 && !ac.containsKey(item.special)) {
                    ac.put(item.special, item);
                    itemCount++;
                }
            }
        }

        // 잡으면 true, 지면 false
        public boolean battle(Monster monster, int nX, int nY) {
            int pAttack = getAttack();
            if (ac.containsKey("CO")) {
                if (ac.containsKey("DX")) {
                    pAttack *= 3;
                } else {
                    pAttack *= 2;
                }
            }

            int monsterDamage = Math.max(1, pAttack - monster.defense);
            int playerDamage = Math.max(1, monster.attack - getDefense());
            if (nX == bossX && nY == bossY && ac.containsKey("HU")) {
                this.hp = this.maxHp;
                playerDamage = 0;
            }
            boolean firstTurn = true;
            while (true) {
                monster.hp -= monsterDamage;
                // 몬스터가 죽음
                if (monster.hp <= 0) {
                    if (ac.containsKey("HR")) {
                        this.hp += 3;
                        if (this.hp > this.maxHp) {
                            this.hp = this.maxHp;
                        }
                    }
                    map[nX][nY] = ".";
                    this.x = nX;
                    this.y = nY;

                    addExp(monster.exp);

                    return true;
                }

                if (hpMinus(playerDamage)) {
                    if (ac.containsKey("RE")) {
                        monster.hp = monster.maxHp;
                        this.hp = this.maxHp;
                        this.x = startX;
                        this.y = startY;
                        ac.remove("RE");
                        return true;
                    }
                    return false;
                }

                if (firstTurn) {
                    monsterDamage = Math.max(1, getAttack() - monster.defense);
                    playerDamage = Math.max(1, monster.attack - getDefense());
                    firstTurn = false;
                }
            }
        }

        public boolean thorn(int nX, int nY) {
            int damage = 5;
            if (ac.containsKey("DX")) {
                damage = 1;
            }

            if (hpMinus(damage)) {
                if (ac.containsKey("RE")) {
                    this.hp = this.maxHp;
                    this.x = startX;
                    this.y = startY;
                    ac.remove("RE");
                    return false;
                }
                return true;
            }
            this.x = nX;
            this.y = nY;
            return false;
        }

        private void addExp(int exp) {
            if (ac.containsKey("EX")) {
                exp *= 1.2;
            }
            this.exp += exp;
            if (this.exp >= this.level * 5) {
                this.level++;
                this.exp = 0;
                this.maxHp += 5;
                this.attack += 2;
                this.defense += 2;
                this.hp = this.maxHp;
            }
        }

        private int getDefense() {
            return defense + amor.value;
        }

        private int getAttack() {
            return this.attack + weapon.value;
        }

        // 죽으면 true, 안죽으면 false;
        public boolean hpMinus(int damage) {
            hp -= damage;
            if (hp <= 0) {
                hp = 0;
                return true;
            }
            return false;
        }

    }
}
