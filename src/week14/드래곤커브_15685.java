package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 드래곤커브_15685 {

    static int Max = 101;

    static class Dragon {
        int x;
        int y;
        int dir;
        int generation;

        public Dragon(int x, int y, int dir, int generation) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.generation = generation;
        }
    }

    static class Curve {
        int preX;
        int preY;

        int nextX;
        int nextY;
        int dir;

        public Curve(int preX, int preY, int nextX, int nextY, int dir) {
            this.preX = preX;
            this.preY = preY;
            this.nextX = nextX;
            this.nextY = nextY;
            this.dir = dir;
        }
    }


    static boolean[][] visited = new boolean[Max][Max];
    static int N;
    static List<Dragon> dragons;


    static int idx[] = {1, 0, -1, 0};
    static int idy[] = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dragons = new ArrayList<>(N);

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());


            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());



            dragons.add(new Dragon(x, y, d, g));
        }

        for (int i = 0; i < dragons.size(); i++) {
            createDragonCurve(i);
        }


        System.out.println(getAns());


    }

    private static int getAns() {
        int ans = 0;
        for (int i = 0; i < Max - 1; i++) {
            for (int j = 0; j < Max - 1; j++) {
                if (visited[i][j] && visited[i + 1][j] && visited[i][j + 1] && visited[i + 1][j + 1]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private static void createDragonCurve(int dragonIdx) {
        Dragon dragon = dragons.get(dragonIdx);
        int startX = dragon.x;
        int startY = dragon.y;
        int dir = dragon.dir;
        int nextX = getNextX(startX, dir);
        int nextY = getNextY(startY, dir);

        List<Curve> curves = new ArrayList<>();
        curves.add(new Curve(startX, startY, nextX, nextY, dir));
        visited[startX][startY] = true;
        visited[nextX][nextY] = true;
        for (int i = 1; i <= dragon.generation; i++) {
            int curveSize = curves.size();
            for (int j = curveSize - 1; j >= 0; j--) {
                Curve curve = curves.get(j);
                int changedDir = changeDir(curve.dir);
                int tmpX = getNextX(nextX, changedDir);
                int tmpY = getNextY(nextY, changedDir);
                visited[tmpX][tmpY] = true;
                curves.add(new Curve(nextX, nextY, tmpX, tmpY, changedDir));
                nextX = tmpX;
                nextY = tmpY;
            }

        }
    }

    private static int changeDir(int dir) {
        int change = (dir + 1) % 4;
        return change;
    }

    private static int getNextX(int x, int dir) {
        return x + idx[dir];
    }

    private static int getNextY(int y, int dir) {
        return y + idy[dir];
    }
}
