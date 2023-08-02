package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 회의실배정1931 {

    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static ArrayList<Meeting> list;
    static int N;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        list = new ArrayList<Meeting>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Meeting(start, end));
        }

        list.sort(new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if (o1.end != o2.end) {
                    return o1.end - o2.end;
                } else {
                    return  o1.start - o2.start;
                }
            }
        });

        int start = list.get(0).start;
        int end = list.get(0).end;
        int result = 1;
        for (int i = 1; i < N; i++) {
            Meeting meeting = list.get(i);
            if (meeting.start >= end && meeting.start >= start) {
                start = meeting.start;
                end = meeting.end;

                result++;
            }
        }

        System.out.println(result);

    }
}
