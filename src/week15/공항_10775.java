package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 공항_10775 {

    static Map<Integer, Integer> map;


    static int G;
    static int P;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        arr = new int[G + 1];
        int ans = 0;
        for (int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());
            int port;

            if (map.containsKey(g)) {
                port = map.get(g) - 1;
            } else {
                port = g;
            }
            while (port > 0) {
                if (arr[port] == 0) {
                    arr[port] = 1;
                    ans++;
                    break;
                }
                port--;
            }

            map.put(g, port);

            if (port == 0) {
                System.out.println(ans);
                return;
            }

        }

        System.out.println(ans);



    }
}
