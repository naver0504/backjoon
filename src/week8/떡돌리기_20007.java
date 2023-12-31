package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 떡돌리기_20007 {

    static class House implements Comparable<House>{
        int from;
        int distance;

        public House(int from, int distance) {
            super();
            this.from = from;
            this.distance = distance;
        }

        @Override
        public int compareTo(House o) {
            return Integer.compare(this.distance, o.distance);
        }
    }
    static int N;
    static int M;
    static int X;
    static int Y;

    static List<House>[] houses;
    static int[] distances;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        houses = new ArrayList[N];

        distances = new int[N];

        for (int i = 0; i < N; i++) {
            houses[i] = new ArrayList<House>();

        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());


            houses[a].add(new House(b, d));
            houses[b].add(new House(a, d));

        }

        dijkstra();

        Arrays.sort(distances);
        int result = 1;
        int totalDistance = 0;
        for (int i = 1; i < N; i++) {
            if (distances[i] * 2 > X) {
                result = -1;
                break;
            }

            if (totalDistance + distances[i] * 2 > X) {
                result++;
                totalDistance = 0;
                i--;
                continue;
            }

            totalDistance += distances[i] * 2;

        }

        System.out.println(result);


    }

    private static void dijkstra() {

        Arrays.fill(distances, Integer.MAX_VALUE);

        boolean[] visited = new boolean[N];
        PriorityQueue<House> pq = new PriorityQueue<>();

        distances[Y] = 0;

        pq.add(new House(Y, 0));

        while (!pq.isEmpty()) {

            House poll = pq.poll();
            if(visited[poll.from] == true) continue;

            for (House house : houses[poll.from]) {

                if (visited[house.from] == false && distances[house.from] > distances[poll.from] + house.distance) {
                    distances[house.from] = distances[poll.from] + house.distance;
                    pq.add(new House(house.from, distances[house.from]));
                }
            }

            visited[poll.from] = true;
        }
    }
}
