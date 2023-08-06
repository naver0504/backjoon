import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Node> homes;
    static List<Node> chickens;
    static int n;
    static int m;
    static int result = Integer.MAX_VALUE;

    static class Node {
        int r;
        int y;

        public Node(int r, int y) {
            this.r = r;
            this.y = y;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        homes = new ArrayList<>();
        chickens = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
               int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    homes.add(new Node(i, j));
                } else if (value == 2) {
                    chickens.add(new Node(i, j));
                }
            }
        }


        List<Node> list = new ArrayList<>();
        backTracking(0, list);

        System.out.println(result);

    }

    private static void backTracking(int order, List<Node> list) {
        if (list.size() == m) {
            int tmpResult = 0;
            for (int i = 0; i < homes.size(); i++) {
                int homeMin = Integer.MAX_VALUE;
                Node home = homes.get(i);
                for (int j = 0; j < m; j++) {
                    Node chicken = list.get(j);
                    homeMin = Math.min(homeMin, Math.abs(home.r - chicken.r) + Math.abs(home.y - chicken.y));
                }
                tmpResult += homeMin;
            }
            result = Math.min(tmpResult, result);

        } else {
            if (m - list.size() > chickens.size() - order) {
                return;
            }
            ArrayList<Node> newList1 = new ArrayList<>(list);
            newList1.add(chickens.get(order));
            backTracking(order + 1, newList1);
            backTracking(order + 1, list);
        }
    }
}
