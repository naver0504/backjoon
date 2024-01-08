package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 마법사상어와파이어스톰_20058 {

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static int N;
    static int realN = 1;

    static int[] idx = {0, 1, 0, -1};
    static int[] idy = {1, 0, -1, 0};

    static int Q;
    static int[][] ices;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            realN *= 2;
        }

        ices = new int[realN][realN];
        for (int i = 0; i < realN; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < realN; j++) {
                ices[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int L = list.get(i);
            doFireStorm(L);
        }

        int resultFirst = 0;
        for (int i = 0; i < realN; i++) {
            for (int j = 0; j < realN; j++) {
            }
        }

        int max = 0;
        int[][] visited = new int[realN][realN];
        for (int i = 0; i < realN; i++) {
            for (int j = 0; j < realN; j++) {
                if (visited[i][j] == 0 && ices[i][j] != 0) {

                    int count = 1;
                    Queue<Pair> queue = new LinkedList<>();
                    visited[i][j] = 1;
                    queue.offer(new Pair(i, j));
                    while (!queue.isEmpty()) {
                        Pair poll = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int ndx = poll.x + idx[k];
                            int ndy = poll.y + idy[k];
                            if (ndx < 0 || ndy < 0 || ndx >= realN || ndy >= realN) continue;
                            if (visited[ndx][ndy] == 0 && ices[ndx][ndy] > 0) {
                                count++;
                                visited[ndx][ndy] = 1;
                                queue.offer(new Pair(ndx, ndy));
                            }

                        }
                    }

                    max = Math.max(count, max);
                }
            }
        }

        System.out.println(resultFirst);
        System.out.println(max);




    }

    private static void doFireStorm(int level) {
        int L = 1;
        for (int i = 0; i < level; i++) {
            L *= 2;
        }

        for (int i = 0; i < realN / L; i++) {
            for (int j = 0; j < realN / L; j++) {
                int firstX = L * i;
                int firstY = L * j;
                int[][] tmp = new int[L][L];
                for (int a = 0; a < L; a++) {
                    for (int b = 0; b < L; b++) {
                        tmp[a][b] = ices[firstX + a][firstY + b];
                    }
                }
                for (int b = L - 1; b >= 0; b--) {
                    for (int a = 0; a < L; a++) {
                        ices[firstX + a][firstY + b] = tmp[L - b - 1][a];
                    }
                }
            }
        }

        List<Pair> pairList = new ArrayList<>();
        for (int i = 0; i < realN; i++) {
            for (int j = 0; j < realN; j++) {
                int count = 0;

                for (int k = 0; k < 4; k++) {
                    int ndx = i + idx[k];
                    int ndy = j + idy[k];
                    if(ndx<0 || ndy <0 || ndx>=realN|| ndy >=realN) continue;
                    if(ices[ndx][ndy] > 0) count++;
                }

                if(count < 3 && ices[i][j] > 0) pairList.add(new Pair(i, j));
            }
        }

        pairList.forEach(
                pair -> {
                    ices[pair.x][pair.y]--;
                }
        );
    }
}
