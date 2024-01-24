package week11;

import java.util.*;
import java.io.*;

public class 나는기말고사형인간이야_23254 {

    static class TestInfo {

        int idx;
        int plus;

        public TestInfo(int idx) {
            this.idx = idx;
        }

        public void setPlus() {
            if (a[idx] + b[idx] > 100) {

                plus = 100 - a[idx];

            } else {
                plus = b[idx];
            }
        }
    }


    static int[] a;
    static int[] b;
    static int N;
    static int M;
    static PriorityQueue<TestInfo> testInfos;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new int[M];
        b = new int[M];
        N*= 24;

        testInfos = new PriorityQueue<>(M, new Comparator<TestInfo>() {
            @Override
            public int compare(TestInfo o1, TestInfo o2) {
                return o2.plus - o1.plus;
            }
        });
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int plusPerTime = Integer.parseInt(st.nextToken());
            b[i] = plusPerTime;
            TestInfo testInfo = new TestInfo(i);
            testInfo.setPlus();
            testInfos.add(testInfo);
        }

        for (int i = 0; i < N; i++) {
            TestInfo testInfo = testInfos.poll();
            int idx = testInfo.idx;
            a[idx] += b[idx];
            testInfo.setPlus();
            testInfos.add(testInfo);
        }

        int sum = testInfos.stream().mapToInt(
                testInfo -> {
                    if (a[testInfo.idx] >= 100) {
                        return 100;
                    } else {
                        return a[testInfo.idx];
                    }
                }
        ).sum();
        System.out.println(sum);
    }



}
