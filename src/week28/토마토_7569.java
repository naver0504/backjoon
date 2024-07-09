package week28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7569 {

    static class Tomato {
        int x;
        int y;
        int z;
        int day;

        public Tomato(int x, int y, int z, int day) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }

    static int X;
    static int Y;
    static int Z;

    static int[] idx = {0, 0, 0, 0, -1, 1};
    static int[] idy = {0, 0, -1, 1, 0, 0};
    static int[] idz = {1, -1, 0, 0, 0, 0};

    static int[][][] map;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Z = Integer.parseInt(st.nextToken());

        map = new int[X][Y][Z];

        int unRipe = 0;
        Queue<Tomato> queue = new LinkedList<>();

        for (int z = 0; z < Z; z++) {
            for (int x = 0; x < X; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < Y; y++) {
                    map[x][y][z] = Integer.parseInt(st.nextToken());
                    if(map[x][y][z] == 1){
                        queue.offer(new Tomato(x, y, z, 0));
                    }
                    if(map[x][y][z] == 0) unRipe++;
                }
            }
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            Tomato poll = queue.poll();
            answer = poll.day;

            for (int i = 0; i < 6; i++) {
                int ndx = poll.x + idx[i];
                int ndy = poll.y + idy[i];
                int ndz = poll.z + idz[i];

                if(isOutOfRange(ndx, ndy, ndz)) continue;
                if(map[ndx][ndy][ndz] != 0) continue;

                unRipe--;
                map[ndx][ndy][ndz] = 1;
                queue.offer(new Tomato(ndx, ndy, ndz, poll.day + 1));
            }
        }

        if(unRipe != 0) System.out.println(-1);
        else System.out.println(answer);




    }

    public static boolean isOutOfRange(int ndx, int ndy, int ndz) {
        return (ndx < 0 || ndy < 0 || ndz < 0 || ndx >= X || ndy >= Y | ndz >= Z);
    }
}
