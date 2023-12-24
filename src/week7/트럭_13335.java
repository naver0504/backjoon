package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 트럭_13335 {


    static class Bus {
        int remainTime;
        int idx;

        public Bus(int remainTime, int idx) {
            this.remainTime = remainTime;
            this.idx = idx;
        }
    }


    static int N;
    static int W;
    static int L;
    static int totalWeight = 0;
    static int point = 0;

    static Queue<Bus> q = new LinkedList<>();
    static int[] bus;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        bus = new int[N];
        st = new StringTokenizer(br.readLine());
        int i = 0;
        while (st.hasMoreTokens()) {
            bus[i++] = Integer.parseInt(st.nextToken());
        }

        int result = 1;
        q.add(new Bus(W, point));
        totalWeight += bus[point++];

        while (q.size() != 0) {
            List<Bus> list = q.stream().collect(Collectors.toList());
            list.forEach(
                    tmp -> {
                        if (--tmp.remainTime == 0) {
                            q.poll();
                            totalWeight -= bus[tmp.idx];
                        }
                    }
            );

            if (point < N && totalWeight + bus[point] <= L) {
                q.add(new Bus(W, point));
                totalWeight += bus[point++];
            }
            result++;
        }

        System.out.println(result);
    }
}
