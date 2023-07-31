import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳1987 {


    static int N;
    static int M;
    static char[][] map;
    static int max = Integer.MIN_VALUE;

    static int[] idx = {-1, 1, 0, 0};
    static int[] idy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        getResult(0, 0, "" + map[0][0]);

        System.out.println(max);
    }

    private static void getResult(int i, int j, String line) {
        int count = 0;
        while (count < 4) {
            int x = i + idx[count];
            int y = j + idy[count];
            if (x >= 0 && y >= 0 && x < N && y < M) {
                if (line.contains("" + map[x][y])) {
                    max = Math.max(line.length(), max);
                } else
                    getResult(x, y, line + map[x][y]);
            }
            count++;
        }

    }
}
