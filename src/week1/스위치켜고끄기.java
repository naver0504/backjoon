package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 스위치켜고끄기 {
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = getLine(br.readLine());
        int n = getInteger(st.nextToken());
        array = new int[n + 1];
        st = getLine(br.readLine());
        for (int i = 1; i <= n; i++) {
            array[i] = getInteger(st.nextToken());
        }
        int studentNumber = getInteger(getLine(br.readLine()).nextToken());
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < studentNumber; i++) {
            st = getLine(br.readLine());
            Person newPerson = new Person(getInteger(st.nextToken()), getInteger(st.nextToken()));
            list.add(newPerson);
        }

        for (int i = 0; i < studentNumber; i++) {
            Person person = list.get(i);
            if (person.getGender() == 1) {
                int j = 1;
                int personNumber = person.getNumber();
                while (personNumber * j <= n) {
                    manSwitchArray(j, personNumber);
                    j++;
                }
            } else {
                int j = 0;
                int personNumber = person.getNumber();
                while (personNumber  + j <= n && personNumber  - j >= 1) {
                    int right = array[personNumber  + j];
                    int left = array[personNumber  - j];
                    if (right == left) {
                        womanSwitchArray(j, personNumber);
                        j++;
                    } else {
                        break;
                    }
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {

            sb.append(array[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);



    }

    private static void womanSwitchArray(int i, int personNumber) {
        if (array[personNumber + i] == 0) {
            array[personNumber + i] = 1;
            array[personNumber - i] = 1;

        }
        else  {
            array[personNumber + i] = 0;
            array[personNumber - i] = 0;

        }
    }

    private static void manSwitchArray(int i, int personNumber) {
        if (array[personNumber * i] == 0) {
            array[personNumber * i] = 1;
        }
        else  {
            array[personNumber * i] = 0;
        }
    }
    static class Person {
      int gender;
      int number;


        public int getGender() {
            return gender;
        }

        public int getNumber() {
            return number;
        }

        public Person(int gender, int number) {
            this.gender = gender;
            this.number = number;
        }
    }



    private static StringTokenizer getLine(String line) throws IOException {
        return new StringTokenizer(line);
    }

    private static int getInteger(String value) {
        return Integer.parseInt(value);
    }
}
