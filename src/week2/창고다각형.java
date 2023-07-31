package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 창고다각형 {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] array = new int[1001][1001];
    static List<Point> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int maxHeight = 0;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, y);
            list.add(new Point(x, y));
        }
        list.sort((o1, o2) -> o1.x - o2.x);


        Stack<Point> stack = new Stack<>();

        boolean up = true;

        int tmpMaxHeight = list.get(0).y;
        int result = 0;
        stack.push(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            if (maxHeight == tmpMaxHeight) {
                break;
            }
            Point left = stack.pop();
            Point right = list.get(i);
            if (tmpMaxHeight < maxHeight) {
                if (right.y >= left.y) {
                    result += (right.x - left.x) * left.y;
                    stack.push(right);
                    tmpMaxHeight = Math.max(tmpMaxHeight, right.y);
                } else {
                    stack.push(left);
                }
            }
        }

        Point leftTop = stack.pop();
        tmpMaxHeight = list.get(N - 1).y;
        stack.push(list.get(N - 1));
        for (int i = N - 2; i >= 0; i--) {
            if (maxHeight == tmpMaxHeight) {
                break;
            }
            Point right = stack.pop();
            Point left = list.get(i);
            if (tmpMaxHeight < maxHeight) {
                if (left.y >= right.y) {
                    result += (right.x - left.x) * right.y;
                    stack.push(left);
                    tmpMaxHeight = Math.max(tmpMaxHeight, left.y);
                } else {
                    stack.push(right);
                }
            }
        }
        Point rightTop = stack.pop();
        if (rightTop.x == leftTop.x) {
            result += maxHeight;
        } else {
            result += (rightTop.x + 1 - leftTop.x) * maxHeight;
        }

        System.out.println(result);


    }
}
