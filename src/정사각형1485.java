import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 정사각형1485 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            ArrayList<Point> list = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list.add(new Point(x, y));
            }
            list.sort(new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    if (o1.x != o2.x) {
                        return o1.x - o2.x;
                    } else {
                        return o1.y - o2.y;
                    }
                }
            });

            Point p1 = list.get(0);
            Point p2 = list.get(1);
            Point p3 = list.get(2);
            Point p4 = list.get(3);
            double left = getLength(p1, p4);
            double right = getLength(p2, p3);
            double length1 = getLength(p1, p2);
            double length2 = getLength(p1, p3);
            if (left == right && length1 ==length2) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static double getLength(Point p1, Point p2) {
        return Math.pow(Math.abs(p2.x - p1.x), 2) + Math.pow(Math.abs(p2.y - p1.y), 2);
    }
}
