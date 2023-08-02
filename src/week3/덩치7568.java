package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 덩치7568 {


    static class Person {

        int weight;
        int height;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }



    }

    static ArrayList<Person> list;
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        list = new ArrayList<Person>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            list.add(new Person(weight, height));
        }
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < N; i++) {
            int rank = 1;
            Person left = list.get(i);
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                Person right = list.get(j);
                if (left.weight < right.weight && left.height < right.height) {
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }

        System.out.println(sb);




    }
}
