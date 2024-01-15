package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드정렬하기_1715 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }
        long result = 0L;
        for (int i = 0; i < n - 1; i++) {
            Long left = pq.poll();
            Long right = pq.poll();
            result += left + right;
            pq.add(left + right);
        }

        System.out.println(result);

    }
}
