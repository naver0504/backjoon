package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 순회강연_2109 {

    static class Lecture {
        int day;
        int pay;

        public Lecture(int pay, int day) {
            this.day = day;
            this.pay = pay;
        }
    }

    static int N;
    static Lecture[] lectures;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lectures = new Lecture[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Lecture lecture = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            lectures[i] = lecture;
        }

        Arrays.sort(lectures, (o1, o2) -> {
            if (o1.pay == o2.pay) {
                return o1.day - o2.day;
            } else {
                return o2.pay - o1.pay;
            }
        });

        boolean[] visited = new boolean[10001];

        int ans = 0;

        for (int i = 0; i < N; i++) {
            Lecture lecture = lectures[i];
            int day = lecture.day;
            int pay = lecture.pay;
            for (int j = day; j > 0; j--) {
                    if (!visited[j]) {
                        ans += pay;
                        visited[j] = true;
                        break;
                    }
                }
            }

        System.out.println(ans);

    }
}



